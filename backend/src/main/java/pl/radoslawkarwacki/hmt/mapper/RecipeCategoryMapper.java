package pl.radoslawkarwacki.hmt.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pl.radoslawkarwacki.hmt.dto.RecipeCategoryDto;
import pl.radoslawkarwacki.hmt.model.RecipeCategory;

@Mapper
public interface RecipeCategoryMapper {

    RecipeCategoryMapper INSTANCE = Mappers.getMapper(RecipeCategoryMapper.class);

    RecipeCategoryDto toRecipeCategoryDto(RecipeCategory recipeCategory);

    @InheritInverseConfiguration
    RecipeCategory toRecipeCategory(RecipeCategoryDto recipeDto);
}