package kg.java.testtodo.core.contracts.services;

import kg.java.testtodo.core.exceptions.EntityDuplicateExceptions;
import kg.java.testtodo.core.exceptions.EntityNotFoundException;
import kg.java.testtodo.core.models.dtos.category.*;
import kg.java.testtodo.core.models.dtos.task.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


public interface ITaskService {
    TaskDto add(CreatedTaskDto model) throws EntityDuplicateExceptions, EntityNotFoundException;

    TaskDto update(UpdatedTaskDto model) throws EntityNotFoundException, EntityDuplicateExceptions;

    HttpStatus delete(DeleteTaskDto model) throws EntityNotFoundException;

    TaskDto getById(FindByIdTaskDto model) throws EntityNotFoundException;
}
