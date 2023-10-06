package kg.java.testtodo.core.models.dtos.priority;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder(toBuilder = true)
public class PrioritySearchDataDto {
    private String name;
    private String color;
}
