package kg.java.testtodo.domain.services.categoryservice;

import kg.java.testtodo.core.contracts.services.ICategoryService;
import kg.java.testtodo.core.models.dtos.category.*;
import kg.java.testtodo.core.exceptions.EntityDuplicateExceptions;
import kg.java.testtodo.core.exceptions.EntityNotFoundException;
import kg.java.testtodo.core.mappers.categorymapper.CategoryMapper;
import kg.java.testtodo.data.repo.CategoryRepository;
import kg.java.testtodo.data.repo.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class CategoryService implements ICategoryService {

    private UserRepository userRepository;

    private CategoryMapper categoryMapper;
    private CategoryRepository repository;

    public CategoryService(UserRepository userRepository, CategoryMapper categoryMapper, CategoryRepository repository) {
        this.userRepository = userRepository;
        this.categoryMapper = categoryMapper;
        this.repository = repository;
    }

    @Override
    public CategoryDto add(CreatedCategoryDto model) throws EntityDuplicateExceptions,EntityNotFoundException {
        var category = repository.findCategoryByName(model.getName());
        if (category.isPresent()) throw new EntityDuplicateExceptions();
        var entity = repository.save(categoryMapper.fromDomain(model));
        return categoryMapper.toDomain(entity);
    }

    @Override
    public CategoryDto update(UpdateCategoryDto model) throws EntityNotFoundException, EntityDuplicateExceptions {
        var category = repository.findById(model.getId()).orElseThrow(EntityNotFoundException::new);
        var entity = category.toBuilder()
                .id(model.getId())
                .name(model.getName())
                .userId(model.getUserId())
                .build();
        repository.save(entity);
        return categoryMapper.toDomain(entity);
    }

    @Override
    public HttpStatus delete(DeleteCategoryDto model) throws EntityNotFoundException {
        var category = repository.findById(model.getId()).orElseThrow(EntityNotFoundException::new);
        repository.deleteById(category.getId());
        return HttpStatus.OK;
    }

    @Override
    public CategoryDto getById(FindByIdCategoryDto model) throws EntityNotFoundException {
        var category = repository.findById(model.getId()).orElseThrow(EntityNotFoundException::new);
        return categoryMapper.toDomain(category);
    }
}
