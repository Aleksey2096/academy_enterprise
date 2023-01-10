package test.academy.task04sql.service;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static test.academy.task04sql.TestResource.PERSON_COLLECTION_CREATOR;
import static test.academy.task04sql.TestResource.TEST_AGE_VALUE_FOR_PERSON_MESSAGE;
import static test.academy.task04sql.TestResource.TEST_MAX_AGE;
import static test.academy.task04sql.TestResource.TEST_MIN_AGE;
import static test.academy.task04sql.TestResource.TEST_PEOPLE_QUANTITY;

import java.util.Collection;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import by.academy.task04sql.entity.Person;

public class PersonCollectionCreatorTest {
	private static Collection<Person> people;

	@BeforeAll
	static void createPeople() {
		people = PERSON_COLLECTION_CREATOR.create(TEST_PEOPLE_QUANTITY, TEST_MIN_AGE, TEST_MAX_AGE);
	}

	@Test
	void testCollectionSize() {
		assertEquals(TEST_PEOPLE_QUANTITY, people.size());
	}

	@TestFactory
	Stream<DynamicTest> testAgeValueFromStream() {
		return people.stream().map(person -> DynamicTest
				.dynamicTest(TEST_AGE_VALUE_FOR_PERSON_MESSAGE + person, () -> {
					assertAll(() -> assertTrue(person.getAge() >= TEST_MIN_AGE),
							() -> assertTrue(person.getAge() < TEST_MAX_AGE));
				}));
	}
}
