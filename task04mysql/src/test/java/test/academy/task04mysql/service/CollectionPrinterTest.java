package test.academy.task04mysql.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static test.academy.task04mysql.TestResource.CARRIAGE_RETURN;
import static test.academy.task04mysql.TestResource.COLLECTION_PRINTER;
import static test.academy.task04mysql.TestResource.ORIGINAL_OUT;
import static test.academy.task04mysql.TestResource.PERSON_COLLECTION_CREATOR;
import static test.academy.task04mysql.TestResource.STRING_RETURN;
import static test.academy.task04mysql.TestResource.TEST_MAX_AGE;
import static test.academy.task04mysql.TestResource.TEST_MIN_AGE;
import static test.academy.task04mysql.TestResource.TEST_PEOPLE_QUANTITY;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Collection;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import by.academy.task04mysql.entity.Person;

public class CollectionPrinterTest {
	private static ByteArrayOutputStream out;

	@BeforeEach
	void setOutStream() {
		out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
	}

	private static Stream<Arguments> provideCollectionsForTestPrintCollection() {
		return Stream.of(
				Arguments.of(PERSON_COLLECTION_CREATOR.create(TEST_PEOPLE_QUANTITY, TEST_MIN_AGE,
						TEST_MAX_AGE)),
				Arguments.of(PERSON_COLLECTION_CREATOR.create(TEST_PEOPLE_QUANTITY, TEST_MIN_AGE,
						TEST_MAX_AGE)),
				Arguments.of(PERSON_COLLECTION_CREATOR.create(TEST_PEOPLE_QUANTITY, TEST_MIN_AGE,
						TEST_MAX_AGE)),
				Arguments.of(PERSON_COLLECTION_CREATOR.create(TEST_PEOPLE_QUANTITY, TEST_MIN_AGE,
						TEST_MAX_AGE)),
				Arguments.of(PERSON_COLLECTION_CREATOR.create(TEST_PEOPLE_QUANTITY, TEST_MIN_AGE,
						TEST_MAX_AGE)));
	}

	@ParameterizedTest
	@MethodSource("provideCollectionsForTestPrintCollection")
	void testPrintCollection(final Collection<Person> people) {
		final StringBuilder sb = new StringBuilder();
		people.forEach(person -> sb.append(person).append(CARRIAGE_RETURN).append(STRING_RETURN));
		COLLECTION_PRINTER.printCollection(people);
		assertEquals(sb.toString(), out.toString());
	}

	@AfterAll
	static void restoreInitialOutStream() {
		System.setOut(ORIGINAL_OUT);
	}
}