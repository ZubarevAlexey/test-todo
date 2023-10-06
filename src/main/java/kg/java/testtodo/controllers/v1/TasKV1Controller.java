package kg.java.testtodo.controllers.v1;

import kg.java.testtodo.core.contracts.facades.ITaskFacade;
import kg.java.testtodo.core.exceptions.EntityDuplicateExceptions;
import kg.java.testtodo.core.exceptions.EntityNotFoundException;
import kg.java.testtodo.core.models.dtos.task.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/task")
public class TasKV1Controller {
    private final ITaskFacade taskFacade;

    public TasKV1Controller(ITaskFacade taskFacade) {
        this.taskFacade = taskFacade;
    }


    @PostMapping("/add")
    public ResponseEntity<TaskDto> add(@RequestBody CreatedTaskDto model){
        try {
            return ResponseEntity.ok(taskFacade.register(model));
        }
        catch (EntityDuplicateExceptions e){
            return ResponseEntity.internalServerError().build();
        }
        catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/update")
    public ResponseEntity<TaskDto> update(@RequestBody UpdatedTaskDto model){
        try {
            return ResponseEntity.ok(taskFacade.update(model));
        }
        catch (EntityNotFoundException e){
            return ResponseEntity.notFound().build();
        }
        catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/delete")
    public ResponseEntity<HttpStatus> delete(@RequestBody DeleteTaskDto model){
        try {
            return ResponseEntity.ok(taskFacade.delete(model));
        }
        catch (EntityNotFoundException e){
            return ResponseEntity.notFound().build();
        }
        catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/id")
    public ResponseEntity<TaskDto> getById(@RequestBody FindByIdTaskDto model){
        try {
            return ResponseEntity.ok(taskFacade.getById(model));
        }
        catch (EntityNotFoundException e){
            return ResponseEntity.notFound().build();
        }
        catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
}
