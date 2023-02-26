package by.academy.pagination.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public final class PersonDTO {
    private Integer id;
    private String name;
    private String surname;
}
