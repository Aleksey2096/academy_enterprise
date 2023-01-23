package by.academy.task06dao.dao;

import by.academy.task06dao.entity.Person;

import java.sql.Connection;
import java.util.List;

public abstract class AbstractPersonDao extends AbstractDao {
    protected AbstractPersonDao(final Connection newConnection) {
        super(newConnection);
    }

    /**
     * @param name person field value.
     * @return people from database with concrete name.
     * @throws DaoException if SQLException occurred.
     */
    public abstract List<Person> selectByName(String name) throws DaoException;

    /**
     * @param surname person field value.
     * @return people from database with concrete surname.
     * @throws DaoException if SQLException occurred.
     */
    public abstract List<Person> selectBySurname(String surname)
            throws DaoException;
}
