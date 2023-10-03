package kg.java.testtodo.contracts.categorycontrackts;

import kg.java.testtodo.exceptions.EntityDuplicateExceptions;
import kg.java.testtodo.exceptions.EntityNotFoundException;
import kg.java.testtodo.models.dtos.category.*;
import kg.java.testtodo.models.dtos.user.*;
import org.springframework.http.HttpStatus;

public interface ICategoryFacade {
    CategoryDto get(FindByIdCategoryDto model) throws EntityNotFoundException;
    CategoryDto register(CreatedCategoryDto model) throws EntityDuplicateExceptions, EntityNotFoundException;
    CategoryDto update(UpdateCategoryDto model) throws EntityDuplicateExceptions,EntityNotFoundException;

    HttpStatus delete(DeleteCategoryDto model) throws EntityNotFoundException;
}
