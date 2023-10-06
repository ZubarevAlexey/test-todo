package kg.java.testtodo.core.models.dtos.category;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder(toBuilder = true)
public class CategorySearchDataDto {
    private String name;

}
