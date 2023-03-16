package by.academy.pagination.service.database.impl;

import by.academy.pagination.entity.Person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import static by.academy.pagination.service.database.impl.TestConstant.CLEAR_PERSON_TABLE_SQL;
import static by.academy.pagination.service.database.impl.TestConstant.FIRST_INDEX;
import static by.academy.pagination.service.database.impl.TestConstant.ID_COLUMN_TITLE;
import static by.academy.pagination.service.database.impl.TestConstant.INSERT_PERSON_SQL;
import static by.academy.pagination.service.database.impl.TestConstant.NAME_COLUMN_TITLE;
import static by.academy.pagination.service.database.impl.TestConstant.PASSWORD;
import static by.academy.pagination.service.database.impl.TestConstant.SECOND_INDEX;
import static by.academy.pagination.service.database.impl.TestConstant.SELECT_PERSON_BY_ID_SQL;
import static by.academy.pagination.service.database.impl.TestConstant.TEST_NAME1;
import static by.academy.pagination.service.database.impl.TestConstant.TEST_PROPERTIES_URL;
import static by.academy.pagination.service.database.impl.TestConstant.TEST_SURNAME1;
import static by.academy.pagination.service.database.impl.TestConstant.URL;
import static by.academy.pagination.service.database.impl.TestConstant.USERNAME;
import static by.academy.pagination.service.database.impl.TestConstant.SURNAME_COLUMN_TITLE;

public final class MockUtil {
    private static final ResourceBundle PROPERTIES = ResourceBundle.getBundle(
            TEST_PROPERTIES_URL);
    public static final String URL_STRING = PROPERTIES.getString(URL);
    public static final String USER = PROPERTIES.getString(USERNAME);
    public static final String PASS = PROPERTIES.getString(PASSWORD);

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL_STRING, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Person createTestPerson() {
        return Person.builder()
                .name(TEST_NAME1)
                .surname(TEST_SURNAME1)
                .build();
    }

    public static void clearPersonTable(Connection connection)
            throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(
                CLEAR_PERSON_TABLE_SQL)) {
            statement.executeUpdate();
        }
    }

    public static Person selectById(final int id, Connection connection)
            throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(
                SELECT_PERSON_BY_ID_SQL)) {
            statement.setInt(FIRST_INDEX, id);
            ResultSet resultset = statement.executeQuery();
            Person person = null;
            while (resultset.next()) {
                person = createPerson(resultset);
            }
            return person;
        }
    }

    public static void insertPerson(Person person, Connection connection)
            throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(
                INSERT_PERSON_SQL, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(FIRST_INDEX, person.getName());
            statement.setString(SECOND_INDEX, person.getSurname());
            statement.executeUpdate();
            ResultSet keys = statement.getGeneratedKeys();
            if (keys.next()) {
                person.setId(statement.getGeneratedKeys().getInt(FIRST_INDEX));
            }
        }
    }

    private static Person createPerson(final ResultSet resultset)
            throws SQLException {
        return Person.builder().id(resultset.getInt(ID_COLUMN_TITLE))
                .name(resultset.getString(NAME_COLUMN_TITLE))
                .surname(resultset.getString(SURNAME_COLUMN_TITLE)).build();
    }
}
