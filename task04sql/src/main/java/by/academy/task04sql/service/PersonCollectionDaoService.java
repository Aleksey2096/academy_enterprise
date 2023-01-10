package by.academy.task04sql.service;

import java.util.Collection;

import by.academy.task04sql.dao.CollectionDao;
import by.academy.task04sql.dao.impl.PersonCollectionDao;
import by.academy.task04sql.entity.Person;
import by.academy.task04sql.exception.DaoException;
import by.academy.task04sql.exception.ServiceException;

public final class PersonCollectionDaoService {
	private final CollectionDao<Person> personCollectionDao = new PersonCollectionDao();

	public void savePersonCollection(final Collection<Person> people, final String filePath)
			throws ServiceException {
		try {
			personCollectionDao.serializeCollection(people, filePath);
		} catch (final DaoException e) {
			throw new ServiceException(e);
		}
	}

	public Collection<Person> readPersonCollection(final String filePath) throws ServiceException {
		try {
			return personCollectionDao.deserializeCollection(filePath);
		} catch (final DaoException e) {
			throw new ServiceException(e);
		}
	}
}
