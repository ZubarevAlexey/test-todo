package kg.java.testtodo.core.contracts.services;

import kg.java.testtodo.core.models.dtos.user.*;
import kg.java.testtodo.core.exceptions.EntityDuplicateExceptions;
import kg.java.testtodo.core.exceptions.EntityNotFoundException;
import org.springframework.http.HttpStatus;



public interface IUserService {
    UserDto add(CreatedUserDto model) throws EntityNotFoundException;

    UserDto update(UpdateUserDto model) throws EntityNotFoundException,EntityDuplicateExceptions;

    HttpStatus delete(DeleteUserDto model)throws EntityNotFoundException;

    UserDto getById(FindByIdUserDto model) throws EntityNotFoundException;
}
