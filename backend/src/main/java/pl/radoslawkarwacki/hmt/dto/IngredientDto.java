package pl.radoslawkarwacki.hmt.dto;

import lombok.Data;

@Data
public class IngredientDto {

    private Long id;

    private String ingredientName;

    private int amount;

    private String amountUnit;

    private String amountHint;
}