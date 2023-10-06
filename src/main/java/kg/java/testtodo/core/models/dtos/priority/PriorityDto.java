package kg.java.testtodo.core.models.dtos.priority;

import kg.java.testtodo.core.models.dtos.user.UserPriorityDataDto;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class PriorityDto {
    private Long id;
    private String name;
    private String color;
    private UserPriorityDataDto user;



}
