package kg.java.testtodo.models.dtos.category;

import kg.java.testtodo.models.dtos.base.BaseDto;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class CreatedCategoryDto extends BaseDto {
    private String name;

    private Long userId;

}
