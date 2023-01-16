package by.academy.task05daoAnnotation.dao;

import java.sql.Connection;
import java.sql.SQLException;

public final class Transaction {
	private Connection connection;

	public void init(final AbstractDao<?>... daoArgs) throws DaoException {
		if (connection == null) {
			connection = DataSource.getInstance().getConnection();
		}
		try {
			connection.setAutoCommit(false);
		} catch (SQLException newE) {
			throw new DaoException(newE);
		}
		for (AbstractDao<?> daoItem : daoArgs) {
			daoItem.setConnection(connection);
		}
	}

	public void commit() throws DaoException {
		try {
			connection.commit();
		} catch (SQLException newE) {
			throw new DaoException(newE);
		}
	}

	public void rollBack() throws DaoException {
		try {
			connection.rollback();
		} catch (SQLException newE) {
			throw new DaoException(newE);
		}
	}
}
