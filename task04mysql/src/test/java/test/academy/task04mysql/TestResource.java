package test.academy.task04mysql;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.Objects;

import by.academy.task04mysql.dao.CollectionDao;
import by.academy.task04mysql.dao.impl.PersonCollectionDao;
import by.academy.task04mysql.entity.Person;
import by.academy.task04mysql.service.CollectionPrinter;
import by.academy.task04mysql.service.PersonCollectionCreator;
import by.academy.task04mysql.service.PersonCollectionUtilService;

public class TestResource {
	public static final CollectionDao<Person> PERSON_COLLECTION_DAO = new PersonCollectionDao();
	public static final PersonCollectionCreator PERSON_COLLECTION_CREATOR = new PersonCollectionCreator();
	public static final PersonCollectionUtilService PERSON_COLLECTION_UTIL_SERVICE = new PersonCollectionUtilService();
	public static final CollectionPrinter COLLECTION_PRINTER = new CollectionPrinter();

	public static final String TEST_PEOPLE_RESOURCE_FILE = Objects
			.requireNonNull(TestResource.class.getClassLoader().getResource("data/testPeople.dat"))
			.getFile();
	public static final int TEST_PEOPLE_QUANTITY = 100;
	public static final int TEST_MAX_AGE = 30;
	public static final int TEST_MIN_AGE = 15;
	public static final int TEST_UNDER_AGE_VALUE = 21;
	public static final PrintStream ORIGINAL_OUT = System.out;
	public static final Comparator<Person> TEST_PERSON_COMPARATOR = Comparator
			.comparing(Person::getSurname).thenComparing(Person::getName);
	public static final String CARRIAGE_RETURN = "\r";
	public static final String STRING_RETURN = "\n";
	public static final String TEST_AGE_VALUE_FOR_PERSON_MESSAGE = "Test age value for person = ";

	private TestResource() {
	}
}
