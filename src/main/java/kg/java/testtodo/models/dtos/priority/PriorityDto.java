package kg.java.testtodo.models.dtos.priority;

import kg.java.testtodo.models.dtos.base.BaseDto;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class PriorityDto extends BaseDto {
    private String name;
    private String color;
    private Long userId;

}
