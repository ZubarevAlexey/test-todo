package kg.java.testtodo.facades.userfacade;

import kg.java.testtodo.contracts.usercontrackts.IUserFacade;
import kg.java.testtodo.contracts.usercontrackts.IUserService;
import kg.java.testtodo.exceptions.EntityDuplicateExceptions;
import kg.java.testtodo.exceptions.EntityNotFoundException;
import kg.java.testtodo.models.dtos.user.*;
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
    public UserDto register(CreatedUserDto model) throws EntityDuplicateExceptions {
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
