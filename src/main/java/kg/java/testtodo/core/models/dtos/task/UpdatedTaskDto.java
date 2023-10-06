package kg.java.testtodo.core.models.dtos.task;

import kg.java.testtodo.core.models.dtos.base.BaseDto;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class UpdatedTaskDto extends BaseDto {
    private String title;
    private Date taskDate;
    private Boolean completed;
    private Long priorityId;
    private Long userId;
    private Long categoryId;
}
