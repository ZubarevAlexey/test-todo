package kg.java.testtodo.domain.facades.priorityfacade;

import kg.java.testtodo.core.contracts.facades.IPriorityFacade;
import kg.java.testtodo.core.contracts.services.IPriorityService;
import kg.java.testtodo.core.models.dtos.priority.*;
import kg.java.testtodo.core.exceptions.EntityDuplicateExceptions;
import kg.java.testtodo.core.exceptions.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class PriorityFacade  implements IPriorityFacade {

    private final IPriorityService priorityService;

    public PriorityFacade(IPriorityService priorityService) {
        this.priorityService = priorityService;
    }

    @Override
    public PriorityDto register(CreatedPriorityDto model) throws EntityDuplicateExceptions, EntityNotFoundException {
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
