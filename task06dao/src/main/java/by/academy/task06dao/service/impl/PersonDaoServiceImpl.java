package by.academy.task06dao.service.impl;

import java.sql.Connection;
import java.util.List;

import by.academy.task06dao.dao.DaoException;
import by.academy.task06dao.dao.DataSource;
import by.academy.task06dao.dao.impl.PersonDaoImpl;
import by.academy.task06dao.entity.Person;
import by.academy.task06dao.service.PersonDaoService;
import by.academy.task06dao.service.ServiceException;

public final class PersonDaoServiceImpl implements PersonDaoService {
	@Override
	public List<Person> readByName(final String name) throws ServiceException {
		Connection connection = null;
		try {
			connection = DataSource.getInstance().getConnection();
			return new PersonDaoImpl(connection).selectByName(name);
		} catch (DaoException e) {
			throw new ServiceException(e);
		} finally {
			try {
				closeConnection(connection);
			} catch (DaoException e) {
				throw new ServiceException(e);
			}
		}
	}

	@Override
	public List<Person> readBySurname(final String surname) throws ServiceException {
		Connection connection = null;
		try {
			connection = DataSource.getInstance().getConnection();
			return new PersonDaoImpl(connection).selectBySurname(surname);
		} catch (DaoException e) {
			throw new ServiceException(e);
		} finally {
			try {
				closeConnection(connection);
			} catch (DaoException e) {
				throw new ServiceException(e);
			}
		}
	}
}
