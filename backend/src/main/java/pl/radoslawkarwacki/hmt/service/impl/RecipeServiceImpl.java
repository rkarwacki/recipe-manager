package pl.radoslawkarwacki.hmt.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.radoslawkarwacki.hmt.model.Ingredient;
import pl.radoslawkarwacki.hmt.model.Recipe;
import pl.radoslawkarwacki.hmt.repository.RecipeRepository;
import pl.radoslawkarwacki.hmt.service.IngredientService;
import pl.radoslawkarwacki.hmt.service.RecipeService;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class RecipeServiceImpl implements RecipeService {

    private RecipeRepository recipeRepository;
    private IngredientService ingredientService;

    @Autowired
    public RecipeServiceImpl(RecipeRepository recipeRepository, IngredientService ingredientService)  {
        this.recipeRepository = recipeRepository;
        this.ingredientService = ingredientService;
    }

    @Override
    public List<Recipe> findAll() {
        return StreamSupport.stream(recipeRepository.findAll().spliterator(), false)
                .sorted(Comparator.comparing(Recipe::getRecipeName))
                .collect(Collectors.toList());
    }

    @Override
    public List<Recipe> findAllByRecipeCategoryId(Long recipeCategoryId) {
        return recipeRepository.findAllByRecipeCategoryId(recipeCategoryId);
    }

    @Override
    public Recipe save(Recipe recipe) {
        recipe.getIngredients().forEach(ingredient -> ingredient.setRecipe(recipe));
        return recipeRepository.save(recipe);
    }

    @Override
    public Recipe update(Recipe recipe) {
        List<Ingredient> currentIngredients = recipe.getIngredients();
        currentIngredients.forEach(ingredient -> ingredient.setRecipe(recipe));
        ingredientService.synchronizeRecipeIngredients(currentIngredients, recipe.getId());
        return recipeRepository.save(recipe);
    }

    @Override
    public void deleteById(Long id) {
        recipeRepository.deleteById(id);
    }

    @Override
    public Optional<Recipe> findById(Long id) {
        return recipeRepository.findById(id);
    }
}