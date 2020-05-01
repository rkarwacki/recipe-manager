package pl.radoslawkarwacki.hmt.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class RecipeDetailsDto {

    private Long id;
    private String name;
    private int kcal;
    @JsonProperty("category")
    private RecipeCategoryDto recipeCategoryDto;
}
