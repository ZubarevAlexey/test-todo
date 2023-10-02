package kg.java.testtodo.models.dtos.category;

import lombok.*;

@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class CategoryDto {
    private Long id;
    private String name;

}
