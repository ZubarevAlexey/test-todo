package kg.java.testtodo.core.models.dtos.category;

import kg.java.testtodo.core.models.dtos.user.UserPriorityDataDto;
import lombok.*;

@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class CategoryDto {
    private Long id;
    private String name;

    private UserPriorityDataDto user;
}
