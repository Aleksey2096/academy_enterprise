package by.academy.task06dao.service;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;

import by.academy.task06dao.dao.DaoException;
import by.academy.task06dao.dao.DataSource;
import by.academy.task06dao.dao.impl.PersonDaoImpl;

public interface DaoService<T> {
	default public Object create(final Object object) throws ServiceException {
		Connection connection = null;
		try {
			connection = DataSource.getInstance().getConnection();
			return new PersonDaoImpl(connection).insert(object);
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

	default public Object read(final Class<?> cls, final Serializable id) throws ServiceException {
		Connection connection = null;
		try {
			connection = DataSource.getInstance().getConnection();
			return new PersonDaoImpl(connection).select(cls, id);
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

	default public void update(final Object object) throws ServiceException {
		Connection connection = null;
		try {
			connection = DataSource.getInstance().getConnection();
			new PersonDaoImpl(connection).update(object);
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

//	default public void update(final Object object) throws ServiceException {
//	Connection connection = null;
//	try {
//		connection = DataSource.getInstance().getTransactionConnection();
//		new PersonDaoImpl(connection).update(object);
//		commit(connection);
//	} catch (DaoException e) {
//		try {
//			rollback(connection);
//		} catch (DaoException e1) {
//			throw new ServiceException(e1);
//		}
//		throw new ServiceException(e);
//	} finally {
//		try {
//			closeConnection(connection);
//		} catch (DaoException e) {
//			throw new ServiceException(e);
//		}
//	}
//}

	default public int delete(final Class<?> cls, final Serializable id) throws ServiceException {
		Connection connection = null;
		try {
			connection = DataSource.getInstance().getConnection();
			return new PersonDaoImpl(connection).delete(cls, id);
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

	default void commit(final Connection connection) throws DaoException {
		try {
			connection.commit();
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}

	default void rollback(final Connection connection) throws DaoException {
		try {
			connection.rollback();
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}

	default void closeConnection(final Connection connection) throws DaoException {
		try {
			if (!connection.getAutoCommit()) {
				connection.setAutoCommit(true);
			}
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}
}
