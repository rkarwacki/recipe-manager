package pl.radoslawkarwacki.hmt.ai;

public interface ChatGptService {
    String answerGpt(String systemPrompt, String userPrompt);
    String answerGptMini(String systemPrompt, String userPrompt);
    String answerGptNano(String systemPrompt, String userPrompt);
}
