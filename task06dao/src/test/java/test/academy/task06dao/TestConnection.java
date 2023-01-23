package test.academy.task06dao;

import static test.academy.task06dao.TestResource.JDBC_URL;
import static test.academy.task06dao.TestResource.PASSWORD;
import static test.academy.task06dao.TestResource.USER;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import by.academy.task06dao.dao.DaoException;

public final class TestConnection {
	private final static TestConnection TEST_CONNECTION = new TestConnection();

	public static TestConnection getInstance() {
		return TEST_CONNECTION;
	}

	public Connection getConnection() throws DaoException {
		try {
			return DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
		} catch (SQLException e) {
			throw new DaoException();
		}
	}
}
