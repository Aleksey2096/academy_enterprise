package by.academy.task04mysql.dao;

import java.io.Serializable;
import java.util.Collection;

import by.academy.task04mysql.exception.DaoException;

public interface CollectionDao<T extends Serializable> {
	Collection<T> deserializeCollection(String path) throws DaoException;

	void serializeCollection(Collection<T> collection, String path) throws DaoException;
}
