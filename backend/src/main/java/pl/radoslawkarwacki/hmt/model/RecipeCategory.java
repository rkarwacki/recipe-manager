package pl.radoslawkarwacki.hmt.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "recipe_category")
public class RecipeCategory extends BaseEntity {

    @Column(unique = true, name = "category_name")
    @NotBlank
    private String name;
}