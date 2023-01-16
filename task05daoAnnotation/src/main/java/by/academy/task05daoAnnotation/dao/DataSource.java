package by.academy.task05daoAnnotation.dao;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public final class DataSource {
	private static DataSource dataSource;
	private final ComboPooledDataSource comboPooledDataSource;

	private DataSource() throws PropertyVetoException {
		comboPooledDataSource = new ComboPooledDataSource();
		comboPooledDataSource.setDriverClass(DatabaseProperty.DRIVER_CLASS);
		comboPooledDataSource.setJdbcUrl(DatabaseProperty.JDBC_URL);
		comboPooledDataSource.setUser(DatabaseProperty.USER);
		comboPooledDataSource.setPassword(DatabaseProperty.PASSWORD);
		comboPooledDataSource.setMinPoolSize(DatabaseProperty.MIN_POOL_SIZE);
		comboPooledDataSource.setAcquireIncrement(DatabaseProperty.ACQUIRE_INCREMENT);
		comboPooledDataSource.setMaxPoolSize(DatabaseProperty.MAX_POOL_SIZE);
		comboPooledDataSource.setMaxStatements(DatabaseProperty.MAX_STATEMENTS);
	}

	public static DataSource getInstance() throws DaoException {
		try {
			if (dataSource == null) {
				dataSource = new DataSource();
			}
			return dataSource;
		} catch (PropertyVetoException e) {
			throw new DaoException(e);
		}
	}

	public Connection getConnection() throws DaoException {
		try {
			return comboPooledDataSource.getConnection();
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}
}
