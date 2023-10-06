package kg.java.testtodo.domain.services.priorityservice;

import kg.java.testtodo.core.contracts.services.IPriorityService;
import kg.java.testtodo.core.models.dtos.priority.*;
import kg.java.testtodo.core.exceptions.EntityDuplicateExceptions;
import kg.java.testtodo.core.exceptions.EntityNotFoundException;
import kg.java.testtodo.core.mappers.prioritymapper.PriorityMapper;
import kg.java.testtodo.data.repo.PriorityRepository;
import kg.java.testtodo.data.repo.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class PriorityService implements IPriorityService {

    private final UserRepository userRepository;
    private final PriorityRepository priorityRepository;

    private PriorityMapper mapper;


    public PriorityService(UserRepository userRepository, PriorityRepository priorityRepository, PriorityMapper mapper) {
        this.userRepository = userRepository;
        this.priorityRepository = priorityRepository;
        this.mapper = mapper;
    }

    @Override
    public PriorityDto add(CreatedPriorityDto model) throws EntityDuplicateExceptions, EntityNotFoundException {
        var priority = priorityRepository.findPriorityByName(model.getName());
        if (priority.isPresent()) throw new EntityDuplicateExceptions();
        var user = userRepository.findById(model.getUserId()).orElseThrow(EntityNotFoundException::new);
        var entity = mapper.fromDomain(model);
        entity.setUser(user);
        entity = priorityRepository.save(entity);
        return mapper.toDomain(entity);
    }

    @Override
    public PriorityDto update(UpdatedPriorityDto model) throws EntityNotFoundException, EntityDuplicateExceptions {
        var priority = priorityRepository.findById(model.getId()).orElseThrow(EntityNotFoundException::new);
        var user = userRepository.findById(model.getUserId()).orElseThrow(EntityNotFoundException::new);
        var entity = priority.toBuilder()
                .id(model.getId())
                .name(model.getName())
                .color(model.getColor())
                .user(user)
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
