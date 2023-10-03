package kg.java.testtodo.contracts.usercontrackts;

import kg.java.testtodo.exceptions.EntityDuplicateExceptions;
import kg.java.testtodo.exceptions.EntityNotFoundException;
import kg.java.testtodo.models.dtos.user.*;
import org.springframework.http.HttpStatus;



public interface IUserService {
    UserDto add(CreatedUserDto model) throws EntityNotFoundException;

    UserDto update(UpdateUserDto model) throws EntityNotFoundException,EntityDuplicateExceptions;

    HttpStatus delete(DeleteUserDto model)throws EntityNotFoundException;

    UserDto getById(FindByIdUserDto model) throws EntityNotFoundException;
}
