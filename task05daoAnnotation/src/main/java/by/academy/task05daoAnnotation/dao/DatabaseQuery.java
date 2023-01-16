package by.academy.task05daoAnnotation.dao;

public final class DatabaseQuery {
	public static final String INSERT = "INSERT INTO %s(%s) VALUES(%s)";
	public static final String SELECT = "SELECT %s FROM %s WHERE %s = ?";
	public static final String UPDATE = "UPDATE %s SET %s WHERE %s = ?";
	public static final String DELETE = "DELETE FROM %s WHERE %s = ?";

	private DatabaseQuery() {
	}
}
