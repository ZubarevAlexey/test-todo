package kg.java.testtodo.core.mappers.categorymapper;

import kg.java.testtodo.core.models.dtos.category.CategoryDto;
import kg.java.testtodo.core.models.dtos.category.CreatedCategoryDto;
import kg.java.testtodo.core.models.dtos.category.UpdateCategoryDto;
import kg.java.testtodo.core.models.entity.Category;

public class CategoryMapper {

    public CategoryDto toDomain(Category model){
        return CategoryDto.builder()
                .id(model.getId())
                .name(model.getName())
                .userId(model.getUserId())
                .build();
    }
    public Category fromDomain(CreatedCategoryDto model){
        return Category.builder()
                .name(model.getName())
                .userId(model.getUserId())
                .build();
    }
    public Category fromDomain(UpdateCategoryDto model){
        return Category.builder()
                .id(model.getId())
                .name(model.getName())
                .userId(model.getUserId())
                .build();
    }
}