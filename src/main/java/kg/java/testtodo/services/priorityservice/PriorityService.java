package kg.java.testtodo.services.priorityservice;

import kg.java.testtodo.contracts.prioritycontracts.IPriorityService;
import kg.java.testtodo.exceptions.EntityDuplicateExceptions;
import kg.java.testtodo.exceptions.EntityNotFoundException;
import kg.java.testtodo.mappers.prioritymapper.PriorityMapper;
import kg.java.testtodo.models.dtos.priority.*;
import kg.java.testtodo.repo.PriorityRepository;
import org.springframework.http.HttpStatus;

public class PriorityService implements IPriorityService {
    private final PriorityRepository priorityRepository;

    private PriorityMapper mapper;

    public PriorityService(PriorityRepository priorityRepository, PriorityMapper mapper) {
        this.priorityRepository = priorityRepository;
        this.mapper = mapper;
    }

    @Override
    public PriorityDto add(CreatedPriorityDto model) throws EntityDuplicateExceptions, EntityNotFoundException {
        var priority = priorityRepository.findPriorityByName(model.getName());
        if (priority.isPresent()) throw new EntityDuplicateExceptions();
        var entity = priorityRepository.save(mapper.fromDomain(model));
        return mapper.toDomain(entity);
    }

    @Override
    public PriorityDto update(UpdatedPriorityDto model) throws EntityNotFoundException, EntityDuplicateExceptions {
        var priority = priorityRepository.findById(model.getId()).orElseThrow(EntityNotFoundException::new);
        var entity = priority.toBuilder()
                .id(model.getId())
                .name(model.getName())
                .color(model.getColor())
                .userId(model.getUserId())
                .build();
        priorityRepository.save(entity);
        return mapper.toDomain(entity);
    }

    @Override
    public HttpStatus delete(DeletePriorityDto model) throws EntityNotFoundException {
        var priority = priorityRepository.findById(model.getId()).orElseThrow(EntityNotFoundException::new);
        priorityRepository.deleteById(priority.getId());
        return HttpStatus.OK;
    }

    @Override
    public PriorityDto getById(FindByIdPriorityDto model) throws EntityNotFoundException {
        var priority = priorityRepository.findById(model.getId()).orElseThrow(EntityNotFoundException::new);
        return mapper.toDomain(priority);
    }
}
