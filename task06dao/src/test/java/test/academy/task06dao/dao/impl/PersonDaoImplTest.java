package test.academy.task06dao.dao.impl;

import by.academy.task06dao.dao.AbstractPersonDao;
import by.academy.task06dao.dao.DaoException;
import by.academy.task06dao.dao.impl.PersonDaoImpl;
import by.academy.task06dao.entity.Person;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import test.academy.task06dao.TestConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static test.academy.task06dao.TestResource.CREATE_PERSON_TABLE_SQL;
import static test.academy.task06dao.TestResource.DELETE_PERSON_TABLE_SQL;
import static test.academy.task06dao.TestResource.INSERT_TEST_PEOPLE_SQL;

final class PersonDaoImplTest {
	private static Connection connection;
	private static AbstractPersonDao abstractPersonDao;

	@BeforeAll
	static void createPersonData() throws DaoException {
		connection = TestConnection.getInstance().getConnection();
		abstractPersonDao = new PersonDaoImpl(connection);
		try (Statement statement = connection.createStatement()) {
			statement.execute(CREATE_PERSON_TABLE_SQL);
			statement.execute(INSERT_TEST_PEOPLE_SQL);
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}

	private static Stream<Arguments> providePeopleForTestSelectByName() {
		return Stream.of(Arguments.of(List.of(new Person(1, "Conrad", "Potter")), "Conrad"),
				Arguments.of(List.of(new Person(2, "Kathy", "Kirkham")), "Kathy"),
				Arguments.of(List.of(new Person(3, "Alvin", "Greenwood")), "Alvin"),
				Arguments.of(List.of(new Person(4, "Kelly", "Felderman")), "Kelly"),
				Arguments.of(List.of(new Person(5, "Edward", "Williamson")), "Edward"),
				Arguments.of(List.of(new Person(6, "Maria", "Webb")), "Maria"),
				Arguments.of(List.of(new Person(7, "Stanley", "Webb")), "Stanley"),
				Arguments.of(List.of(new Person(8, "Alice", "Kingston")), "Alice"),
				Arguments.of(List.of(new Person(9, "Bradley", "Hagman")), "Bradley"),
				Arguments.of(List.of(new Person(10, "Danielle", "Sadler")), "Danielle"));
	}

	private static Stream<Arguments> providePeopleForTestSelectBySurname() {
		return Stream.of(
				Arguments.of(List.of(new Person(1, "Conrad", "Potter")),
						"Potter"),
				Arguments.of(List.of(new Person(2, "Kathy", "Kirkham")),
						"Kirkham"),
				Arguments.of(List.of(new Person(3, "Alvin", "Greenwood")),
						"Greenwood"),
				Arguments.of(List.of(new Person(4, "Kelly", "Felderman")),
						"Felderman"),
				Arguments.of(List.of(new Person(5, "Edward", "Williamson")),
						"Williamson"),
				Arguments.of(List.of(new Person(6, "Maria", "Webb"),
						new Person(7, "Stanley", "Webb")), "Webb"),
				Arguments.of(List.of(new Person(6, "Maria", "Webb"),
						new Person(7, "Stanley", "Webb")), "Webb"),
				Arguments.of(List.of(new Person(8, "Alice", "Kingston")),
						"Kingston"),
				Arguments.of(List.of(new Person(9, "Bradley", "Hagman")),
						"Hagman"),
				Arguments.of(List.of(new Person(10, "Danielle", "Sadler")),
						"Sadler"));
	}

	@ParameterizedTest
	@MethodSource("providePeopleForTestSelectByName")
	void testSelectByName(final List<Person> personList, final String name) throws DaoException {
		assertEquals(personList, abstractPersonDao.selectByName(name));
	}

	@ParameterizedTest
	@MethodSource("providePeopleForTestSelectBySurname")
	void testSelectBySurname(final List<Person> personList, final String surname)
			throws DaoException {
		assertEquals(personList, abstractPersonDao.selectBySurname(surname));
	}

	@AfterAll
	static void deletePersonData() throws DaoException {
		try (Statement statement = connection.createStatement()) {
			statement.execute(DELETE_PERSON_TABLE_SQL);
		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
