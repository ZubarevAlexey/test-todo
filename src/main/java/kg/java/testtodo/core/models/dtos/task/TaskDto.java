package kg.java.testtodo.core.models.dtos.task;

import kg.java.testtodo.core.models.dtos.category.CategorySearchDataDto;
import kg.java.testtodo.core.models.dtos.priority.PrioritySearchDataDto;
import kg.java.testtodo.core.models.dtos.user.UserSearchDataDto;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class TaskDto {
    private Long id;
    private String title;
    private Date taskDate;

    private Boolean completed;
    private PrioritySearchDataDto priority;
    private UserSearchDataDto user;
    private CategorySearchDataDto category;
//
//    private Integer pageNumber;
//    private Integer pageSize;
//
//    private String sortColumn;
//    private String sortDirection;


}
