package pl.radoslawkarwacki.hmt.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import pl.radoslawkarwacki.hmt.dto.RecipeDto;
import pl.radoslawkarwacki.hmt.model.Recipe;

@Mapper(uses = RecipeCategoryMapper.class)
public interface RecipeMapper {

    RecipeMapper INSTANCE = Mappers.getMapper(RecipeMapper.class);

    @Mapping(target = "name", source = "recipeName")
    @Mapping(target = "kcal")
    @Mapping(target = "recipeCategoryDto", source = "recipeCategory")
    RecipeDto toRecipeDto(Recipe recipe);

    @InheritInverseConfiguration
    Recipe toRecipe(RecipeDto recipeDto);


//    RecipeCategoryDto toRecipeCategoryDto(RecipeCategory recipeCategory);
//    RecipeCategory toRecipeCategory(RecipeCategoryDto recipeDto);

}
