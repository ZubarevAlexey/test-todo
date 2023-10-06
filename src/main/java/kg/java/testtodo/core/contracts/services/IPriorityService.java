package kg.java.testtodo.core.contracts.services;

import kg.java.testtodo.core.models.dtos.priority.*;
import kg.java.testtodo.core.exceptions.EntityDuplicateExceptions;
import kg.java.testtodo.core.exceptions.EntityNotFoundException;
import org.springframework.http.HttpStatus;

public interface IPriorityService {
    PriorityDto add(CreatedPriorityDto model) throws EntityDuplicateExceptions, EntityNotFoundException;

    PriorityDto update(UpdatedPriorityDto model) throws EntityNotFoundException,EntityDuplicateExceptions;

    HttpStatus delete(DeletePriorityDto model)throws EntityNotFoundException;

    PriorityDto getById(FindByIdPriorityDto model) throws EntityNotFoundException;
}
