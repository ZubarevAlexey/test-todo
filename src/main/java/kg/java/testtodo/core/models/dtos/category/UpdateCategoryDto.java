package kg.java.testtodo.core.models.dtos.category;

import kg.java.testtodo.core.models.dtos.base.BaseDto;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class UpdateCategoryDto extends BaseDto {
    private String name;
    private Long userId;
}
