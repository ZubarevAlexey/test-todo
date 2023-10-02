package kg.java.testtodo.models.dtos.category;

import kg.java.testtodo.models.dtos.base.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder(toBuilder = true)
public class FindByIdCategoryDto extends BaseDto {
}
