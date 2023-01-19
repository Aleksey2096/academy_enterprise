package by.academy.task06dao.dao;

import java.sql.Connection;
import java.util.List;

import by.academy.task06dao.entity.Person;

public abstract class AbstractPersonDao extends AbstractDao<Person> {
	public AbstractPersonDao(final Connection connection) {
		super(connection);
	}

	public abstract List<Person> selectByName(String name) throws DaoException;

	public abstract List<Person> selectBySurname(String surname) throws DaoException;
}
