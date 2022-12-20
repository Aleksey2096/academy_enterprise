package test.academy.task03strategy.entity;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static test.academy.task03strategy.entity.StudentType1Test.RANDOM;
import static test.academy.task03strategy.entity.StudentType1Test.TESTS_NUM;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import by.academy.task03strategy.entity.AbstractStudent;
import by.academy.task03strategy.entity.impl.StudentType1;
import by.academy.task03strategy.entity.impl.StudentType2;
import by.academy.task03strategy.entity.impl.StudentType3;

public class AbstractStudentTest {
	private final static List<AbstractStudent> STUDENTS = new ArrayList<>();

	@BeforeAll
	static void addStudents() {
		for (int i = 0; i < TESTS_NUM; ++i) {
			AbstractStudent studentType1 = new StudentType1();
			studentType1.setBaseTimeForAnalysis(RANDOM.nextInt(1000) + 1);
			STUDENTS.add(studentType1);
			AbstractStudent studentType2 = new StudentType2();
			studentType2.setBaseTimeForAnalysis(RANDOM.nextInt(1000) + 1);
			STUDENTS.add(studentType2);
			AbstractStudent studentType3 = new StudentType3();
			studentType3.setBaseTimeForAnalysis(RANDOM.nextInt(1000) + 1);
			STUDENTS.add(studentType3);
		}
	}

	@TestFactory
	Stream<DynamicTest> testGetTalentFromStream() {
		return STUDENTS.stream()
				.map(x -> DynamicTest.dynamicTest("Test getTalent() for sudent = " + x, () -> {
					assertAll("check talent value is between 0.1 and 1.0",
							() -> assertTrue(x.getTalent() >= 0.1),
							() -> assertTrue(x.getTalent() <= 1.0));
				}));
	}

	@TestFactory
	Stream<DynamicTest> testGetTypeFromStream() {
		return STUDENTS.stream()
				.map(x -> DynamicTest.dynamicTest("Test getType() for sudent = " + x, () -> {
					assertEquals(x.getType(), x.getClass().getSimpleName());
				}));
	}

	@TestFactory
	Stream<DynamicTest> testGetTotalTimeFromStream() {
		return STUDENTS.stream()
				.map(x -> DynamicTest.dynamicTest("Test getTotalTime() for sudent = " + x, () -> {
					assertEquals(x.getTotalTime(),
							x.getAnalysisTime() + x.getPracticeTime() + x.getFlowTime());
				}));
	}

	@AfterAll
	static void clearStudents() {
		STUDENTS.clear();
	}
}
