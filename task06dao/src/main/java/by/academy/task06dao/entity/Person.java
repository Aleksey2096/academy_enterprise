package by.academy.task06dao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

import static by.academy.task06dao.entity.Constant.ID_COLUMN_TITLE;
import static by.academy.task06dao.entity.Constant.NAME_COLUMN_TITLE;
import static by.academy.task06dao.entity.Constant.PERSON_TABLE_TITLE;
import static by.academy.task06dao.entity.Constant.SURNAME_COLUMN_TITLE;

@Data
@NoArgsConstructor
@AllArgsConstructor
@MyTable(name = PERSON_TABLE_TITLE)
public final class Person implements Serializable {
    /**
     * person unique identification number.
     */
    @MyColumn(name = ID_COLUMN_TITLE)
    private Integer id;
    /**
     * person name.
     */
    @MyColumn(name = NAME_COLUMN_TITLE)
    private String name;
    /**
     * person surname.
     */
    @MyColumn(name = SURNAME_COLUMN_TITLE)
    private String surname;
}
