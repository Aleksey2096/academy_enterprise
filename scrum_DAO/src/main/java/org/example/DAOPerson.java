package org.example;

import org.example.impl.IDAOPerson;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.example.service.DataQuery.ID_COLUMN_TITLE;
import static org.example.service.DataQuery.NAME_COLUMN_TITLE;
import static org.example.service.DataQuery.SELECT_PEOPLE_SQL;
import static org.example.service.DataQuery.SELECT_PERSON_BY_ID_SQL;
import static org.example.service.DataQuery.SURNAME_COLUMN_TITLE;

/**
 * @author Katerina
 * @version 1.0
 * имплементация DAO для класса Person.
 */
public class DAOPerson extends DAO<Person> implements IDAOPerson {
    /**
     * добавление элземплара класса Person в базу данных.
     */
    @Override
    public void createPerson(final Person person) {
        this.insert(person);
    }
    /**
     * изменение сущности в базе данных на значения элземплара класса Person.
     */
    @Override
    public void updatePerson(final Person person) {
        this.update(person);
    }
    /**
     * удаление сущности в базе данных по id объекта класса Person.
     */
    @Override
    public void deletePerson(final Person person) {
        this.delete(person);
    }

    /**
     * поиск сущности в базе данных по id объекта класса Person.
     */
    @Override
    public void findPerson(final Person person) {
        this.select(person);
    }

    @Override
    public Person readById(final int id) {
        try (PreparedStatement statement = getConnection().prepareStatement(
                SELECT_PERSON_BY_ID_SQL)) {
            statement.setInt(1, id);
            ResultSet resultset = statement.executeQuery();
            Person person = null;
            if (resultset.next()) {
                person = createPerson(resultset);
            }
            return person;
        } catch (SQLException newE) {
            newE.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Person> readAll() {
        try (PreparedStatement statement = getConnection().prepareStatement(
                SELECT_PEOPLE_SQL)) {
            return createPersonList(statement.executeQuery());
        } catch (SQLException newE) {
            newE.printStackTrace();
        }
        return null;
    }

    private List<Person> createPersonList(final ResultSet resultset)
            throws SQLException {
        List<Person> people = new ArrayList<>();
        while (resultset.next()) {
            people.add(createPerson(resultset));
        }
        return people;
    }

    private Person createPerson(final ResultSet resultset)
            throws SQLException {
        Person person = new Person();
        person.setId(resultset.getInt(ID_COLUMN_TITLE));
        person.setName(resultset.getString(NAME_COLUMN_TITLE));
        person.setSurname(resultset.getString(SURNAME_COLUMN_TITLE));
        return person;
    }
}
