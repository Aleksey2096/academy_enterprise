package by.academy.task06dao.dao;

import java.util.ResourceBundle;

public final class DatabaseProperty {
	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle("data/database");

	public static final String DRIVER_CLASS = RESOURCE_BUNDLE.getString("db.driverClass");
	public static final String JDBC_URL = RESOURCE_BUNDLE.getString("db.url");
	public static final String USER = RESOURCE_BUNDLE.getString("db.user");
	public static final String PASSWORD = RESOURCE_BUNDLE.getString("db.password");
	public static final Integer MIN_POOL_SIZE = Integer
			.parseInt(RESOURCE_BUNDLE.getString("db.minPoolSize"));
	public static final Integer ACQUIRE_INCREMENT = Integer
			.parseInt(RESOURCE_BUNDLE.getString("db.acquireIncrement"));
	public static final Integer MAX_POOL_SIZE = Integer
			.parseInt(RESOURCE_BUNDLE.getString("db.maxPoolSize"));
	public static final Integer MAX_STATEMENTS = Integer
			.parseInt(RESOURCE_BUNDLE.getString("db.maxStatements"));

	private DatabaseProperty() {
	}
}
