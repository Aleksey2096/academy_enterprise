package test.academy.task04sql.service;

import by.academy.task04sql.entity.Person;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static test.academy.task04sql.TestResource.PERSON_COLLECTION_UTIL_SERVICE;
import static test.academy.task04sql.TestResource.TEST_AGE_VALUE_FOR_PERSON_MESSAGE;
import static test.academy.task04sql.TestResource.TEST_PERSON_COMPARATOR;
import static test.academy.task04sql.TestResource.TEST_UNDER_AGE_VALUE;

public class PersonCollectionUtilServiceTest {
	private static Collection<Person> testPeople;
	private static Collection<Person> sortedPeople;
	private static Collection<Person> distinctPeople;
	private static Collection<String> surnameNameList;

	@BeforeAll
	static void createTestPeople() {
		testPeople = new ArrayList<>();
		testPeople.add(new Person("JAMES", "HERNANDEZ", 22));
		testPeople.add(new Person("ELIZABETH", "ANDERSON", 26));
		testPeople.add(new Person("SARAH", "WALKER", 17));
		testPeople.add(new Person("ROBERT", "SMITH", 17));
		testPeople.add(new Person("DAVID", "ANDERSON", 17));
		testPeople.add(new Person("DAVID", "CAMPBELL", 20));
		testPeople.add(new Person("WILLIAM", "THOMPSON", 19));
		testPeople.add(new Person("MARY", "MILLER", 22));
		testPeople.add(new Person("RICHARD", "CLARK", 24));
		testPeople.add(new Person("ELIZABETH", "JOHNSON", 19));
		testPeople.add(new Person("RICHARD", "JOHNSON", 25));
		testPeople.add(new Person("RICHARD", "BROWN", 27));
		testPeople.add(new Person("DAVID", "DAVIS", 28));
		testPeople.add(new Person("BARBARA", "SMITH", 25));
		testPeople.add(new Person("JAMES", "HERNANDEZ", 22));
		testPeople.add(new Person("JOSEPH", "BROWN", 24));
		testPeople.add(new Person("BARBARA", "MILLER", 15));
		testPeople.add(new Person("JOSEPH", "WHITE", 25));
		testPeople.add(new Person("JOSEPH", "WILLIAMS", 18));
		testPeople.add(new Person("THOMAS", "SMITH", 21));
		testPeople.add(new Person("PATRICIA", "GARCIA", 26));
		testPeople.add(new Person("SUSAN", "MARTINEZ", 19));
		testPeople.add(new Person("JOSEPH", "MILLER", 19));
		testPeople.add(new Person("JESSICA", "HERNANDEZ", 16));
		testPeople.add(new Person("THOMAS", "DAVIS", 28));
		testPeople.add(new Person("BARBARA", "RODRIGUEZ", 28));
		testPeople.add(new Person("MARY", "CAMPBELL", 18));
		testPeople.add(new Person("CHARLES", "WILLIAMS", 21));
		testPeople.add(new Person("JAMES", "MOORE", 17));
		testPeople.add(new Person("DAVID", "ANDERSON", 28));
		testPeople.add(new Person("JOHN", "RODRIGUEZ", 17));
		testPeople.add(new Person("MARY", "RODRIGUEZ", 26));
		testPeople.add(new Person("WILLIAM", "HERNANDEZ", 24));
		testPeople.add(new Person("PATRICIA", "MARTINEZ", 21));
		testPeople.add(new Person("SUSAN", "BROWN", 18));
		testPeople.add(new Person("JAMES", "ROBINSON", 22));
		testPeople.add(new Person("JOSEPH", "JOHNSON", 23));
		testPeople.add(new Person("ROBERT", "ROBINSON", 17));
		testPeople.add(new Person("BARBARA", "WILLIAMS", 24));
		testPeople.add(new Person("RICHARD", "MILLER", 26));
		testPeople.add(new Person("MICHAEL", "SMITH", 21));
		testPeople.add(new Person("MICHAEL", "CAMPBELL", 15));
		testPeople.add(new Person("WILLIAM", "RODRIGUEZ", 25));
		testPeople.add(new Person("JESSICA", "BROWN", 25));
		testPeople.add(new Person("SARAH", "THOMPSON", 26));
		testPeople.add(new Person("MARY", "WHITE", 19));
		testPeople.add(new Person("JENNIFER", "JOHNSON", 19));
		testPeople.add(new Person("MICHAEL", "WALKER", 16));
		testPeople.add(new Person("LINDA", "RODRIGUEZ", 27));
		testPeople.add(new Person("KAREN", "CAMPBELL", 19));
		testPeople.add(new Person("BARBARA", "CLARK", 29));
		testPeople.add(new Person("SUSAN", "WHITE", 28));
		testPeople.add(new Person("ELIZABETH", "HERNANDEZ", 26));
		testPeople.add(new Person("CHARLES", "SMITH", 16));
		testPeople.add(new Person("KAREN", "BROWN", 21));
		testPeople.add(new Person("ELIZABETH", "MOORE", 22));
		testPeople.add(new Person("JOSEPH", "WALKER", 22));
		testPeople.add(new Person("SARAH", "WALKER", 24));
		testPeople.add(new Person("JENNIFER", "ROBINSON", 17));
		testPeople.add(new Person("JAMES", "MARTINEZ", 23));
		testPeople.add(new Person("DAVID", "JOHNSON", 24));
		testPeople.add(new Person("BARBARA", "DAVIS", 29));
		testPeople.add(new Person("LINDA", "HERNANDEZ", 25));
		testPeople.add(new Person("LINDA", "MILLER", 28));
		testPeople.add(new Person("MARY", "WILLIAMS", 16));
		testPeople.add(new Person("ROBERT", "RODRIGUEZ", 28));
		testPeople.add(new Person("JAMES", "MOORE", 16));
		testPeople.add(new Person("LINDA", "CLARK", 18));
		testPeople.add(new Person("JENNIFER", "BROWN", 29));
		testPeople.add(new Person("CHARLES", "CLARK", 19));
		testPeople.add(new Person("THOMAS", "THOMPSON", 15));
		testPeople.add(new Person("SARAH", "WALKER", 22));
		testPeople.add(new Person("JOSEPH", "DAVIS", 21));
		testPeople.add(new Person("PATRICIA", "SMITH", 28));
		testPeople.add(new Person("CHARLES", "MILLER", 17));
		testPeople.add(new Person("DAVID", "SMITH", 29));
		testPeople.add(new Person("LINDA", "CLARK", 18));
		testPeople.add(new Person("SUSAN", "MOORE", 23));
		testPeople.add(new Person("JOHN", "THOMPSON", 15));
		testPeople.add(new Person("JOHN", "JOHNSON", 28));
		testPeople.add(new Person("THOMAS", "MARTINEZ", 17));
		testPeople.add(new Person("JESSICA", "ANDERSON", 26));
		testPeople.add(new Person("MARY", "SMITH", 20));
		testPeople.add(new Person("JOSEPH", "ROBINSON", 20));
		testPeople.add(new Person("THOMAS", "RODRIGUEZ", 24));
		testPeople.add(new Person("JESSICA", "WILLIAMS", 18));
		testPeople.add(new Person("DAVID", "DAVIS", 28));
		testPeople.add(new Person("JOHN", "ANDERSON", 27));
		testPeople.add(new Person("BARBARA", "THOMPSON", 17));
		testPeople.add(new Person("MICHAEL", "WALKER", 28));
		testPeople.add(new Person("LINDA", "MARTINEZ", 22));
		testPeople.add(new Person("MARY", "WHITE", 25));
		testPeople.add(new Person("ROBERT", "YOUNG", 19));
		testPeople.add(new Person("MICHAEL", "WHITE", 22));
		testPeople.add(new Person("SUSAN", "SMITH", 17));
		testPeople.add(new Person("BARBARA", "CLARK", 17));
		testPeople.add(new Person("JOSEPH", "MILLER", 21));
		testPeople.add(new Person("JOSEPH", "ROBINSON", 17));
		testPeople.add(new Person("LINDA", "ROBINSON", 26));
		testPeople.add(new Person("SARAH", "CAMPBELL", 18));
	}

	@BeforeAll
	static void createSortedPeople() {
		sortedPeople = new ArrayList<>();
		sortedPeople.add(new Person("DAVID", "ANDERSON", 17));
		sortedPeople.add(new Person("DAVID", "ANDERSON", 28));
		sortedPeople.add(new Person("ELIZABETH", "ANDERSON", 26));
		sortedPeople.add(new Person("JESSICA", "ANDERSON", 26));
		sortedPeople.add(new Person("JOHN", "ANDERSON", 27));
		sortedPeople.add(new Person("JENNIFER", "BROWN", 29));
		sortedPeople.add(new Person("JESSICA", "BROWN", 25));
		sortedPeople.add(new Person("JOSEPH", "BROWN", 24));
		sortedPeople.add(new Person("KAREN", "BROWN", 21));
		sortedPeople.add(new Person("RICHARD", "BROWN", 27));
		sortedPeople.add(new Person("SUSAN", "BROWN", 18));
		sortedPeople.add(new Person("DAVID", "CAMPBELL", 20));
		sortedPeople.add(new Person("KAREN", "CAMPBELL", 19));
		sortedPeople.add(new Person("MARY", "CAMPBELL", 18));
		sortedPeople.add(new Person("MICHAEL", "CAMPBELL", 15));
		sortedPeople.add(new Person("SARAH", "CAMPBELL", 18));
		sortedPeople.add(new Person("BARBARA", "CLARK", 29));
		sortedPeople.add(new Person("BARBARA", "CLARK", 17));
		sortedPeople.add(new Person("CHARLES", "CLARK", 19));
		sortedPeople.add(new Person("LINDA", "CLARK", 18));
		sortedPeople.add(new Person("LINDA", "CLARK", 18));
		sortedPeople.add(new Person("RICHARD", "CLARK", 24));
		sortedPeople.add(new Person("BARBARA", "DAVIS", 29));
		sortedPeople.add(new Person("DAVID", "DAVIS", 28));
		sortedPeople.add(new Person("DAVID", "DAVIS", 28));
		sortedPeople.add(new Person("JOSEPH", "DAVIS", 21));
		sortedPeople.add(new Person("THOMAS", "DAVIS", 28));
		sortedPeople.add(new Person("PATRICIA", "GARCIA", 26));
		sortedPeople.add(new Person("ELIZABETH", "HERNANDEZ", 26));
		sortedPeople.add(new Person("JAMES", "HERNANDEZ", 22));
		sortedPeople.add(new Person("JAMES", "HERNANDEZ", 22));
		sortedPeople.add(new Person("JESSICA", "HERNANDEZ", 16));
		sortedPeople.add(new Person("LINDA", "HERNANDEZ", 25));
		sortedPeople.add(new Person("WILLIAM", "HERNANDEZ", 24));
		sortedPeople.add(new Person("DAVID", "JOHNSON", 24));
		sortedPeople.add(new Person("ELIZABETH", "JOHNSON", 19));
		sortedPeople.add(new Person("JENNIFER", "JOHNSON", 19));
		sortedPeople.add(new Person("JOHN", "JOHNSON", 28));
		sortedPeople.add(new Person("JOSEPH", "JOHNSON", 23));
		sortedPeople.add(new Person("RICHARD", "JOHNSON", 25));
		sortedPeople.add(new Person("JAMES", "MARTINEZ", 23));
		sortedPeople.add(new Person("LINDA", "MARTINEZ", 22));
		sortedPeople.add(new Person("PATRICIA", "MARTINEZ", 21));
		sortedPeople.add(new Person("SUSAN", "MARTINEZ", 19));
		sortedPeople.add(new Person("THOMAS", "MARTINEZ", 17));
		sortedPeople.add(new Person("BARBARA", "MILLER", 15));
		sortedPeople.add(new Person("CHARLES", "MILLER", 17));
		sortedPeople.add(new Person("JOSEPH", "MILLER", 19));
		sortedPeople.add(new Person("JOSEPH", "MILLER", 21));
		sortedPeople.add(new Person("LINDA", "MILLER", 28));
		sortedPeople.add(new Person("MARY", "MILLER", 22));
		sortedPeople.add(new Person("RICHARD", "MILLER", 26));
		sortedPeople.add(new Person("ELIZABETH", "MOORE", 22));
		sortedPeople.add(new Person("JAMES", "MOORE", 17));
		sortedPeople.add(new Person("JAMES", "MOORE", 16));
		sortedPeople.add(new Person("SUSAN", "MOORE", 23));
		sortedPeople.add(new Person("JAMES", "ROBINSON", 22));
		sortedPeople.add(new Person("JENNIFER", "ROBINSON", 17));
		sortedPeople.add(new Person("JOSEPH", "ROBINSON", 20));
		sortedPeople.add(new Person("JOSEPH", "ROBINSON", 17));
		sortedPeople.add(new Person("LINDA", "ROBINSON", 26));
		sortedPeople.add(new Person("ROBERT", "ROBINSON", 17));
		sortedPeople.add(new Person("BARBARA", "RODRIGUEZ", 28));
		sortedPeople.add(new Person("JOHN", "RODRIGUEZ", 17));
		sortedPeople.add(new Person("LINDA", "RODRIGUEZ", 27));
		sortedPeople.add(new Person("MARY", "RODRIGUEZ", 26));
		sortedPeople.add(new Person("ROBERT", "RODRIGUEZ", 28));
		sortedPeople.add(new Person("THOMAS", "RODRIGUEZ", 24));
		sortedPeople.add(new Person("WILLIAM", "RODRIGUEZ", 25));
		sortedPeople.add(new Person("BARBARA", "SMITH", 25));
		sortedPeople.add(new Person("CHARLES", "SMITH", 16));
		sortedPeople.add(new Person("DAVID", "SMITH", 29));
		sortedPeople.add(new Person("MARY", "SMITH", 20));
		sortedPeople.add(new Person("MICHAEL", "SMITH", 21));
		sortedPeople.add(new Person("PATRICIA", "SMITH", 28));
		sortedPeople.add(new Person("ROBERT", "SMITH", 17));
		sortedPeople.add(new Person("SUSAN", "SMITH", 17));
		sortedPeople.add(new Person("THOMAS", "SMITH", 21));
		sortedPeople.add(new Person("BARBARA", "THOMPSON", 17));
		sortedPeople.add(new Person("JOHN", "THOMPSON", 15));
		sortedPeople.add(new Person("SARAH", "THOMPSON", 26));
		sortedPeople.add(new Person("THOMAS", "THOMPSON", 15));
		sortedPeople.add(new Person("WILLIAM", "THOMPSON", 19));
		sortedPeople.add(new Person("JOSEPH", "WALKER", 22));
		sortedPeople.add(new Person("MICHAEL", "WALKER", 16));
		sortedPeople.add(new Person("MICHAEL", "WALKER", 28));
		sortedPeople.add(new Person("SARAH", "WALKER", 17));
		sortedPeople.add(new Person("SARAH", "WALKER", 24));
		sortedPeople.add(new Person("SARAH", "WALKER", 22));
		sortedPeople.add(new Person("JOSEPH", "WHITE", 25));
		sortedPeople.add(new Person("MARY", "WHITE", 19));
		sortedPeople.add(new Person("MARY", "WHITE", 25));
		sortedPeople.add(new Person("MICHAEL", "WHITE", 22));
		sortedPeople.add(new Person("SUSAN", "WHITE", 28));
		sortedPeople.add(new Person("BARBARA", "WILLIAMS", 24));
		sortedPeople.add(new Person("CHARLES", "WILLIAMS", 21));
		sortedPeople.add(new Person("JESSICA", "WILLIAMS", 18));
		sortedPeople.add(new Person("JOSEPH", "WILLIAMS", 18));
		sortedPeople.add(new Person("MARY", "WILLIAMS", 16));
		sortedPeople.add(new Person("ROBERT", "YOUNG", 19));
	}

	@BeforeAll
	static void createDistinctPeople() {
		distinctPeople = new ArrayList<>();
		distinctPeople.add(new Person("JAMES", "HERNANDEZ", 22));
		distinctPeople.add(new Person("ELIZABETH", "ANDERSON", 26));
		distinctPeople.add(new Person("SARAH", "WALKER", 17));
		distinctPeople.add(new Person("ROBERT", "SMITH", 17));
		distinctPeople.add(new Person("DAVID", "ANDERSON", 17));
		distinctPeople.add(new Person("DAVID", "CAMPBELL", 20));
		distinctPeople.add(new Person("WILLIAM", "THOMPSON", 19));
		distinctPeople.add(new Person("MARY", "MILLER", 22));
		distinctPeople.add(new Person("RICHARD", "CLARK", 24));
		distinctPeople.add(new Person("ELIZABETH", "JOHNSON", 19));
		distinctPeople.add(new Person("RICHARD", "JOHNSON", 25));
		distinctPeople.add(new Person("RICHARD", "BROWN", 27));
		distinctPeople.add(new Person("DAVID", "DAVIS", 28));
		distinctPeople.add(new Person("BARBARA", "SMITH", 25));
		distinctPeople.add(new Person("JOSEPH", "BROWN", 24));
		distinctPeople.add(new Person("BARBARA", "MILLER", 15));
		distinctPeople.add(new Person("JOSEPH", "WHITE", 25));
		distinctPeople.add(new Person("JOSEPH", "WILLIAMS", 18));
		distinctPeople.add(new Person("THOMAS", "SMITH", 21));
		distinctPeople.add(new Person("PATRICIA", "GARCIA", 26));
		distinctPeople.add(new Person("SUSAN", "MARTINEZ", 19));
		distinctPeople.add(new Person("JOSEPH", "MILLER", 19));
		distinctPeople.add(new Person("JESSICA", "HERNANDEZ", 16));
		distinctPeople.add(new Person("THOMAS", "DAVIS", 28));
		distinctPeople.add(new Person("BARBARA", "RODRIGUEZ", 28));
		distinctPeople.add(new Person("MARY", "CAMPBELL", 18));
		distinctPeople.add(new Person("CHARLES", "WILLIAMS", 21));
		distinctPeople.add(new Person("JAMES", "MOORE", 17));
		distinctPeople.add(new Person("DAVID", "ANDERSON", 28));
		distinctPeople.add(new Person("JOHN", "RODRIGUEZ", 17));
		distinctPeople.add(new Person("MARY", "RODRIGUEZ", 26));
		distinctPeople.add(new Person("WILLIAM", "HERNANDEZ", 24));
		distinctPeople.add(new Person("PATRICIA", "MARTINEZ", 21));
		distinctPeople.add(new Person("SUSAN", "BROWN", 18));
		distinctPeople.add(new Person("JAMES", "ROBINSON", 22));
		distinctPeople.add(new Person("JOSEPH", "JOHNSON", 23));
		distinctPeople.add(new Person("ROBERT", "ROBINSON", 17));
		distinctPeople.add(new Person("BARBARA", "WILLIAMS", 24));
		distinctPeople.add(new Person("RICHARD", "MILLER", 26));
		distinctPeople.add(new Person("MICHAEL", "SMITH", 21));
		distinctPeople.add(new Person("MICHAEL", "CAMPBELL", 15));
		distinctPeople.add(new Person("WILLIAM", "RODRIGUEZ", 25));
		distinctPeople.add(new Person("JESSICA", "BROWN", 25));
		distinctPeople.add(new Person("SARAH", "THOMPSON", 26));
		distinctPeople.add(new Person("MARY", "WHITE", 19));
		distinctPeople.add(new Person("JENNIFER", "JOHNSON", 19));
		distinctPeople.add(new Person("MICHAEL", "WALKER", 16));
		distinctPeople.add(new Person("LINDA", "RODRIGUEZ", 27));
		distinctPeople.add(new Person("KAREN", "CAMPBELL", 19));
		distinctPeople.add(new Person("BARBARA", "CLARK", 29));
		distinctPeople.add(new Person("SUSAN", "WHITE", 28));
		distinctPeople.add(new Person("ELIZABETH", "HERNANDEZ", 26));
		distinctPeople.add(new Person("CHARLES", "SMITH", 16));
		distinctPeople.add(new Person("KAREN", "BROWN", 21));
		distinctPeople.add(new Person("ELIZABETH", "MOORE", 22));
		distinctPeople.add(new Person("JOSEPH", "WALKER", 22));
		distinctPeople.add(new Person("SARAH", "WALKER", 24));
		distinctPeople.add(new Person("JENNIFER", "ROBINSON", 17));
		distinctPeople.add(new Person("JAMES", "MARTINEZ", 23));
		distinctPeople.add(new Person("DAVID", "JOHNSON", 24));
		distinctPeople.add(new Person("BARBARA", "DAVIS", 29));
		distinctPeople.add(new Person("LINDA", "HERNANDEZ", 25));
		distinctPeople.add(new Person("LINDA", "MILLER", 28));
		distinctPeople.add(new Person("MARY", "WILLIAMS", 16));
		distinctPeople.add(new Person("ROBERT", "RODRIGUEZ", 28));
		distinctPeople.add(new Person("JAMES", "MOORE", 16));
		distinctPeople.add(new Person("LINDA", "CLARK", 18));
		distinctPeople.add(new Person("JENNIFER", "BROWN", 29));
		distinctPeople.add(new Person("CHARLES", "CLARK", 19));
		distinctPeople.add(new Person("THOMAS", "THOMPSON", 15));
		distinctPeople.add(new Person("SARAH", "WALKER", 22));
		distinctPeople.add(new Person("JOSEPH", "DAVIS", 21));
		distinctPeople.add(new Person("PATRICIA", "SMITH", 28));
		distinctPeople.add(new Person("CHARLES", "MILLER", 17));
		distinctPeople.add(new Person("DAVID", "SMITH", 29));
		distinctPeople.add(new Person("SUSAN", "MOORE", 23));
		distinctPeople.add(new Person("JOHN", "THOMPSON", 15));
		distinctPeople.add(new Person("JOHN", "JOHNSON", 28));
		distinctPeople.add(new Person("THOMAS", "MARTINEZ", 17));
		distinctPeople.add(new Person("JESSICA", "ANDERSON", 26));
		distinctPeople.add(new Person("MARY", "SMITH", 20));
		distinctPeople.add(new Person("JOSEPH", "ROBINSON", 20));
		distinctPeople.add(new Person("THOMAS", "RODRIGUEZ", 24));
		distinctPeople.add(new Person("JESSICA", "WILLIAMS", 18));
		distinctPeople.add(new Person("JOHN", "ANDERSON", 27));
		distinctPeople.add(new Person("BARBARA", "THOMPSON", 17));
		distinctPeople.add(new Person("MICHAEL", "WALKER", 28));
		distinctPeople.add(new Person("LINDA", "MARTINEZ", 22));
		distinctPeople.add(new Person("MARY", "WHITE", 25));
		distinctPeople.add(new Person("ROBERT", "YOUNG", 19));
		distinctPeople.add(new Person("MICHAEL", "WHITE", 22));
		distinctPeople.add(new Person("SUSAN", "SMITH", 17));
		distinctPeople.add(new Person("BARBARA", "CLARK", 17));
		distinctPeople.add(new Person("JOSEPH", "MILLER", 21));
		distinctPeople.add(new Person("JOSEPH", "ROBINSON", 17));
		distinctPeople.add(new Person("LINDA", "ROBINSON", 26));
		distinctPeople.add(new Person("SARAH", "CAMPBELL", 18));
	}

	@BeforeAll
	static void createSurnameNameList() {
		surnameNameList = new ArrayList<>();
		surnameNameList.add("HERNANDEZ JAMES");
		surnameNameList.add("ANDERSON ELIZABETH");
		surnameNameList.add("WALKER SARAH");
		surnameNameList.add("SMITH ROBERT");
		surnameNameList.add("ANDERSON DAVID");
		surnameNameList.add("CAMPBELL DAVID");
		surnameNameList.add("THOMPSON WILLIAM");
		surnameNameList.add("MILLER MARY");
		surnameNameList.add("CLARK RICHARD");
		surnameNameList.add("JOHNSON ELIZABETH");
		surnameNameList.add("JOHNSON RICHARD");
		surnameNameList.add("BROWN RICHARD");
		surnameNameList.add("DAVIS DAVID");
		surnameNameList.add("SMITH BARBARA");
		surnameNameList.add("HERNANDEZ JAMES");
		surnameNameList.add("BROWN JOSEPH");
		surnameNameList.add("MILLER BARBARA");
		surnameNameList.add("WHITE JOSEPH");
		surnameNameList.add("WILLIAMS JOSEPH");
		surnameNameList.add("SMITH THOMAS");
		surnameNameList.add("GARCIA PATRICIA");
		surnameNameList.add("MARTINEZ SUSAN");
		surnameNameList.add("MILLER JOSEPH");
		surnameNameList.add("HERNANDEZ JESSICA");
		surnameNameList.add("DAVIS THOMAS");
		surnameNameList.add("RODRIGUEZ BARBARA");
		surnameNameList.add("CAMPBELL MARY");
		surnameNameList.add("WILLIAMS CHARLES");
		surnameNameList.add("MOORE JAMES");
		surnameNameList.add("ANDERSON DAVID");
		surnameNameList.add("RODRIGUEZ JOHN");
		surnameNameList.add("RODRIGUEZ MARY");
		surnameNameList.add("HERNANDEZ WILLIAM");
		surnameNameList.add("MARTINEZ PATRICIA");
		surnameNameList.add("BROWN SUSAN");
		surnameNameList.add("ROBINSON JAMES");
		surnameNameList.add("JOHNSON JOSEPH");
		surnameNameList.add("ROBINSON ROBERT");
		surnameNameList.add("WILLIAMS BARBARA");
		surnameNameList.add("MILLER RICHARD");
		surnameNameList.add("SMITH MICHAEL");
		surnameNameList.add("CAMPBELL MICHAEL");
		surnameNameList.add("RODRIGUEZ WILLIAM");
		surnameNameList.add("BROWN JESSICA");
		surnameNameList.add("THOMPSON SARAH");
		surnameNameList.add("WHITE MARY");
		surnameNameList.add("JOHNSON JENNIFER");
		surnameNameList.add("WALKER MICHAEL");
		surnameNameList.add("RODRIGUEZ LINDA");
		surnameNameList.add("CAMPBELL KAREN");
		surnameNameList.add("CLARK BARBARA");
		surnameNameList.add("WHITE SUSAN");
		surnameNameList.add("HERNANDEZ ELIZABETH");
		surnameNameList.add("SMITH CHARLES");
		surnameNameList.add("BROWN KAREN");
		surnameNameList.add("MOORE ELIZABETH");
		surnameNameList.add("WALKER JOSEPH");
		surnameNameList.add("WALKER SARAH");
		surnameNameList.add("ROBINSON JENNIFER");
		surnameNameList.add("MARTINEZ JAMES");
		surnameNameList.add("JOHNSON DAVID");
		surnameNameList.add("DAVIS BARBARA");
		surnameNameList.add("HERNANDEZ LINDA");
		surnameNameList.add("MILLER LINDA");
		surnameNameList.add("WILLIAMS MARY");
		surnameNameList.add("RODRIGUEZ ROBERT");
		surnameNameList.add("MOORE JAMES");
		surnameNameList.add("CLARK LINDA");
		surnameNameList.add("BROWN JENNIFER");
		surnameNameList.add("CLARK CHARLES");
		surnameNameList.add("THOMPSON THOMAS");
		surnameNameList.add("WALKER SARAH");
		surnameNameList.add("DAVIS JOSEPH");
		surnameNameList.add("SMITH PATRICIA");
		surnameNameList.add("MILLER CHARLES");
		surnameNameList.add("SMITH DAVID");
		surnameNameList.add("CLARK LINDA");
		surnameNameList.add("MOORE SUSAN");
		surnameNameList.add("THOMPSON JOHN");
		surnameNameList.add("JOHNSON JOHN");
		surnameNameList.add("MARTINEZ THOMAS");
		surnameNameList.add("ANDERSON JESSICA");
		surnameNameList.add("SMITH MARY");
		surnameNameList.add("ROBINSON JOSEPH");
		surnameNameList.add("RODRIGUEZ THOMAS");
		surnameNameList.add("WILLIAMS JESSICA");
		surnameNameList.add("DAVIS DAVID");
		surnameNameList.add("ANDERSON JOHN");
		surnameNameList.add("THOMPSON BARBARA");
		surnameNameList.add("WALKER MICHAEL");
		surnameNameList.add("MARTINEZ LINDA");
		surnameNameList.add("WHITE MARY");
		surnameNameList.add("YOUNG ROBERT");
		surnameNameList.add("WHITE MICHAEL");
		surnameNameList.add("SMITH SUSAN");
		surnameNameList.add("CLARK BARBARA");
		surnameNameList.add("MILLER JOSEPH");
		surnameNameList.add("ROBINSON JOSEPH");
		surnameNameList.add("ROBINSON LINDA");
		surnameNameList.add("CAMPBELL SARAH");
	}

	@TestFactory
	Stream<DynamicTest> testSelectPeopleUnderAgeFromStream() {
		final Collection<Person> peopleUnderAge = PERSON_COLLECTION_UTIL_SERVICE
				.selectPeopleUnderAge(testPeople, TEST_UNDER_AGE_VALUE);
		return peopleUnderAge.stream()
				.map(person -> DynamicTest.dynamicTest(TEST_AGE_VALUE_FOR_PERSON_MESSAGE + person,
						() -> assertTrue(person.getAge() < TEST_UNDER_AGE_VALUE)));
	}

	@Test
	void testSortPeople() {
		assertEquals(sortedPeople,
				PERSON_COLLECTION_UTIL_SERVICE.sortPeople(testPeople,
						TEST_PERSON_COMPARATOR));
	}

	@Test
	void testSelectDistinctPeople() {
		assertEquals(distinctPeople,
				PERSON_COLLECTION_UTIL_SERVICE.selectDistinctPeople(
						testPeople));
	}

	@Test
	void testConvertIntoSurnameNameList() {
		assertEquals(surnameNameList,
				PERSON_COLLECTION_UTIL_SERVICE.convertIntoSurnameNameList(
						testPeople));
	}
}
