package kg.java.testtodo.controllers;

import kg.java.testtodo.contracts.prioritycontracts.IPriorityFacade;
import kg.java.testtodo.exceptions.EntityDuplicateExceptions;
import kg.java.testtodo.exceptions.EntityNotFoundException;
import kg.java.testtodo.models.dtos.priority.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/priority")
public class PriorityController {

    private final IPriorityFacade facade;

    public PriorityController(IPriorityFacade facade) {
        this.facade = facade;
    }

    @PostMapping("/signup")
    public ResponseEntity<PriorityDto> register (@RequestBody CreatedPriorityDto model){
        try {
            return ResponseEntity.ok(facade.register(model));
        }catch (EntityDuplicateExceptions e){
            return ResponseEntity.badRequest().build();
        }
        catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }
    @PostMapping("/update")
    public ResponseEntity<PriorityDto> update (@RequestBody UpdatedPriorityDto model){
        try {
            return ResponseEntity.ok(facade.update(model));
        }catch (EntityNotFoundException e){
            return ResponseEntity.notFound().build();
        }
        catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/delete")
    public ResponseEntity<HttpStatus> delete (@RequestBody DeletePriorityDto model){
        try {
            return ResponseEntity.ok(facade.delete(model));
        }catch (EntityNotFoundException e){
            return ResponseEntity.notFound().build();
        }
        catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/id")
    public ResponseEntity<PriorityDto> getById (@RequestBody FindByIdPriorityDto model){
        try {
            return ResponseEntity.ok(facade.getById(model));
        }catch (EntityNotFoundException e){
            return ResponseEntity.notFound().build();
        }
        catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }
}
