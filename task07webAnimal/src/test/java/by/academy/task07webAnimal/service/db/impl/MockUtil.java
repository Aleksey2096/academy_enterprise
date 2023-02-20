package by.academy.task07webAnimal.service.db.impl;

import by.academy.task07webAnimal.entity.Animal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import static by.academy.task07webAnimal.service.db.impl.TestConstant.CLEAR_ANIMAL_TABLE_SQL;
import static by.academy.task07webAnimal.service.db.impl.TestConstant.FIRST_INDEX;
import static by.academy.task07webAnimal.service.db.impl.TestConstant.ID_COLUMN_TITLE;
import static by.academy.task07webAnimal.service.db.impl.TestConstant.INSERT_ANIMAL_SQL;
import static by.academy.task07webAnimal.service.db.impl.TestConstant.NAME_COLUMN_TITLE;
import static by.academy.task07webAnimal.service.db.impl.TestConstant.PASSWORD;
import static by.academy.task07webAnimal.service.db.impl.TestConstant.SECOND_INDEX;
import static by.academy.task07webAnimal.service.db.impl.TestConstant.SELECT_ANIMAL_BY_ID_SQL;
import static by.academy.task07webAnimal.service.db.impl.TestConstant.TEST_NAME1;
import static by.academy.task07webAnimal.service.db.impl.TestConstant.TEST_PROPERTIES_URL;
import static by.academy.task07webAnimal.service.db.impl.TestConstant.TEST_WEIGHT1;
import static by.academy.task07webAnimal.service.db.impl.TestConstant.URL;
import static by.academy.task07webAnimal.service.db.impl.TestConstant.USERNAME;
import static by.academy.task07webAnimal.service.db.impl.TestConstant.WEIGHT_COLUMN_TITLE;

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

    public static Animal createTestAnimal() {
        return Animal.builder()
                .name(TEST_NAME1)
                .weight(TEST_WEIGHT1)
                .build();
    }

    public static void clearAnimalTable(Connection connection)
            throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(
                CLEAR_ANIMAL_TABLE_SQL)) {
            statement.executeUpdate();
        }
    }

    public static Animal selectById(final int id, Connection connection)
            throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(
                SELECT_ANIMAL_BY_ID_SQL)) {
            statement.setInt(FIRST_INDEX, id);
            ResultSet resultset = statement.executeQuery();
            Animal animal = null;
            while (resultset.next()) {
                animal = createAnimal(resultset);
            }
            return animal;
        }
    }

    public static void insertAnimal(Animal animal, Connection connection)
            throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(
                INSERT_ANIMAL_SQL, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(FIRST_INDEX, animal.getName());
            statement.setDouble(SECOND_INDEX, animal.getWeight());
            statement.executeUpdate();
            ResultSet keys = statement.getGeneratedKeys();
            if (keys.next()) {
                animal.setId(statement.getGeneratedKeys().getInt(FIRST_INDEX));
            }
        }
    }

    private static Animal createAnimal(final ResultSet resultset)
            throws SQLException {
        return Animal.builder().id(resultset.getInt(ID_COLUMN_TITLE))
                .name(resultset.getString(NAME_COLUMN_TITLE))
                .weight(resultset.getDouble(WEIGHT_COLUMN_TITLE)).build();
    }
}
