package kg.java.testtodo.core.models.dtos.user;

import lombok.*;

@Data
@AllArgsConstructor
@Builder(toBuilder = true)
public class UserSearchDataDto {
    private String name;
    private String email;
}
