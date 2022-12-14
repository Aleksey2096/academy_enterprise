package by.academy.task02reflection.task2_4.entity;

public class Model {
	@AcademyInfo(year = "1960")
	public static void annotationMethod() {
		System.out.println("Annotation method!");
	}

	public static void simpleMethod() {
		System.out.println("Simple method!");
	}
}
