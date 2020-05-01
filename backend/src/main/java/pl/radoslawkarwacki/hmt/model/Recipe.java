package pl.radoslawkarwacki.hmt.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Recipe {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "recipe_name")
    private String recipeName;

    private int kcal;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recipe_category_id")
    private RecipeCategory recipeCategory;

//    private String imagePath;

}
