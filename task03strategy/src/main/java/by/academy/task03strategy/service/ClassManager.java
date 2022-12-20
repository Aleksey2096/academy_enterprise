package by.academy.task03strategy.service;

import java.util.ArrayList;
import java.util.List;

import by.academy.task03strategy.entity.AbstractStudent;
import by.academy.task03strategy.entity.impl.StudentType1;
import by.academy.task03strategy.entity.impl.StudentType2;
import by.academy.task03strategy.entity.impl.StudentType3;

public class ClassManager {
	private int numOfStudentsType1;
	private int numOfStudentsType2;
	private int numOfStudentsType3;
	private List<AbstractStudent> students = new ArrayList<>();

	public ClassManager(int numOfStudentsType1, int numOfStudentsType2, int numOfStudentsType3) {
		this.numOfStudentsType1 = numOfStudentsType1;
		this.numOfStudentsType2 = numOfStudentsType2;
		this.numOfStudentsType3 = numOfStudentsType3;
	}

	public List<AbstractStudent> getStudents() {
		return students;
	}

	public void setClassForSubject(double baseTimeForAnalysis, String subjectTitle) {
		students.clear();
		for (int i = 0; i < numOfStudentsType1; ++i) {
			students.add(new StudentType1());
		}
		for (int i = 0; i < numOfStudentsType2; ++i) {
			students.add(new StudentType2());
		}
		for (int i = 0; i < numOfStudentsType3; ++i) {
			students.add(new StudentType3());
		}
		setBaseTimeForAnalysisForClass(students, baseTimeForAnalysis);
		setSubjectTitleForClass(students, subjectTitle);
	}

	public void printClassInfo() {
		if (students.size() > 0) {
			System.out.println("Subject: " + students.get(0).getSubjectTitle());
			students.forEach(System.out::println);
		}
	}

	private void setBaseTimeForAnalysisForClass(List<AbstractStudent> students,
			double baseTimeForAnalysis) {
		students.forEach(x -> x.setBaseTimeForAnalysis(baseTimeForAnalysis));
	}

	private void setSubjectTitleForClass(List<AbstractStudent> students, String subjectTitle) {
		students.forEach(x -> x.setSubjectTitle(subjectTitle));
	}
}