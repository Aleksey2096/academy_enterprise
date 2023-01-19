package by.academy.task06dao.dao;

public final class DatabaseQuery {
	public static final String INSERT = "INSERT INTO %s(%s) VALUES(%s)";
	public static final String SELECT = "SELECT %s FROM %s WHERE %s = ?";
	public static final String UPDATE = "UPDATE %s SET %s WHERE %s = ?";
	public static final String DELETE = "DELETE FROM %s WHERE %s = ?";

	public static final String SELECT_PEOPLE_BY_NAME = "SELECT id, name, surname FROM person WHERE name = ?";
	public static final String SELECT_PEOPLE_BY_SURNAME = "SELECT id, name, surname FROM person WHERE surname = ?";

	private DatabaseQuery() {
	}
}
