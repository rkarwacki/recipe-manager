package pl.radoslawkarwacki.hmt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.radoslawkarwacki.hmt.dto.RecipeDetailsDto;
import pl.radoslawkarwacki.hmt.dto.RecipeDto;
import pl.radoslawkarwacki.hmt.model.Recipe;
import pl.radoslawkarwacki.hmt.service.RecipeService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/recipes")
public class RecipeController {

    private RecipeService recipeService;

    @Autowired
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping
    public ResponseEntity<Iterable<RecipeDto>> getAll() throws InterruptedException {
        Thread.sleep(800);
        return new ResponseEntity<>(recipeService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<Iterable<RecipeDto>> getAllByCategory(@PathVariable("id") Long recipeCategoryId) {
        return new ResponseEntity<>(recipeService.findAllByRecipeCategoryId(recipeCategoryId), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<RecipeDto> update(@RequestBody RecipeDto recipe) {
        return new ResponseEntity<>(recipeService.save(recipe), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<RecipeDto> create(@RequestBody RecipeDto recipe) {
        return new ResponseEntity<>(recipeService.save(recipe), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id) {
        recipeService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecipeDetailsDto> getById(@PathVariable("id") Long id) throws InterruptedException {
        Thread.sleep(800);
        return recipeService.findById(id)
                .map(recipe -> new ResponseEntity<>(recipe, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
