package pl.radoslawkarwacki.hmt.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class RecipeDto {

    private Long id;
    private String name;
    private int kcal;
    private int portions;
    @JsonProperty("category")
    private RecipeCategoryDto recipeCategoryDto;
}