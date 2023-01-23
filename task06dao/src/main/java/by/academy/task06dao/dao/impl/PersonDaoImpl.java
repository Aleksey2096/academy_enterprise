package by.academy.task06dao.dao.impl;

import by.academy.task06dao.dao.AbstractPersonDao;
import by.academy.task06dao.dao.DaoException;
import by.academy.task06dao.entity.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static by.academy.task06dao.dao.DatabaseQuery.SELECT_PEOPLE_BY_FIELD;
import static by.academy.task06dao.entity.Constant.ID_COLUMN_TITLE;
import static by.academy.task06dao.entity.Constant.NAME_COLUMN_TITLE;
import static by.academy.task06dao.entity.Constant.SURNAME_COLUMN_TITLE;

public final class PersonDaoImpl extends AbstractPersonDao {
    /**
     * creates new PersonDaoImpl with necessary connection.
     *
     * @param newConnection java.sql.Connection
     */
    public PersonDaoImpl(final Connection newConnection) {
        super(newConnection);
    }

    @Override
    public List<Person> selectByName(final String name) throws DaoException {
        try {
            return selectByField(NAME_COLUMN_TITLE, name);
        } catch (SQLException newE) {
            throw new DaoException(newE);
        }
    }

    @Override
    public List<Person> selectBySurname(final String surname)
            throws DaoException {
        try {
            return selectByField(SURNAME_COLUMN_TITLE, surname);
        } catch (SQLException newE) {
            throw new DaoException(newE);
        }
    }

    private List<Person> selectByField(final String fieldTitle,
                                       final Object fieldValue)
            throws SQLException {
        try (PreparedStatement statement = getConnection().prepareStatement(
                String.format(SELECT_PEOPLE_BY_FIELD, fieldTitle))) {
            statement.setObject(1, fieldValue);
            return createPersonList(statement.executeQuery());
        }
    }

    private List<Person> createPersonList(final ResultSet resultset)
            throws SQLException {
        List<Person> people = new ArrayList<>();
        while (resultset.next()) {
            people.add(createPerson(resultset));
        }
        return people;
    }

    private Person createPerson(final ResultSet resultset) throws SQLException {
        Person person = new Person();
        person.setId(resultset.getInt(ID_COLUMN_TITLE));
        person.setName(resultset.getString(NAME_COLUMN_TITLE));
        person.setSurname(resultset.getString(SURNAME_COLUMN_TITLE));
        return person;
    }
}
