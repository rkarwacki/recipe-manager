package pl.radoslawkarwacki.hmt.service;

import org.springframework.stereotype.Service;
import pl.radoslawkarwacki.hmt.dto.RecipeDetailsDto;
import pl.radoslawkarwacki.hmt.dto.RecipeDto;

import java.util.Optional;

@Service
public interface RecipeService {

    Iterable<RecipeDto> findAll();

    Iterable<RecipeDto> findAllByRecipeCategoryId(Long recipeCategoryId);

    RecipeDto save(RecipeDto recipeDto);

    void deleteById(Long id);

    Optional<RecipeDetailsDto> findById(Long id);
}
