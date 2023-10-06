package kg.java.testtodo.domain.facades.taskfacade;

import kg.java.testtodo.core.contracts.facades.ITaskFacade;
import kg.java.testtodo.core.contracts.services.ITaskService;
import kg.java.testtodo.core.exceptions.EntityDuplicateExceptions;
import kg.java.testtodo.core.exceptions.EntityNotFoundException;
import kg.java.testtodo.core.models.dtos.task.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class TaskFacade implements ITaskFacade {

    private ITaskService taskService;

    public TaskFacade(ITaskService taskService) {
        this.taskService = taskService;
    }

    @Override
    public TaskDto register(CreatedTaskDto model) throws EntityDuplicateExceptions, EntityNotFoundException {
        return taskService.add(model);
    }

    @Override
    public TaskDto update(UpdatedTaskDto model) throws EntityDuplicateExceptions, EntityNotFoundException {
        return taskService.update(model);
    }

    @Override
    public HttpStatus delete(DeleteTaskDto model) throws EntityNotFoundException {
        return taskService.delete(model);
    }

    @Override
    public TaskDto getById(FindByIdTaskDto model) throws EntityNotFoundException {
        return taskService.getById(model);
    }
}
