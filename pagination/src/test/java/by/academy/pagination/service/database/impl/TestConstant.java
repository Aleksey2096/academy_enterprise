package by.academy.pagination.service.database.impl;

public final class TestConstant {
    public static final String TEST_PROPERTIES_URL = "liquibase/liquibase";
    public static final String URL = "url";
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";
    public static final String SELECT_PERSON_BY_ID_SQL
            = "SELECT id, name, surname FROM person WHERE id = ?";
    public static final String CLEAR_PERSON_TABLE_SQL = "DELETE FROM person";
    public static final String INSERT_PERSON_SQL
            = "INSERT INTO person (name, surname) VALUES (?,?)";
    public static final String ID_COLUMN_TITLE = "id";
    public static final String NAME_COLUMN_TITLE = "name";
    public static final String SURNAME_COLUMN_TITLE = "surname";
    public static final int ZERO_INDEX = 0;
    public static final int FIRST_INDEX = 1;
    public static final int SECOND_INDEX = 2;
    public static final String TEST_NAME1 = "testName1";
    public static final String TEST_SURNAME1 = "testSurname1";
    public static final String EQUALS_ALL_FIELDS
            = "Test equality of all Person fields.";
    public static final String UPDATED_STRING = "_Updated";
}
