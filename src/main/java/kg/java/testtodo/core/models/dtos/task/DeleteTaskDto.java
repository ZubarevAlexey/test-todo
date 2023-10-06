package kg.java.testtodo.core.models.dtos.task;

import kg.java.testtodo.core.models.dtos.base.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder(toBuilder = true)
public class DeleteTaskDto extends BaseDto {
}
