package test.academy.task06dao;

import java.util.ResourceBundle;

public final class TestResource {
    private static final ResourceBundle RESOURCE_BUNDLE
            = ResourceBundle.getBundle("data/database");
    public static final String JDBC_URL = RESOURCE_BUNDLE.getString("test.url");
    public static final String USER = RESOURCE_BUNDLE.getString("test.user");
    public static final String PASSWORD = RESOURCE_BUNDLE.getString(
            "test.password");

    public static final String CREATE_PERSON_TABLE_SQL
            = "CREATE TABLE person (id INTEGER GENERATED BY DEFAULT AS IDENTITY, name VARCHAR(255) NOT NULL, surname VARCHAR(255) NOT NULL, CONSTRAINT PK_person PRIMARY KEY (id))";
    public static final String DELETE_PERSON_TABLE_SQL = "DROP TABLE person";
    public static final String SELECT_PERSON_BY_ID_SQL
            = "SELECT id, name, surname FROM person WHERE id = ?";
    public static final String INSERT_TEST_PEOPLE_SQL
            = "INSERT INTO person(name,surname) VALUES('Conrad','Potter'),('Kathy','Kirkham'),('Alvin','Greenwood'),('Kelly','Felderman'),('Edward','Williamson'),('Maria','Webb'),('Stanley','Webb'),('Alice','Kingston'),('Bradley','Hagman'),('Danielle','Sadler')";

    private TestResource() {
    }
}
