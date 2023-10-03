package kg.java.testtodo.mappers.prioritymapper;

import kg.java.testtodo.models.dtos.priority.CreatedPriorityDto;
import kg.java.testtodo.models.dtos.priority.PriorityDto;
import kg.java.testtodo.models.dtos.priority.UpdatedPriorityDto;
import kg.java.testtodo.models.entity.Priority;

public class PriorityMapper {

    public PriorityDto toDomain(Priority model){
        return PriorityDto.builder()
                .id(model.getId())
                .name(model.getName())
                .color(model.getColor())
                .userId(model.getUserId())
                .build();
    }

    public Priority fromDomain(CreatedPriorityDto model){
        return Priority.builder()
                .name(model.getName())
                .color(model.getColor())
                .userId(model.getUserId())
                .build();
    }
    public Priority fromDomain(UpdatedPriorityDto model){
        return Priority.builder()
                .id(model.getId())
                .name(model.getName())
                .color(model.getColor())
                .userId(model.getUserId())
                .build();
    }
}
