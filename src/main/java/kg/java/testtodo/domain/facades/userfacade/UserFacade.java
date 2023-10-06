package kg.java.testtodo.domain.facades.userfacade;

import kg.java.testtodo.core.contracts.facades.IUserFacade;
import kg.java.testtodo.core.contracts.services.IUserService;
import kg.java.testtodo.core.models.dtos.user.*;
import kg.java.testtodo.core.exceptions.EntityDuplicateExceptions;
import kg.java.testtodo.core.exceptions.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class UserFacade implements IUserFacade {

    private IUserService userService;

    public UserFacade(IUserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDto get(FindByIdUserDto model) throws EntityNotFoundException {
        return userService.getById(model);
    }

    @Override
    public UserDto register(CreatedUserDto model) throws  EntityNotFoundException {
        return userService.add(model);
    }

    @Override
    public UserDto update(UpdateUserDto model) throws EntityDuplicateExceptions, EntityNotFoundException {
        return userService.update(model);
    }

    @Override
    public HttpStatus delete(DeleteUserDto model) throws EntityNotFoundException {
        return userService.delete(model);
    }
}
