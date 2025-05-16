package pl.radoslawkarwacki.hmt.ai.impl;

import lombok.Getter;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.ChatClientResponse;
import org.springframework.ai.chat.messages.AbstractMessage;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.model.Generation;
import org.springframework.ai.chat.prompt.ChatOptions;
import org.springframework.stereotype.Service;
import pl.radoslawkarwacki.hmt.ai.ChatGptService;

import java.util.Optional;

@Service
public class ChatGptServiceImpl implements ChatGptService {

    @Getter
    public enum GptModel {
        GPT_4_1("gpt-4.1"),
        GPT_4_1_MINI("gpt-4.1-mini"),
        GPT_4_1_NANO("gpt-4.1-nano");

        private final String modelName;

        GptModel(String modelName) {
            this.modelName = modelName;
        }
    }

    private final ChatModel chatModel;

    public ChatGptServiceImpl(ChatModel chatModel) {
        this.chatModel = chatModel;
    }

    @Override
    public String answerGpt(String systemPrompt, String userPrompt) {
        return getAnswer(systemPrompt, userPrompt, GptModel.GPT_4_1);
    }

    @Override
    public String answerGptMini(String systemPrompt, String userPrompt) {
        return getAnswer(systemPrompt, userPrompt, GptModel.GPT_4_1_MINI);
    }

    @Override
    public String answerGptNano(String systemPrompt, String userPrompt) {
        return getAnswer(systemPrompt, userPrompt, GptModel.GPT_4_1_NANO);
    }

    String getAnswer(String systemPrompt, String userPrompt, GptModel model) {
        return Optional.of(createChatClient(model, systemPrompt))
                .map(client -> client.prompt(userPrompt))
                .map(ChatClient.ChatClientRequestSpec::call)
                .map(ChatClient.CallResponseSpec::chatClientResponse)
                .map(ChatClientResponse::chatResponse)
                .map(ChatResponse::getResult)
                .map(Generation::getOutput)
                .map(AbstractMessage::getText)
                .orElse("");
    }

    private ChatClient createChatClient(GptModel model, String systemPrompt) {
        return ChatClient.builder(chatModel)
                .defaultOptions(buildOptions(model))
                .defaultSystem(systemPrompt)
                .build();
    }

    private static ChatOptions buildOptions(GptModel model) {
        return ChatOptions.builder()
                .model(model.getModelName())
                .build();
    }
}