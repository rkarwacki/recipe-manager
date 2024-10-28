package pl.radoslawkarwacki.hmt.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.radoslawkarwacki.hmt.model.Ingredient;
import pl.radoslawkarwacki.hmt.repository.IngredientRepository;
import pl.radoslawkarwacki.hmt.service.IngredientService;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class IngredientServiceImpl implements IngredientService {

    private IngredientRepository ingredientRepository;

    @Autowired
    public IngredientServiceImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public List<Ingredient> findAllByRecipeId(Long recipeId) {
        return ingredientRepository.findAllByRecipeId(recipeId)
                .stream()
                .sorted(Comparator.comparing(Ingredient::getIngredientName))
                .collect(Collectors.toList());
    }

    @Override
    public void synchronizeRecipeIngredients(List<Ingredient> ingredients, Long recipeId) {
        findAllByRecipeId(recipeId)
                .stream()
                .filter(ingredient -> !ingredients.contains(ingredient))
                .forEach(ingredient -> ingredientRepository.delete(ingredient));
    }

    @Override
    public List<Ingredient> saveAll(List<Ingredient> ingredients) {
        return null;
    }

    @Override
    public Ingredient save(Ingredient ingredient) {
        return null;
    }
}