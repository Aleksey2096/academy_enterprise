package by.academy.task04sql.dao.impl;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;

import by.academy.task04sql.dao.CollectionDao;
import by.academy.task04sql.entity.Person;
import by.academy.task04sql.exception.DaoException;

public final class PersonCollectionDao implements CollectionDao<Person> {

	@Override
	public Collection<Person> deserializeCollection(final String path) throws DaoException {
		final Collection<Person> people = new ArrayList<>();
		try (ObjectInputStream objectInputStream = new ObjectInputStream(
				new FileInputStream(path))) {
			while (true) {
				try {
					people.add((Person) objectInputStream.readObject());
				} catch (final EOFException e) {
					break;
				}
			}
		} catch (IOException | ClassNotFoundException e) {
			throw new DaoException(e);
		}
		return people;
	}

	@Override
	public void serializeCollection(final Collection<Person> collection, final String path)
			throws DaoException {
		try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(
				new FileOutputStream(path))) {
			for (final Person person : collection) {
				objectOutputStream.writeObject(person);
			}
		} catch (final IOException e) {
			throw new DaoException(e);
		}
	}
}
