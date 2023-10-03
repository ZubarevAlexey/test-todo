package kg.java.testtodo.controllers;

import kg.java.testtodo.contracts.categorycontrackts.ICategoryFacade;
import kg.java.testtodo.exceptions.EntityDuplicateExceptions;
import kg.java.testtodo.exceptions.EntityNotFoundException;
import kg.java.testtodo.models.dtos.category.*;
import kg.java.testtodo.models.dtos.user.CreatedUserDto;
import kg.java.testtodo.models.dtos.user.FindByIdUserDto;
import kg.java.testtodo.models.dtos.user.UpdateUserDto;
import kg.java.testtodo.models.dtos.user.UserDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private final ICategoryFacade facade;

    public CategoryController(ICategoryFacade facade) {
        this.facade = facade;
    }

    @PostMapping("/signup")
    public ResponseEntity<CategoryDto> add(@RequestBody CreatedCategoryDto model) {
//        if (model.getId() != null || model.getId() != 0) {
//            return new ResponseEntity("redundant param userId", HttpStatus.NOT_ACCEPTABLE);
//
//        }
        try {

            return ResponseEntity.ok(facade.register(model));
        } catch (EntityDuplicateExceptions e) {
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }



    }
    @PostMapping("/update")
    public ResponseEntity<CategoryDto> update(@RequestBody UpdateCategoryDto model) {
        try {
            return ResponseEntity.ok(facade.update(model));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/delete")
    public ResponseEntity<HttpStatus> delete(@RequestBody DeleteCategoryDto model){
        try {
            return ResponseEntity.ok(facade.delete(model));
        }
        catch (EntityNotFoundException e){
            return ResponseEntity.notFound().build();
        }
        catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
    @PostMapping("/id")
    public ResponseEntity<CategoryDto> getById(@RequestBody FindByIdCategoryDto model){
        try {
            return ResponseEntity.ok(facade.get(model));
        }
        catch (EntityNotFoundException e){
            return ResponseEntity.notFound().build();
        }
        catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

}
