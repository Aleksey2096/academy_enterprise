package test.academy.task03strategy.service;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static test.academy.task03strategy.entity.StudentType1Test.RANDOM;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import by.academy.task03strategy.service.ClassManager;

public class ClassManagerTest {
	private final static int NUM_OF_STUDENTS_TYPE_1 = RANDOM.nextInt(100) + 1;
	private final static int NUM_OF_STUDENTS_TYPE_2 = RANDOM.nextInt(100) + 1;
	private final static int NUM_OF_STUDENTS_TYPE_3 = RANDOM.nextInt(100) + 1;
	private final static double BASE_TIME_FOR_ANALYSIS = 66;
	private final static String SUBJECT_TITLE = "java core";
	private static ClassManager classManager;

	private final static ByteArrayOutputStream out = new ByteArrayOutputStream();
	private final static PrintStream originalOut = System.out;

	@BeforeAll
	static void addStudents() {
		classManager = new ClassManager(NUM_OF_STUDENTS_TYPE_1, NUM_OF_STUDENTS_TYPE_2,
				NUM_OF_STUDENTS_TYPE_3);
		classManager.setClassForSubject(BASE_TIME_FOR_ANALYSIS, SUBJECT_TITLE);
	}

	@BeforeAll
	static void setOutStream() {
		System.setOut(new PrintStream(out));
	}

	@Test
	void testNumberOfStudents() {
		assertEquals(NUM_OF_STUDENTS_TYPE_1 + NUM_OF_STUDENTS_TYPE_2 + NUM_OF_STUDENTS_TYPE_3,
				classManager.getStudents().size());
	}

	@TestFactory
	Stream<DynamicTest> testSetClassForSubjectFromStream() {
		return classManager.getStudents().stream().map(
				x -> DynamicTest.dynamicTest("Test setClassForSubject() for sudent = " + x, () -> {
					assertAll("check baseTimeForAnalysis and subjectTitle values are not null",
							() -> assertTrue(x.getBaseTimeForAnalysis() != null),
							() -> assertTrue(x.getSubjectTitle() != null));
				}));
	}

	@Test
	void testPrintClassInfo() {
		StringBuilder sb = new StringBuilder();
		sb.append("Subject: " + classManager.getStudents().get(0).getSubjectTitle() + "\r" + "\n");
		classManager.getStudents().forEach(x -> sb.append(x).append("\r").append("\n"));
		classManager.printClassInfo();
		assertEquals(sb.toString(), out.toString());
	}

	@AfterAll
	static void restoreInitialOutStream() {
		System.setOut(originalOut);
	}
}
