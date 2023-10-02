package kg.java.testtodo.contracts.usercontrackts;

import kg.java.testtodo.exceptions.EntityDuplicateExceptions;
import kg.java.testtodo.exceptions.EntityNotFoundException;
import kg.java.testtodo.models.dtos.user.*;
import org.springframework.http.HttpStatus;

public interface IUserFacade {

UserDto get(FindByIdUserDto model) throws EntityNotFoundException;
UserDto register(CreatedUserDto model) throws EntityDuplicateExceptions;
UserDto update(UpdateUserDto model) throws EntityDuplicateExceptions,EntityNotFoundException;

HttpStatus delete(DeleteUserDto model) throws EntityNotFoundException;
}
