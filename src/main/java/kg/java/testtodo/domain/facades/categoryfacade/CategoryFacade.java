package kg.java.testtodo.domain.facades.categoryfacade;

import kg.java.testtodo.core.contracts.facades.ICategoryFacade;
import kg.java.testtodo.core.contracts.services.ICategoryService;
import kg.java.testtodo.core.models.dtos.category.*;
import kg.java.testtodo.core.exceptions.EntityDuplicateExceptions;
import kg.java.testtodo.core.exceptions.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class CategoryFacade implements ICategoryFacade {

    private final ICategoryService service;

    public CategoryFacade(ICategoryService service) {
        this.service = service;
    }

    @Override
    public CategoryDto get(FindByIdCategoryDto model) throws EntityNotFoundException {
        return service.getById(model);
    }

    @Override
    public CategoryDto register(CreatedCategoryDto model) throws EntityDuplicateExceptions, EntityNotFoundException {
        return service.add(model);
    }

    @Override
    public CategoryDto update(UpdateCategoryDto model) throws EntityDuplicateExceptions, EntityNotFoundException {
        return service.update(model);
    }

    @Override
    public HttpStatus delete(DeleteCategoryDto model) throws EntityNotFoundException {
        return service.delete(model);
    }
}
