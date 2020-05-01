package pl.radoslawkarwacki.hmt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.radoslawkarwacki.hmt.dto.RecipeDetailsDto;
import pl.radoslawkarwacki.hmt.dto.RecipeDto;
import pl.radoslawkarwacki.hmt.mapper.RecipeDetailsMapper;
import pl.radoslawkarwacki.hmt.mapper.RecipeMapper;
import pl.radoslawkarwacki.hmt.model.Recipe;
import pl.radoslawkarwacki.hmt.repository.RecipeRepository;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class RecipeServiceImpl implements RecipeService {

    private RecipeRepository recipeRepository;

    private RecipeMapper recipeMapper = RecipeMapper.INSTANCE;
    private RecipeDetailsMapper recipeDetailsMapper = RecipeDetailsMapper.INSTANCE;

    @Autowired
    public RecipeServiceImpl(RecipeRepository recipeRepository)  {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Iterable<RecipeDto> findAll() {
        return StreamSupport.stream(recipeRepository.findAll().spliterator(), false)
                .map(recipe -> recipeMapper.toRecipeDto(recipe))
                .sorted(Comparator.comparing(RecipeDto::getName))
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<RecipeDto> findAllByRecipeCategoryId(Long recipeCategoryId) {
        return StreamSupport.stream(recipeRepository.findAllByRecipeCategoryId(recipeCategoryId).spliterator(), false)
                .map(recipe -> recipeMapper.toRecipeDto(recipe))
                .collect(Collectors.toList());
    }

    @Override
    public RecipeDto save(RecipeDto recipeDto) {
        Recipe entity = recipeMapper.toRecipe(recipeDto);
        return recipeMapper.toRecipeDto(recipeRepository.save(entity));
    }

    @Override
    public void deleteById(Long id) {
        recipeRepository.deleteById(id);
    }

    @Override
    public Optional<RecipeDetailsDto> findById(Long id) {
        return recipeRepository.findById(id)
                .map(recipe -> recipeDetailsMapper.toRecipeDto(recipe));
    }
}
