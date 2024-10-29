package pl.radoslawkarwacki.hmt.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class RecipeDetailsDto {

    private Long id;
    private String name;
    private int kcal;
    private int portions;
    @JsonProperty("category")
    private RecipeCategoryDto recipeCategoryDto;
    private String preparationDescription;
    private List<IngredientDto> ingredients;
}