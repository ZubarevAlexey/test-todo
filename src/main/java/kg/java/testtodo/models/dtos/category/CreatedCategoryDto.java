package kg.java.testtodo.models.dtos.category;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class CreatedCategoryDto {
    private String name;

    private Long userId;

}
