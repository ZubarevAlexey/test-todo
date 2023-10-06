package kg.java.testtodo.core.mappers.prioritymapper;

import kg.java.testtodo.core.models.dtos.priority.CreatedPriorityDto;
import kg.java.testtodo.core.models.dtos.priority.PriorityDto;
import kg.java.testtodo.core.models.dtos.priority.UpdatedPriorityDto;
import kg.java.testtodo.core.models.dtos.user.UserPriorityDataDto;
import kg.java.testtodo.core.models.entity.Priority;

public class PriorityMapper {

    public PriorityDto toDomain(Priority model) {
        var user = model.getUser();
        return PriorityDto.builder()
                .id(model.getId())
                .name(model.getName())
                .color(model.getColor())
                .user(UserPriorityDataDto
                        .builder()
                        .email(user.getEmail())
                        .name(user.getName())
                        .build())
                .build();
    }

    public Priority fromDomain(CreatedPriorityDto model) {
        return Priority.builder()
                .name(model.getName())
                .color(model.getColor())
                .build();
    }

    public Priority fromDomain(UpdatedPriorityDto model) {
        return Priority.builder()
                .id(model.getId())
                .name(model.getName())
                .color(model.getColor())
                .build();
    }
}
