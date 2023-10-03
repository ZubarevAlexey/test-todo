package kg.java.testtodo.models.dtos.priority;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class CreatedPriorityDto {
    private String name;
    private String color;
    private Long userId;
}
