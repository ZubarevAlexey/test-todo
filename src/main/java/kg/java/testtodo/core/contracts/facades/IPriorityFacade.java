package kg.java.testtodo.core.contracts.facades;

import kg.java.testtodo.core.models.dtos.priority.*;
import kg.java.testtodo.core.exceptions.EntityDuplicateExceptions;
import kg.java.testtodo.core.exceptions.EntityNotFoundException;
import org.springframework.http.HttpStatus;

public interface IPriorityFacade {

    PriorityDto register(CreatedPriorityDto model) throws EntityDuplicateExceptions, EntityNotFoundException;

    PriorityDto update(UpdatedPriorityDto model) throws EntityDuplicateExceptions, EntityNotFoundException;

    HttpStatus delete(DeletePriorityDto model) throws EntityNotFoundException;

    PriorityDto getById(FindByIdPriorityDto model) throws EntityNotFoundException;
}
