package kg.java.testtodo.core.models.dtos.task;

import kg.java.testtodo.core.models.dtos.category.CategorySearchDataDto;
import kg.java.testtodo.core.models.dtos.priority.PrioritySearchDataDto;
import kg.java.testtodo.core.models.dtos.user.UserSearchDataDto;
import kg.java.testtodo.core.models.entity.Category;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class CreatedTaskDto {

    private String title;
    private Date taskDate;
    private Boolean completed;
    private Long priorityId;
    private Long userId;
    private Long categoryId;

}
