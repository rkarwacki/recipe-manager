package pl.radoslawkarwacki.hmt.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import pl.radoslawkarwacki.hmt.dto.RecipeDetailsDto;
import pl.radoslawkarwacki.hmt.dto.RecipeDto;
import pl.radoslawkarwacki.hmt.model.Recipe;

@Mapper(uses = {RecipeCategoryMapper.class, IngredientMapper.class})
public interface RecipeMapper {

    RecipeMapper INSTANCE = Mappers.getMapper(RecipeMapper.class);

    @Mapping(target = "name", source = "recipeName")
    @Mapping(target = "recipeCategoryDto", source = "recipeCategory")
    RecipeDto toRecipeDto(Recipe recipe);

    @InheritInverseConfiguration
    Recipe toRecipe(RecipeDto recipeDto);

    @Mapping(target = "name", source = "recipe.recipeName")
    @Mapping(target = "recipeCategoryDto", source = "recipe.recipeCategory")
    @Mapping(target = "kcal")
    @Mapping(target = "portions")
    @Mapping(target = "preparationDescription")
    @Mapping(target = "ingredients")
    RecipeDetailsDto toRecipeDetailsDto(Recipe recipe);

    @InheritInverseConfiguration
    Recipe toRecipe(RecipeDetailsDto recipeDto);
}