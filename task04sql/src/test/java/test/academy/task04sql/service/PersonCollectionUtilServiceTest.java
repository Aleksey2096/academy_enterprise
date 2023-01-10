package test.academy.task04sql.service;

import static by.academy.task04sql.entity.Constant.SPACE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static test.academy.task04sql.TestResource.PERSON_COLLECTION_CREATOR;
import static test.academy.task04sql.TestResource.PERSON_COLLECTION_UTIL_SERVICE;
import static test.academy.task04sql.TestResource.TEST_AGE_VALUE_FOR_PERSON_MESSAGE;
import static test.academy.task04sql.TestResource.TEST_MAX_AGE;
import static test.academy.task04sql.TestResource.TEST_MIN_AGE;
import static test.academy.task04sql.TestResource.TEST_PEOPLE_QUANTITY;
import static test.academy.task04sql.TestResource.TEST_PERSON_COMPARATOR;
import static test.academy.task04sql.TestResource.TEST_UNDER_AGE_VALUE;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import by.academy.task04sql.entity.Person;

public class PersonCollectionUtilServiceTest {
	private static Collection<Person> people;

	@BeforeAll
	static void createPeople() {
		people = PERSON_COLLECTION_CREATOR.create(TEST_PEOPLE_QUANTITY, TEST_MIN_AGE, TEST_MAX_AGE);
	}

	@TestFactory
	Stream<DynamicTest> testSelectPeopleUnderAgeFromStream() {
		final Collection<Person> peopleUnderAge = PERSON_COLLECTION_UTIL_SERVICE
				.selectPeopleUnderAge(people, TEST_UNDER_AGE_VALUE);
		return peopleUnderAge.stream()
				.map(person -> DynamicTest.dynamicTest(TEST_AGE_VALUE_FOR_PERSON_MESSAGE + person,
						() -> assertTrue(person.getAge() < TEST_UNDER_AGE_VALUE)));
	}

	@Test
	void testSortPeople() {
		assertEquals(people.stream().sorted(TEST_PERSON_COMPARATOR).collect(Collectors.toList()),
				PERSON_COLLECTION_UTIL_SERVICE.sortPeople(people, TEST_PERSON_COMPARATOR));
	}

	@Test
	void testSelectDistinctPeople() {
		assertEquals(people.stream().distinct().collect(Collectors.toList()),
				PERSON_COLLECTION_UTIL_SERVICE.selectDistinctPeople(people));
	}

	@Test
	void testConvertIntoSurnameNameList() {
		assertEquals(
				people.stream().map(person -> person.getSurname() + SPACE + person.getName())
						.collect(Collectors.toList()),
				PERSON_COLLECTION_UTIL_SERVICE.convertIntoSurnameNameList(people));
	}
}
