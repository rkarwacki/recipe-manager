package pl.radoslawkarwacki.hmt.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import pl.radoslawkarwacki.hmt.dto.RecipeDetailsDto;
import pl.radoslawkarwacki.hmt.model.Recipe;

@Mapper(uses = RecipeCategoryMapper.class)
public interface RecipeDetailsMapper {

    RecipeDetailsMapper INSTANCE = Mappers.getMapper(RecipeDetailsMapper.class);

    @Mapping(target = "name", source = "recipeName")
    @Mapping(target = "recipeCategoryDto", source = "recipeCategory")
    @Mapping(target = "kcal")
    RecipeDetailsDto toRecipeDto(Recipe recipe);

    @InheritInverseConfiguration
    Recipe toRecipe(RecipeDetailsDto recipeDto);


//    RecipeCategoryDto toRecipeCategoryDto(RecipeCategory recipeCategory);
//    RecipeCategory toRecipeCategory(RecipeCategoryDto recipeDto);

}
