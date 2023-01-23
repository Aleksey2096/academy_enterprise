package by.academy.task06dao.service;

import by.academy.task06dao.dao.DaoException;
import by.academy.task06dao.dao.DataSource;
import by.academy.task06dao.dao.impl.PersonDaoImpl;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;

public interface DaoService {
    /**
     * @param object entity with MyTable and MyColumn annotations.
     * @return object created in database with generated id.
     * @throws ServiceException if SQLException or DaoException occurred.
     */
    default Object create(final Object object) throws ServiceException {
        try {
            try (Connection connection = DataSource.getInstance()
                    .getConnection()) {
                return new PersonDaoImpl(connection).insert(object);
            }
        } catch (SQLException | DaoException e) {
            throw new ServiceException(e);
        }
    }

    /**
     * @param cls concrete class of dao entity.
     * @param id  unique dao entity identification value.
     * @return object found in database.
     * @throws ServiceException if SQLException or DaoException occurred.
     */
    default Object read(final Class<?> cls, final Serializable id)
            throws ServiceException {
        try {
            try (Connection connection = DataSource.getInstance()
                    .getConnection()) {
                return new PersonDaoImpl(connection).select(cls, id);
            }
        } catch (SQLException | DaoException e) {
            throw new ServiceException(e);
        }
    }

    /**
     * @param object dao entity which needs to be updated in database.
     * @throws ServiceException if SQLException or DaoException occurred.
     */
    default void update(final Object object) throws ServiceException {
        try {
            try (Connection connection = DataSource.getInstance()
                    .getConnection()) {
                new PersonDaoImpl(connection).update(object);
            }
        } catch (SQLException | DaoException e) {
            throw new ServiceException(e);
        }
    }

    /**
     * @param cls concrete class of dao entity.
     * @param id  unique dao entity identification value.
     * @return number of changed rows in database table.
     * @throws ServiceException if SQLException or DaoException occurred.
     */
    default int delete(final Class<?> cls, final Serializable id)
            throws ServiceException {
        try {
            try (Connection connection = DataSource.getInstance()
                    .getConnection()) {
                return new PersonDaoImpl(connection).delete(cls, id);
            }
        } catch (SQLException | DaoException e) {
            throw new ServiceException(e);
        }
    }
}
