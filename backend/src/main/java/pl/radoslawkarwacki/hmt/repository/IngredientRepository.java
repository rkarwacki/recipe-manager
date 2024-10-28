package pl.radoslawkarwacki.hmt.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.radoslawkarwacki.hmt.model.Ingredient;

import java.util.List;

@Repository
public interface IngredientRepository extends CrudRepository<Ingredient, Long> {

    List<Ingredient> findAllByRecipeId(Long recipeId);
}