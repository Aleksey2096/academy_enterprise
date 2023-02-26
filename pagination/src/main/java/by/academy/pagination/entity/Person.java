package by.academy.pagination.entity;

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

import static by.academy.pagination.entity.Constant.ID;
import static by.academy.pagination.entity.Constant.NAME;
import static by.academy.pagination.entity.Constant.PERSON;
import static by.academy.pagination.entity.Constant.SURNAME;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = PERSON)
public final class Person {
    @Id
    @Column(name = ID)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = NAME)
    private String name;
    @Column(name = SURNAME)
    private String surname;
}
