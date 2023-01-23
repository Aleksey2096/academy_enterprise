package by.academy.task06dao.dao;

public final class DatabaseQuery {
    /**
     * executes insert query for dao entity object, using reflection.
     */
    public static final String INSERT = "INSERT INTO %s(%s) VALUES(%s)";
    /**
     * executes select query for dao entity object, using reflection.
     */
    public static final String SELECT = "SELECT %s FROM %s WHERE %s = ?";
    /**
     * executes update query for dao entity object, using reflection.
     */
    public static final String UPDATE = "UPDATE %s SET %s WHERE %s = ?";
    /**
     * executes delete query for dao entity object, using reflection.
     */
    public static final String DELETE = "DELETE FROM %s WHERE %s = ?";
    /**
     * executes select query from person table.
     */
    public static final String SELECT_PEOPLE_BY_FIELD
            = "SELECT id, name, surname FROM person WHERE %s = ?";

    private DatabaseQuery() {
    }
}
