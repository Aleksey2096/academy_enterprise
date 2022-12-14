package by.academy.task02reflection.task2_4.controller;

import java.lang.reflect.Method;

import by.academy.task02reflection.task2_4.entity.AcademyInfo;
import by.academy.task02reflection.task2_4.entity.Model;

public class Runner {
	public static void main(String[] args) {
		Class<?> modelClass = Model.class;
		try {
			Method annotationMethod = modelClass.getMethod("annotationMethod");
			System.out.println("Is annotation present in \"annotationMethod\"?: "
					+ annotationMethod.isAnnotationPresent(AcademyInfo.class)
					+ ", \"year\" value = "
					+ annotationMethod.getAnnotation(AcademyInfo.class).year());
			Method simpleMethod = modelClass.getMethod("simpleMethod");
			System.out.println("Is annotation present in \"simpleMethod\"?: "
					+ simpleMethod.isAnnotationPresent(AcademyInfo.class));
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
	}
}
