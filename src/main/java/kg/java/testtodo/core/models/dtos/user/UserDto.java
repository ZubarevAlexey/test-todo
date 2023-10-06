package kg.java.testtodo.core.models.dtos.user;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class UserDto  {
    private Long id;
    private String name;
    private String email;
    private String password;
}
