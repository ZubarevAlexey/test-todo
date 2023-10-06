package kg.java.testtodo.core.contracts.facades;

import kg.java.testtodo.core.models.dtos.category.*;
import kg.java.testtodo.core.exceptions.EntityDuplicateExceptions;
import kg.java.testtodo.core.exceptions.EntityNotFoundException;
import org.springframework.http.HttpStatus;

public interface ICategoryFacade {
    CategoryDto get(FindByIdCategoryDto model) throws EntityNotFoundException;
    CategoryDto register(CreatedCategoryDto model) throws EntityDuplicateExceptions, EntityNotFoundException;
    CategoryDto update(UpdateCategoryDto model) throws EntityDuplicateExceptions,EntityNotFoundException;

    HttpStatus delete(DeleteCategoryDto model) throws EntityNotFoundException;
}
