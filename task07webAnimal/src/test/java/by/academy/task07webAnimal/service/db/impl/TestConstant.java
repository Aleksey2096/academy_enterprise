package by.academy.task07webAnimal.service.db.impl;

public final class TestConstant {
    public static final String TEST_PROPERTIES_URL = "liquibase/liquibase";
    public static final String URL = "url";
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";
    public static final String SELECT_ANIMAL_BY_ID_SQL
            = "SELECT id, name, weight FROM animal WHERE id = ?";
    public static final String CLEAR_ANIMAL_TABLE_SQL = "DELETE FROM animal";
    public static final String INSERT_ANIMAL_SQL
            = "INSERT INTO animal (name, weight) VALUES (?,?)";
    public static final String ID_COLUMN_TITLE = "id";
    public static final String NAME_COLUMN_TITLE = "name";
    public static final String WEIGHT_COLUMN_TITLE = "weight";
    public static final int ZERO_INDEX = 0;
    public static final int FIRST_INDEX = 1;
    public static final int SECOND_INDEX = 2;
    public static final String TEST_NAME1 = "Guinea Pig";
    public static final Double TEST_WEIGHT1 = 1.040;
    public static final String EQUALS_ALL_FIELDS
            = "Test equality of all Animal fields.";
    public static final String UPDATED_STRING = "_Updated";
    public static final Double UPDATED_WEIGHT = 999.99;
}
