package ge.btu.dto.category;

import ge.btu.model.Category;

public class CategoryDTO {

    public CategoryDTO(Category category) {
        this.id = category.getId();
        this.title = category.getTitle();
    }

    private Long id;

    private String title;

}
