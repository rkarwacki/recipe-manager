package pl.radoslawkarwacki.hmt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.radoslawkarwacki.hmt.dto.RecipeCategoryDto;
import pl.radoslawkarwacki.hmt.mapper.RecipeCategoryMapper;
import pl.radoslawkarwacki.hmt.model.RecipeCategory;
import pl.radoslawkarwacki.hmt.repository.RecipeCategoryRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/recipeCategories")
public class RecipeCategoryController {

    private RecipeCategoryRepository recipeCategoryRepository;

    private static RecipeCategoryMapper mapper = RecipeCategoryMapper.INSTANCE;

    @Autowired
    public RecipeCategoryController(RecipeCategoryRepository recipeCategoryRepository) {
        this.recipeCategoryRepository = recipeCategoryRepository;
    }

    @PostMapping
    public ResponseEntity<RecipeCategoryDto> save(@RequestBody RecipeCategoryDto recipeCategoryDto) {
        return saveRecipeCategory(recipeCategoryDto);
    }

    @PutMapping
    public ResponseEntity<RecipeCategoryDto> update(@RequestBody RecipeCategoryDto recipeCategoryDto) {
        return saveRecipeCategory(recipeCategoryDto);
    }

    private ResponseEntity<RecipeCategoryDto> saveRecipeCategory(@RequestBody RecipeCategoryDto recipeCategoryDto) {
        RecipeCategory recipeCategory = mapper.toRecipeCategory(recipeCategoryDto);
        RecipeCategory savedEntity = recipeCategoryRepository.save(recipeCategory);
        return new ResponseEntity<>(mapper.toRecipeCategoryDto(savedEntity), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Iterable<RecipeCategoryDto>> findAll () {
        Iterable<RecipeCategory> recipes = recipeCategoryRepository.findAll();
        List<RecipeCategoryDto> recipeCategoryDtos = StreamSupport.stream(recipes.spliterator(), false)
                .map(recipeCategory -> mapper.toRecipeCategoryDto(recipeCategory))
                .collect(Collectors.toList());
        return new ResponseEntity<>(recipeCategoryDtos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecipeCategoryDto> getById(@PathVariable("id") Long id) {
        return recipeCategoryRepository.findById(id)
                .map(recipeCategory -> mapper.toRecipeCategoryDto(recipeCategory))
                .map(recipeCategoryDto -> new ResponseEntity<>(recipeCategoryDto, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}