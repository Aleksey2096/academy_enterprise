package test.academy.task04mysql.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static test.academy.task04mysql.TestResource.PERSON_COLLECTION_CREATOR;
import static test.academy.task04mysql.TestResource.PERSON_COLLECTION_DAO;
import static test.academy.task04mysql.TestResource.TEST_MAX_AGE;
import static test.academy.task04mysql.TestResource.TEST_MIN_AGE;
import static test.academy.task04mysql.TestResource.TEST_PEOPLE_QUANTITY;
import static test.academy.task04mysql.TestResource.TEST_PEOPLE_RESOURCE_FILE;

import java.util.Collection;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import by.academy.task04mysql.entity.Person;
import by.academy.task04mysql.exception.DaoException;

public class PersonCollectionDaoTest {
	private static Collection<Person> serializedPeople;

	@BeforeAll
	static void createPeople() {
		serializedPeople = PERSON_COLLECTION_CREATOR.create(TEST_PEOPLE_QUANTITY, TEST_MIN_AGE,
				TEST_MAX_AGE);
	}

	@Test
	void testSerialization() throws DaoException {
		PERSON_COLLECTION_DAO.serializeCollection(serializedPeople, TEST_PEOPLE_RESOURCE_FILE);
		assertEquals(serializedPeople,
				PERSON_COLLECTION_DAO.deserializeCollection(TEST_PEOPLE_RESOURCE_FILE));
	}
}
