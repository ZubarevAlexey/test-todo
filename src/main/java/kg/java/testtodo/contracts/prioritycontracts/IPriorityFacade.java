package kg.java.testtodo.contracts.prioritycontracts;

import kg.java.testtodo.exceptions.EntityDuplicateExceptions;
import kg.java.testtodo.exceptions.EntityNotFoundException;
import kg.java.testtodo.models.dtos.priority.*;
import org.springframework.http.HttpStatus;

public interface IPriorityFacade {

    PriorityDto register(CreatedPriorityDto model) throws EntityDuplicateExceptions, EntityNotFoundException;

    PriorityDto update(UpdatedPriorityDto model) throws EntityDuplicateExceptions, EntityNotFoundException;

    HttpStatus delete(DeletePriorityDto model) throws EntityNotFoundException;

    PriorityDto getById(FindByIdPriorityDto model) throws EntityNotFoundException;
}
