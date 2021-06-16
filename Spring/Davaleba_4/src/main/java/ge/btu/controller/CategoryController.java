package ge.btu.controller;

import ge.btu.dto.category.AddCategoryInput;
import ge.btu.dto.category.CategoryDTO;
import ge.btu.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("api")
public class CategoryController {


    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("categories")
    public List<CategoryDTO> getAllMovies() {
        return categoryService.getCategories();
    }


    @PostMapping("addCategory")
    public CategoryDTO addMovie(@RequestBody @Validated AddCategoryInput addCategoryInput) {
        return categoryService.addCategory(addCategoryInput);
    }

}
