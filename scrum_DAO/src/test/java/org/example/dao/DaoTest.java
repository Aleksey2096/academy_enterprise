package org.example.dao;

import org.example.DAO;
import org.example.DAOPerson;
import org.example.Person;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import static org.example.dao.MockUtil.getConnection;
import static org.example.dao.MockUtil.selectById;
import static org.example.dao.TestConstant.CARRIAGE_RETURN;
import static org.example.dao.TestConstant.CREATE_PERSON_TABLE_SQL;
import static org.example.dao.TestConstant.DELETE_PERSON_TABLE_SQL;
import static org.example.dao.TestConstant.ORIGINAL_OUT;
import static org.example.dao.TestConstant.STRING_RETURN;
import static org.example.dao.TestConstant.TABULATION;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
final class DaoTest {
    private static Connection connection;
    private static DAO<Person> daoPerson;
    private static ByteArrayOutputStream out;

    @BeforeAll
    static void createPersonData() throws SQLException {
        connection = getConnection();
        connection.setAutoCommit(false);
        daoPerson = new DAOPerson();
        daoPerson.setConnection(connection);
        try (Statement statement = connection.createStatement()) {
            statement.execute(CREATE_PERSON_TABLE_SQL);
            connection.commit();
        }
    }

    @BeforeEach
    void setOutStream() {
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
    }

    @Test
    @Order(1)
    void testInsert() throws SQLException {
        Person person = new Person(1, "Conrad", "Potter");
        daoPerson.insert(person);
        assertEquals(person, selectById(person.getId(), connection));
    }

    @Test
    @Order(2)
    void testSelect() {
        Person person = new Person(1, "Conrad", "Potter");
        String printedPerson = CARRIAGE_RETURN + STRING_RETURN + "Conrad"
                + TABULATION + "Potter" + TABULATION;
        daoPerson.select(person);
        assertEquals(printedPerson, out.toString());
    }

    @Test
    @Order(3)
    void testUpdate() throws SQLException {
        Person person = new Person(1, "Conrad", "Potter");
        Person updatedPerson = new Person(1, "CONRAD", "POTTER");
        person.setName(person.getName().toUpperCase());
        person.setSurname(person.getSurname().toUpperCase());
        daoPerson.update(updatedPerson);
        assertEquals(person, selectById(person.getId(), connection));
    }

    @Test
    @Order(4)
    void testDelete() throws SQLException {
        Person person = new Person(1, null, null);
        daoPerson.delete(person);
        assertNull(selectById(person.getId(), connection));
    }

    @AfterAll
    static void deletePersonData() throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.execute(DELETE_PERSON_TABLE_SQL);
        } finally {
            connection.close();
        }
    }

    @AfterAll
    static void restoreInitialOutStream() {
        System.setOut(ORIGINAL_OUT);
    }
}
