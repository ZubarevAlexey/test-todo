package kg.java.testtodo.models.dtos.user;

import kg.java.testtodo.models.dtos.base.BaseDto;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class CreatedUserDto extends BaseDto {
    private String name;
    private String email;
    private String password;
}
