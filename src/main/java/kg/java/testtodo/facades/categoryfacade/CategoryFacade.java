package kg.java.testtodo.facades.categoryfacade;

import kg.java.testtodo.contracts.categorycontrackts.ICategoryFacade;
import kg.java.testtodo.contracts.categorycontrackts.ICategoryService;
import kg.java.testtodo.exceptions.EntityDuplicateExceptions;
import kg.java.testtodo.exceptions.EntityNotFoundException;
import kg.java.testtodo.models.dtos.category.*;
import lombok.Setter;
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
