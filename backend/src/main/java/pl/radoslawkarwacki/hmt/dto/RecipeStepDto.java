package pl.radoslawkarwacki.hmt.dto;

import lombok.Data;

@Data
public class RecipeStepDto {

    private Long id;

    private int stepNumber;

    private String stepDescription;
}