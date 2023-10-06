package kg.java.testtodo.domain.services.taskservice;

import kg.java.testtodo.core.contracts.services.ITaskService;
import kg.java.testtodo.core.exceptions.EntityDuplicateExceptions;
import kg.java.testtodo.core.exceptions.EntityNotFoundException;
import kg.java.testtodo.core.mappers.taskmapper.TaskMapper;
import kg.java.testtodo.core.models.dtos.task.*;
import kg.java.testtodo.data.repo.CategoryRepository;
import kg.java.testtodo.data.repo.PriorityRepository;
import kg.java.testtodo.data.repo.TaskRepository;
import kg.java.testtodo.data.repo.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class TaskService implements ITaskService {

    private final UserRepository userRepository;
    private final PriorityRepository priorityRepository;
    private final CategoryRepository categoryRepository;
    private final TaskRepository taskRepository;
    private TaskMapper taskMapper;

    public TaskService(UserRepository userRepository, PriorityRepository priorityRepository,
                       CategoryRepository categoryRepository, TaskRepository taskRepository, TaskMapper taskMapper) {
        this.userRepository = userRepository;
        this.priorityRepository = priorityRepository;
        this.categoryRepository = categoryRepository;
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
    }

    @Override
    public TaskDto add(CreatedTaskDto model) throws EntityDuplicateExceptions, EntityNotFoundException {
        var task = taskRepository.findTaskByTitle(model.getTitle());
        if (task.isPresent()) throw new EntityDuplicateExceptions();
        var user = userRepository.findById(model.getUserId()).orElseThrow(EntityNotFoundException::new);
        var category = categoryRepository.findById(model.getCategoryId()).orElseThrow(EntityNotFoundException::new);
        var priority = priorityRepository.findById(model.getPriorityId()).orElseThrow(EntityNotFoundException::new);
        var entity = taskMapper.fromDomain(model);
        entity.setUser(user);
        entity.setCategory(category);
        entity.setPriority(priority);
        entity = taskRepository.save(entity);
        return taskMapper.toDomain(entity);
    }

    @Override
    public TaskDto update(UpdatedTaskDto model) throws EntityNotFoundException, EntityDuplicateExceptions {
        var task = taskRepository.findById(model.getId()).orElseThrow(EntityNotFoundException::new);
        var category = categoryRepository.findById(model.getCategoryId()).orElseThrow(EntityNotFoundException::new);
        var priority = priorityRepository.findById(model.getPriorityId()).orElseThrow(EntityNotFoundException::new);
        var user = userRepository.findById(model.getUserId()).orElseThrow(EntityNotFoundException::new);
        var entity = task.toBuilder()
                .id(model.getId())
                .title(model.getTitle())
                .taskDate(model.getTaskDate())
                .completed(model.getCompleted())
                .category(category)
                .priority(priority)
                .user(user)
                .build();
        taskRepository.save(entity);
        return taskMapper.toDomain(entity);
    }

    @Override
    public HttpStatus delete(DeleteTaskDto model) throws EntityNotFoundException {
        var task = taskRepository.findById(model.getId()).orElseThrow(EntityNotFoundException::new);
        taskRepository.deleteById(task.getId());
        return HttpStatus.OK;
    }

    @Override
    public TaskDto getById(FindByIdTaskDto model) throws EntityNotFoundException {
        var task = taskRepository.findById(model.getId()).orElseThrow(EntityNotFoundException::new);
        return taskMapper.toDomain(task);

    }
}
