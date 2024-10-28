package pl.radoslawkarwacki.hmt.service;

import pl.radoslawkarwacki.hmt.model.Ingredient;

import java.util.List;

public interface IngredientService {
    List<Ingredient> findAllByRecipeId(Long recipeId);
    void synchronizeRecipeIngredients(List<Ingredient> ingredients, Long recipeId);
    List<Ingredient> saveAll(List<Ingredient> ingredients);
    Ingredient save(Ingredient ingredient);
}