package by.academy.task07webAnimal.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public final class AnimalDTO {
    /**
     * animal id.
     */
    private Integer id;
    /**
     * name of the animal.
     */
    private String name;
    /**
     * weight of the animal.
     */
    private Double weight;
}
