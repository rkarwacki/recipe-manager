package pl.radoslawkarwacki.hmt.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.radoslawkarwacki.hmt.model.Recipe;

@Repository
public interface RecipeRepository extends CrudRepository<Recipe, Long> {
    Iterable<Recipe> findAllByRecipeCategoryId(Long recipeCategoryId);
}
