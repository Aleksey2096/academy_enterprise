package by.academy.task06dao.dao.impl;

import static by.academy.task06dao.dao.DatabaseQuery.SELECT_PEOPLE_BY_NAME;
import static by.academy.task06dao.dao.DatabaseQuery.SELECT_PEOPLE_BY_SURNAME;
import static by.academy.task06dao.entity.Constant.ID_COLUMN_TITLE;
import static by.academy.task06dao.entity.Constant.NAME_COLUMN_TITLE;
import static by.academy.task06dao.entity.Constant.SURNAME_COLUMN_TITLE;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import by.academy.task06dao.dao.AbstractPersonDao;
import by.academy.task06dao.dao.DaoException;
import by.academy.task06dao.entity.Person;

public class PersonDaoImpl extends AbstractPersonDao {
	public PersonDaoImpl(final Connection connection) {
		super(connection);
	}

	@Override
	public List<Person> selectByName(final String name) throws DaoException {
		PreparedStatement statement = null;
		try {
			statement = getConnection().prepareStatement(SELECT_PEOPLE_BY_NAME);
			statement.setString(1, name);
			return createPersonList(statement.executeQuery());
		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			closeStatement(statement);
		}
	}

	@Override
	public List<Person> selectBySurname(final String surname) throws DaoException {
		PreparedStatement statement = null;
		try {
			statement = getConnection().prepareStatement(SELECT_PEOPLE_BY_SURNAME);
			statement.setString(1, surname);
			return createPersonList(statement.executeQuery());
		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			closeStatement(statement);
		}
	}

	private List<Person> createPersonList(final ResultSet resultset) throws SQLException {
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
