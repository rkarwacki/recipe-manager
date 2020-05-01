package pl.radoslawkarwacki.hmt.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.radoslawkarwacki.hmt.model.RecipeCategory;

@Repository
public interface RecipeCategoryRepository extends CrudRepository<RecipeCategory, Long> {
}
