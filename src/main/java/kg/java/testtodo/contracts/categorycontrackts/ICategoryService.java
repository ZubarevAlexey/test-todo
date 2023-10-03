package kg.java.testtodo.contracts.categorycontrackts;

import kg.java.testtodo.exceptions.EntityDuplicateExceptions;
import kg.java.testtodo.exceptions.EntityNotFoundException;
import kg.java.testtodo.models.dtos.category.*;
import kg.java.testtodo.models.dtos.user.*;
import org.springframework.http.HttpStatus;

public interface ICategoryService {
    CategoryDto add(CreatedCategoryDto model) throws EntityDuplicateExceptions,EntityNotFoundException;

    CategoryDto update(UpdateCategoryDto model) throws EntityNotFoundException,EntityDuplicateExceptions;

    HttpStatus delete(DeleteCategoryDto model)throws EntityNotFoundException;

    CategoryDto getById(FindByIdCategoryDto model) throws EntityNotFoundException;
}
