package kg.java.testtodo.domain.services.userservice;

import kg.java.testtodo.core.contracts.services.IUserService;
import kg.java.testtodo.core.models.dtos.user.*;
import kg.java.testtodo.core.exceptions.EntityDuplicateExceptions;
import kg.java.testtodo.core.exceptions.EntityNotFoundException;
import kg.java.testtodo.core.mappers.usermapper.UserMapper;
import kg.java.testtodo.data.repo.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserService implements IUserService {

    private UserMapper userMapper;
    private UserRepository userRepository;

    public UserService(UserMapper userMapper, UserRepository userRepository) {
        this.userMapper = userMapper;
        this.userRepository = userRepository;
    }

    @Override
    public UserDto add(CreatedUserDto model) throws EntityNotFoundException {
        var user = userRepository.findById(model.getId());
        if (user.isPresent()) throw new EntityNotFoundException();
        var entity = userRepository.save(userMapper.fromDomain(model));
        return userMapper.toDomain(entity);
    }

    @Override
    public UserDto update(UpdateUserDto model) throws EntityNotFoundException, EntityDuplicateExceptions {

        var user = userRepository.findById(model.getId()).orElseThrow(EntityNotFoundException::new);
        var entity = user.toBuilder()
                .id(model.getId())
                .name(model.getName())
                .email(model.getEmail())
                .password(model.getPassword())
                .build();
        userRepository.save(entity);
        return userMapper.toDomain(entity);
    }

    @Override
    public HttpStatus delete(DeleteUserDto model) throws EntityNotFoundException {
        var user = userRepository.findById(model.getId()).orElseThrow(EntityNotFoundException::new);
        userRepository.deleteById(user.getId());
        return HttpStatus.OK;
    }

    @Override
    public UserDto getById(FindByIdUserDto model) throws EntityNotFoundException {
        var user = userRepository.findById(model.getId()).orElseThrow(EntityNotFoundException::new);
        return userMapper.toDomain(user);
    }
}
