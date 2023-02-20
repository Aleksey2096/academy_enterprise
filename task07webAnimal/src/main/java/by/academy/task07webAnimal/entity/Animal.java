package by.academy.task07webAnimal.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import static by.academy.task07webAnimal.entity.Constant.ANIMAL;
import static by.academy.task07webAnimal.entity.Constant.ID;
import static by.academy.task07webAnimal.entity.Constant.NAME;
import static by.academy.task07webAnimal.entity.Constant.WEIGHT;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = ANIMAL)
public final class Animal {
    /**
     * animal id.
     */
    @Id
    @Column(name = ID)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * name of the animal.
     */
    @Column(name = NAME)
    private String name;
    /**
     * weight of the animal.
     */
    @Column(name = WEIGHT)
    private Double weight;
}
