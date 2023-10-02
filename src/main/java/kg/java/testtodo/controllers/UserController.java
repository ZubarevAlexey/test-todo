package kg.java.testtodo.controllers;

import kg.java.testtodo.contracts.usercontrackts.IUserFacade;
import kg.java.testtodo.exceptions.EntityDuplicateExceptions;
import kg.java.testtodo.exceptions.EntityNotFoundException;
import kg.java.testtodo.models.dtos.user.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    private IUserFacade userFacade;

    public UserController(IUserFacade userFacade) {
        this.userFacade = userFacade;
    }

    @PostMapping("/signup")
    public ResponseEntity<UserDto> add(@RequestBody CreatedUserDto model) {
        try {
            return ResponseEntity.ok(userFacade.register(model));
        } catch (EntityDuplicateExceptions e) {
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/update")
    public ResponseEntity<UserDto> update(@RequestBody UpdateUserDto model) {
        try {
            return ResponseEntity.ok(userFacade.update(model));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/delete")
    public ResponseEntity<HttpStatus> delete(@RequestBody DeleteUserDto model) {
        try {
            return ResponseEntity.ok(userFacade.delete(model));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build()
        }
    }

    @PostMapping("/id")
    public ResponseEntity<UserDto> getById(@RequestBody FindByIdUserDto model) {
        try {
            return ResponseEntity.ok(userFacade.get(model));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }


}
