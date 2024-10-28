package pl.radoslawkarwacki.hmt.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "recipe_step")
public class RecipeStep extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "recipe_id")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Recipe recipe;

    @NotNull
    @Min(1)
    @Column(name = "step_number")
    private int stepNumber;

    @NotBlank
    @Column(name = "step_description")
    private String stepDescription;

}