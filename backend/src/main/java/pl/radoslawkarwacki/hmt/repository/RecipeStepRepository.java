package pl.radoslawkarwacki.hmt.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.radoslawkarwacki.hmt.model.RecipeStep;

import java.util.List;

@Repository
public interface RecipeStepRepository extends CrudRepository<RecipeStep, Long> {
    List<RecipeStep> findAllByRecipeId(Long recipeId);
}