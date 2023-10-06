package kg.java.testtodo.core.mappers.usermapper;

import kg.java.testtodo.core.models.dtos.user.CreatedUserDto;
import kg.java.testtodo.core.models.dtos.user.UpdateUserDto;
import kg.java.testtodo.core.models.dtos.user.UserDto;
import kg.java.testtodo.core.models.entity.User;

public class UserMapper {

    public UserDto toDomain(User model){
        return UserDto.builder()
                .id(model.getId())
                .email(model.getEmail())
                .name(model.getName())
                .password(model.getPassword())
                .build();
    }

    public User fromDomain(CreatedUserDto model){
        return User.builder()
                .email(model.getEmail())
                .name(model.getName())
                .password(model.getPassword())
                .build();

    }
    public User fromDomain(UpdateUserDto model){
        return User.builder()
                .id(model.getId())
                .email(model.getEmail())
                .name(model.getName())
                .password(model.getPassword())
                .build();

    }
}
