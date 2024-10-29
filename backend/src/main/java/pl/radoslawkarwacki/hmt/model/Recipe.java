package pl.radoslawkarwacki.hmt.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "recipe")
public class Recipe extends BaseEntity {

    @Column(name = "recipe_name")
    @NotBlank
    private String recipeName;

    @Min(1)
    private int kcal;

    @Min(1)
    private int portions;

    @OneToMany(mappedBy = "recipe", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Ingredient> ingredients;

    @Column(name = "preparation_description", columnDefinition = "TEXT")
    @NotBlank
    private String preparationDescription;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recipe_category_id")
    @NotNull
    private RecipeCategory recipeCategory;
}