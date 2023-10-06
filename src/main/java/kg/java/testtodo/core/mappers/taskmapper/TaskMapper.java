package kg.java.testtodo.core.mappers.taskmapper;

import kg.java.testtodo.core.models.dtos.category.CategorySearchDataDto;
import kg.java.testtodo.core.models.dtos.priority.PrioritySearchDataDto;
import kg.java.testtodo.core.models.dtos.task.CreatedTaskDto;
import kg.java.testtodo.core.models.dtos.task.TaskDto;
import kg.java.testtodo.core.models.dtos.task.UpdatedTaskDto;
import kg.java.testtodo.core.models.dtos.user.UserSearchDataDto;
import kg.java.testtodo.core.models.entity.Task;

public class TaskMapper {

    public TaskDto toDomain(Task model){
        var user = model.getUser();
        var priority = model.getPriority();
        var category = model.getCategory();
        return TaskDto.builder()
                .id(model.getId())
                .title(model.getTitle())
                .completed(model.getCompleted())
                .taskDate(model.getTaskDate())
                .user(UserSearchDataDto.builder()
                        .name(user.getName())
                        .email(user.getEmail()).build())
                .category(CategorySearchDataDto.builder()
                        .name(category.getName())
                        .build())
                .priority(PrioritySearchDataDto.builder()
                        .name(priority.getName())
                        .color(priority.getColor()).build())
                .build();
    }

    public Task fromDomain(CreatedTaskDto model){
        return Task.builder()
                .title(model.getTitle())
                .taskDate(model.getTaskDate())
                .completed(model.getCompleted())
                .build();
    }

    public Task fromDomain(UpdatedTaskDto model){
        return Task.builder()
                .id(model.getId())
                .title(model.getTitle())
                .taskDate(model.getTaskDate())
                .completed(model.getCompleted())
                .build();
    }

}
