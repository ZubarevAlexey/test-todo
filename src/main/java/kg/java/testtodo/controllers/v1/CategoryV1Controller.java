package kg.java.testtodo.controllers.v1;

import kg.java.testtodo.core.contracts.facades.ICategoryFacade;
import kg.java.testtodo.core.models.dtos.category.*;
import kg.java.testtodo.core.exceptions.EntityDuplicateExceptions;
import kg.java.testtodo.core.exceptions.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryV1Controller {

    private final ICategoryFacade facade;

    public CategoryV1Controller(ICategoryFacade facade) {
        this.facade = facade;
    }

    @PostMapping("/signup")
    public ResponseEntity<CategoryDto> add(@RequestBody CreatedCategoryDto model) {

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
    public ResponseEntity<HttpStatus> delete(@RequestBody DeleteCategoryDto model) {
        try {
            return ResponseEntity.ok(facade.delete(model));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/id")
    public ResponseEntity<CategoryDto> getById(@RequestBody FindByIdCategoryDto model) {
        try {
            return ResponseEntity.ok(facade.get(model));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

}
