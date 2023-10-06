package kg.java.testtodo.core.models.dtos.category;

import kg.java.testtodo.core.models.dtos.base.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder(toBuilder = true)
public class DeleteCategoryDto extends BaseDto {
}
