package kg.java.testtodo.core.contracts.facades;

import kg.java.testtodo.core.exceptions.EntityDuplicateExceptions;
import kg.java.testtodo.core.exceptions.EntityNotFoundException;
import kg.java.testtodo.core.models.dtos.priority.*;
import kg.java.testtodo.core.models.dtos.task.*;
import org.springframework.http.HttpStatus;

public interface ITaskFacade {

    TaskDto register(CreatedTaskDto model) throws EntityDuplicateExceptions, EntityNotFoundException;

    TaskDto update(UpdatedTaskDto model) throws EntityDuplicateExceptions, EntityNotFoundException;

    HttpStatus delete(DeleteTaskDto model) throws EntityNotFoundException;

    TaskDto getById(FindByIdTaskDto model) throws EntityNotFoundException;
}
