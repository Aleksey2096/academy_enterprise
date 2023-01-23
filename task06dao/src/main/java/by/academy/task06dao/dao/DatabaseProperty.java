package by.academy.task06dao.dao;

import java.util.ResourceBundle;

public final class DatabaseProperty {
    /**
     * resource bundle connected to database properties.
     */
    private static final ResourceBundle RESOURCE_BUNDLE
            = ResourceBundle.getBundle("data/database");
    /**
     * mysql driver class.
     */
    public static final String DRIVER_CLASS = RESOURCE_BUNDLE.getString(
            "db.driverClass");
    /**
     * mysql database url.
     */
    public static final String JDBC_URL = RESOURCE_BUNDLE.getString("db.url");
    /**
     * mysql database user login.
     */
    public static final String USER = RESOURCE_BUNDLE.getString("db.user");
    /**
     * mysql database user password.
     */
    public static final String PASSWORD = RESOURCE_BUNDLE.getString(
            "db.password");
    /**
     * mysql database minimal pool size.
     */
    public static final Integer MIN_POOL_SIZE = Integer
            .parseInt(RESOURCE_BUNDLE.getString("db.minPoolSize"));
    /**
     * acquire increment parameter value.
     */
    public static final Integer ACQUIRE_INCREMENT = Integer
            .parseInt(RESOURCE_BUNDLE.getString("db.acquireIncrement"));
    /**
     * mysql database maximal pool size.
     */
    public static final Integer MAX_POOL_SIZE = Integer
            .parseInt(RESOURCE_BUNDLE.getString("db.maxPoolSize"));
    /**
     * max statements parameter value.
     */
    public static final Integer MAX_STATEMENTS = Integer
            .parseInt(RESOURCE_BUNDLE.getString("db.maxStatements"));

    private DatabaseProperty() {
    }
}
