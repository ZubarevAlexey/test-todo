package kg.java.testtodo.models.dtos.user;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class CreatedUserDto {
    private String name;
    private String email;
    private String password;
}
