package pl.radoslawkarwacki.hmt.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.radoslawkarwacki.hmt.dto.IngredientDto;
import pl.radoslawkarwacki.hmt.model.Ingredient;

@Mapper
public interface IngredientMapper {

    @Mapping(target = "id")
    @Mapping(target = "ingredientName")
    @Mapping(target = "amount")
    @Mapping(target = "amountUnit")
    @Mapping(target = "amountHint")
    IngredientDto fromIngredient(Ingredient ingredient);

    @InheritInverseConfiguration
    Ingredient fromIngredientDto(IngredientDto ingredientDto);
}