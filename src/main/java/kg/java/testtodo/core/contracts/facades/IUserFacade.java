package kg.java.testtodo.core.contracts.facades;

import kg.java.testtodo.core.models.dtos.user.*;
import kg.java.testtodo.core.exceptions.EntityDuplicateExceptions;
import kg.java.testtodo.core.exceptions.EntityNotFoundException;
import org.springframework.http.HttpStatus;

public interface IUserFacade {

UserDto get(FindByIdUserDto model) throws EntityNotFoundException;
UserDto register(CreatedUserDto model) throws EntityDuplicateExceptions, EntityNotFoundException;
UserDto update(UpdateUserDto model) throws EntityDuplicateExceptions,EntityNotFoundException;

HttpStatus delete(DeleteUserDto model) throws EntityNotFoundException;
}
