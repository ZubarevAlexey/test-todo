package kg.java.testtodo.models.dtos.category;

import kg.java.testtodo.models.dtos.base.BaseDto;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class UpdateCategoryDto extends BaseDto {
    private String name;
}
