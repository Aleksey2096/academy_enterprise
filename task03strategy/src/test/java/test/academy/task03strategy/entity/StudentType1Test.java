package test.academy.task03strategy.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import by.academy.task03strategy.entity.AbstractStudent;
import by.academy.task03strategy.entity.impl.StudentType1;

public class StudentType1Test {
	public final static int TESTS_NUM = 100;
	public final static Random RANDOM = new Random();
	private final static List<AbstractStudent> STUDENTS = new ArrayList<>();

	@BeforeAll
	static void addStudents() {
		for (int i = 0; i < TESTS_NUM; ++i) {
			AbstractStudent student = new StudentType1();
			student.setBaseTimeForAnalysis(RANDOM.nextInt(1000) + 1);
			STUDENTS.add(student);
		}
	}

	@TestFactory
	Stream<DynamicTest> testGetAnalysisTimeFromStream() {
		return STUDENTS.stream()
				.map(x -> DynamicTest.dynamicTest("Test analysis time for sudent = " + x, () -> {
					assertEquals(x.getAnalysisTime(), x.getBaseTimeForAnalysis() / x.getTalent());
				}));
	}

	@TestFactory
	Stream<DynamicTest> testGetPracticeTimeFromStream() {
		return STUDENTS.stream()
				.map(x -> DynamicTest.dynamicTest("Test practice time for sudent = " + x, () -> {
					assertEquals(x.getPracticeTime(), x.getBaseTimeForAnalysis() / x.getTalent());
				}));
	}

	@TestFactory
	Stream<DynamicTest> testGetFlowTimeFromStream() {
		return STUDENTS.stream()
				.map(x -> DynamicTest.dynamicTest("Test flow time for sudent = " + x, () -> {
					assertEquals(x.getFlowTime(), x.getBaseTimeForAnalysis() / x.getTalent());
				}));
	}

	@AfterAll
	static void clearStudents() {
		STUDENTS.clear();
	}
}
