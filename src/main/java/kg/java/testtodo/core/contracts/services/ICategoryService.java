package kg.java.testtodo.core.contracts.services;

import kg.java.testtodo.core.models.dtos.category.*;
import kg.java.testtodo.core.exceptions.EntityDuplicateExceptions;
import kg.java.testtodo.core.exceptions.EntityNotFoundException;
import org.springframework.http.HttpStatus;

public interface ICategoryService {
    CategoryDto add(CreatedCategoryDto model) throws EntityDuplicateExceptions,EntityNotFoundException;

    CategoryDto update(UpdateCategoryDto model) throws EntityNotFoundException,EntityDuplicateExceptions;

    HttpStatus delete(DeleteCategoryDto model)throws EntityNotFoundException;

    CategoryDto getById(FindByIdCategoryDto model) throws EntityNotFoundException;
}
