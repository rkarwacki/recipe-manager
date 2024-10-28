package pl.radoslawkarwacki.hmt.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "ingredient")
public class Ingredient extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "recipe_id")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Recipe recipe;

    @NotBlank
    private String ingredientName;

    private int amount;

    @Column(name = "amount_unit")
    private String amountUnit;

    @Column(name = "amount_hint")
    private String amountHint;
}