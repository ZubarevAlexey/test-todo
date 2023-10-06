package kg.java.testtodo.core.models.dtos.priority;

import kg.java.testtodo.core.models.dtos.base.BaseDto;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class UpdatedPriorityDto extends BaseDto {
    private String name;
    private String color;
    private Long userId;
}
