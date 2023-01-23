package by.academy.task06dao.service.impl;

import by.academy.task06dao.dao.DaoException;
import by.academy.task06dao.dao.DataSource;
import by.academy.task06dao.dao.impl.PersonDaoImpl;
import by.academy.task06dao.entity.Person;
import by.academy.task06dao.service.PersonDaoService;
import by.academy.task06dao.service.ServiceException;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public final class PersonDaoServiceImpl implements PersonDaoService {
    @Override
    public List<Person> readByName(final String name) throws ServiceException {
        try {
            try (Connection connection = DataSource.getInstance()
                    .getConnection()) {
                return new PersonDaoImpl(connection).selectByName(name);
            }
        } catch (SQLException | DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Person> readBySurname(final String surname)
            throws ServiceException {
        try {
            try (Connection connection = DataSource.getInstance()
                    .getConnection()) {
                return new PersonDaoImpl(connection).selectBySurname(surname);
            }
        } catch (SQLException | DaoException e) {
            throw new ServiceException(e);
        }
    }
}
