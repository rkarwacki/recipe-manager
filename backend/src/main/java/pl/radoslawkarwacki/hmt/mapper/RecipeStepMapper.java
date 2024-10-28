package pl.radoslawkarwacki.hmt.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.radoslawkarwacki.hmt.dto.RecipeStepDto;
import pl.radoslawkarwacki.hmt.model.RecipeStep;

@Mapper
public interface RecipeStepMapper {

    @Mapping(target = "id")
    @Mapping(target = "stepNumber")
    @Mapping(target = "stepDescription")
    RecipeStepDto fromRecipeStep(RecipeStep recipeStep);

    @InheritInverseConfiguration
    RecipeStep fromRecipeStepDto(RecipeStepDto recipeStepDto);
}