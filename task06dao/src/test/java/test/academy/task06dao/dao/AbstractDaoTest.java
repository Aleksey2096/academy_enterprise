package test.academy.task06dao.dao;

import by.academy.task06dao.dao.AbstractDao;
import by.academy.task06dao.dao.DaoException;
import by.academy.task06dao.dao.impl.PersonDaoImpl;
import by.academy.task06dao.entity.Person;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import test.academy.task06dao.TestConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.stream.Stream;

import static by.academy.task06dao.entity.Constant.ID_COLUMN_TITLE;
import static by.academy.task06dao.entity.Constant.NAME_COLUMN_TITLE;
import static by.academy.task06dao.entity.Constant.SURNAME_COLUMN_TITLE;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static test.academy.task06dao.TestResource.CREATE_PERSON_TABLE_SQL;
import static test.academy.task06dao.TestResource.DELETE_PERSON_TABLE_SQL;
import static test.academy.task06dao.TestResource.SELECT_PERSON_BY_ID_SQL;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
final class AbstractDaoTest {
	private static Connection connection;
	private static AbstractDao abstractDao;

	@BeforeAll
	static void createPersonData() throws DaoException {
		connection = TestConnection.getInstance().getConnection();
		abstractDao = new PersonDaoImpl(connection);
		try (Statement statement = connection.createStatement()) {
			statement.execute(CREATE_PERSON_TABLE_SQL);
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}

	private static Stream<Arguments> providePeopleForTestInsert() {
		return Stream.of(Arguments.of(new Person(1, "Conrad", "Potter")),
				Arguments.of(new Person(2, "Kathy", "Kirkham")),
				Arguments.of(new Person(3, "Alvin", "Greenwood")),
				Arguments.of(new Person(4, "Kelly", "Felderman")),
				Arguments.of(new Person(5, "Edward", "Williamson")),
				Arguments.of(new Person(6, "Maria", "Webb")),
				Arguments.of(new Person(7, "Stanley", "Webb")),
				Arguments.of(new Person(8, "Alice", "Kingston")),
				Arguments.of(new Person(9, "Bradley", "Hagman")),
				Arguments.of(new Person(10, "Danielle", "Sadler")));
	}

	private static Stream<Arguments> providePeopleForTestSelect() {
		return Stream.of(Arguments.of(new Person(1, "Conrad", "Potter"), Person.class, 1),
				Arguments.of(new Person(2, "Kathy", "Kirkham"), Person.class, 2),
				Arguments.of(new Person(3, "Alvin", "Greenwood"), Person.class, 3),
				Arguments.of(new Person(4, "Kelly", "Felderman"), Person.class, 4),
				Arguments.of(new Person(5, "Edward", "Williamson"), Person.class, 5),
				Arguments.of(new Person(6, "Maria", "Webb"), Person.class, 6),
				Arguments.of(new Person(7, "Stanley", "Webb"), Person.class, 7),
				Arguments.of(new Person(8, "Alice", "Kingston"), Person.class, 8),
				Arguments.of(new Person(9, "Bradley", "Hagman"), Person.class, 9),
				Arguments.of(new Person(10, "Danielle", "Sadler"), Person.class, 10));
	}

	private static Stream<Arguments> providePeopleForTestUpdate() {
		return Stream.of(
				Arguments.of(new Person(1, "Conrad", "Potter"), new Person(1, "CONRAD", "POTTER")),
				Arguments.of(new Person(2, "Kathy", "Kirkham"), new Person(2, "KATHY", "KIRKHAM")),
				Arguments.of(new Person(3, "Alvin", "Greenwood"),
						new Person(3, "ALVIN", "GREENWOOD")),
				Arguments.of(new Person(4, "Kelly", "Felderman"),
						new Person(4, "KELLY", "FELDERMAN")),
				Arguments.of(new Person(5, "Edward", "Williamson"),
						new Person(5, "EDWARD", "WILLIAMSON")),
				Arguments.of(new Person(6, "Maria", "Webb"), new Person(6, "MARIA", "WEBB")),
				Arguments.of(new Person(7, "Stanley", "Webb"), new Person(7, "STANLEY", "WEBB")),
				Arguments.of(new Person(8, "Alice", "Kingston"),
						new Person(8, "ALICE", "KINGSTON")),
				Arguments.of(new Person(9, "Bradley", "Hagman"),
						new Person(9, "BRADLEY", "HAGMAN")),
				Arguments.of(new Person(10, "Danielle", "Sadler"),
						new Person(10, "DANIELLE", "SADLER")));
	}

	private static Stream<Arguments> providePeopleForTestDelete() {
		return Stream.of(Arguments.of(1, Person.class, 1), Arguments.of(1, Person.class, 2),
				Arguments.of(1, Person.class, 3), Arguments.of(1, Person.class, 4),
				Arguments.of(1, Person.class, 5), Arguments.of(1, Person.class, 6),
				Arguments.of(1, Person.class, 7), Arguments.of(1, Person.class, 8),
				Arguments.of(1, Person.class, 9), Arguments.of(1, Person.class, 10));
	}

	@ParameterizedTest
	@MethodSource("providePeopleForTestInsert")
	@Order(1)
	void testInsert(final Person person) throws DaoException {
		abstractDao.insert(person);
		assertEquals(person, selectById(person.getId()));
	}

	@ParameterizedTest
	@MethodSource("providePeopleForTestSelect")
	@Order(2)
	void testSelect(final Person person, final Class<Person> cls, final int id)
			throws DaoException {
		assertEquals(person, abstractDao.select(cls, id));
	}

	@ParameterizedTest
	@MethodSource("providePeopleForTestUpdate")
	@Order(3)
	void testUpdate(final Person person, final Person updatedPerson) throws DaoException {
		person.setName(person.getName().toUpperCase());
		person.setSurname(person.getSurname().toUpperCase());
		abstractDao.update(updatedPerson);
		assertEquals(person, selectById(person.getId()));
	}

	@ParameterizedTest
	@MethodSource("providePeopleForTestDelete")
	@Order(4)
	void testDelete(final int changedRows, final Class<Person> cls,
					final int id) {
		assertAll(() -> assertEquals(changedRows, abstractDao.delete(cls, id)),
				() -> assertNull(selectById(id)));
	}

	private Person selectById(final int id) throws DaoException {
		try (PreparedStatement statement = connection.prepareStatement(SELECT_PERSON_BY_ID_SQL)) {
			statement.setInt(1, id);
			ResultSet resultset = statement.executeQuery();
			Person person = null;
			while (resultset.next()) {
				person = createPerson(resultset);
			}
			return person;
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}

	private Person createPerson(final ResultSet resultset) throws SQLException {
		Person person = new Person();
		person.setId(resultset.getInt(ID_COLUMN_TITLE));
		person.setName(resultset.getString(NAME_COLUMN_TITLE));
		person.setSurname(resultset.getString(SURNAME_COLUMN_TITLE));
		return person;
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
