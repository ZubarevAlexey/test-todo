package kg.java.testtodo.facades.priorityfacade;

import kg.java.testtodo.contracts.prioritycontracts.IPriorityFacade;
import kg.java.testtodo.contracts.prioritycontracts.IPriorityService;
import kg.java.testtodo.exceptions.EntityDuplicateExceptions;
import kg.java.testtodo.exceptions.EntityNotFoundException;
import kg.java.testtodo.models.dtos.priority.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class PriorityFacade  implements IPriorityFacade {

    private final IPriorityService priorityService;

    public PriorityFacade(IPriorityService priorityService) {
        this.priorityService = priorityService;
    }

    @Override
    public PriorityDto register(CreatedPriorityDto model) throws EntityDuplicateExceptions{
        return priorityService.add(model);
    }

    @Override
    public PriorityDto update(UpdatedPriorityDto model) throws EntityDuplicateExceptions, EntityNotFoundException {
        return priorityService.update(model);
    }

    @Override
    public HttpStatus delete(DeletePriorityDto model) throws EntityNotFoundException {
        return priorityService.delete(model);
    }

    @Override
    public PriorityDto getById(FindByIdPriorityDto model) throws EntityNotFoundException {
        return priorityService.getById(model);
    }
}
