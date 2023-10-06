package kg.java.testtodo.core.mappers.categorymapper;

import kg.java.testtodo.core.models.dtos.category.CategoryDto;
import kg.java.testtodo.core.models.dtos.category.CreatedCategoryDto;
import kg.java.testtodo.core.models.dtos.category.UpdateCategoryDto;
import kg.java.testtodo.core.models.dtos.user.UserSearchDataDto;
import kg.java.testtodo.core.models.entity.Category;

public class CategoryMapper {

    public CategoryDto toDomain(Category model){
        var user = model.getUser();
        return CategoryDto.builder()
                .id(model.getId())
                .name(model.getName())
                .user(UserSearchDataDto.builder()
                        .email(user.getEmail())
                        .name(user.getName())
                        .build())
                .build();
    }
    public Category fromDomain(CreatedCategoryDto model){
        return Category.builder()
                .name(model.getName())
                .build();
    }
    public Category fromDomain(UpdateCategoryDto model){
        return Category.builder()
                .id(model.getId())
                .name(model.getName())
                .build();
    }
}
