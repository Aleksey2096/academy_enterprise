package by.academy.task05daoAnnotation.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class AbstractDao<T> {
	private Connection connection;

	public abstract T insert(T object) throws DaoException;

	public abstract T select(Class<?> cls, Serializable id) throws DaoException;

	public abstract void update(T object) throws DaoException;

	public abstract int delete(Class<?> cls, Serializable id) throws DaoException;

	public void close(final Statement statement) throws DaoException {
		try {
			if (statement != null) {
				statement.close();
			}
		} catch (SQLException newE) {
			throw new DaoException(newE);
		}
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(final Connection connection) {
		this.connection = connection;
	}
}
