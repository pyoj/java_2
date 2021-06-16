package ge.btu.service;

import ge.btu.dto.category.AddCategoryInput;
import ge.btu.dto.category.CategoryDTO;
import ge.btu.dto.movie.MovieDTO;

import java.util.List;

public interface CategoryService {

    CategoryDTO addCategory(AddCategoryInput addCategoryInput);

    List<CategoryDTO> getCategories();

}
