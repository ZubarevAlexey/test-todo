package kg.java.testtodo.core.models.dtos.user;

import lombok.*;

@Data
@AllArgsConstructor
@Builder(toBuilder = true)
public class UserPriorityDataDto {
    private String name;
    private String email;
}
