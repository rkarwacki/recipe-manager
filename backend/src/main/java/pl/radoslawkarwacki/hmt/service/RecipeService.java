package pl.radoslawkarwacki.hmt.service;

import org.springframework.stereotype.Service;
import pl.radoslawkarwacki.hmt.model.Recipe;

import java.util.List;
import java.util.Optional;

@Service
public interface RecipeService {

    List<Recipe> findAll();

    List<Recipe> findAllByRecipeCategoryId(Long recipeCategoryId);

    Recipe save(Recipe recipeDto);

    Recipe update(Recipe recipe);

    void deleteById(Long id);

    Optional<Recipe> findById(Long id);
}