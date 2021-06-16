package ge.btu.service.impl;

import ge.btu.dto.category.AddCategoryInput;
import ge.btu.dto.category.CategoryDTO;
import ge.btu.model.Category;
import ge.btu.repository.CategoryRepository;
import ge.btu.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Override
    public CategoryDTO addCategory(AddCategoryInput addCategoryInput) {
        Category category = Category.builder()
                .title(addCategoryInput.getTitle())
                .build();

        return new CategoryDTO(categoryRepository.save(category));
    }

    @Override
    public List<CategoryDTO> getCategories() {
        List<Category> categories = categoryRepository.findAll();

        return categories.stream().map(CategoryDTO::new).collect(Collectors.toList());
    }
}
