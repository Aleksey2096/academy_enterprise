package by.academy.task02reflection.task2_2.service;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.GregorianCalendar;

import by.academy.task02reflection.task2_2.entity.Man;

public class ReflectionService {
	public static void printManClassInfo() {
		Man man = new Man("John", "Doe", 33,
				new GregorianCalendar(1980, Calendar.DECEMBER, 10).getTime());
		Class<?> manClass = man.getClass();
		Class<?> manSuperclass = manClass.getSuperclass();

		System.out.println("Man superclass: " + manSuperclass.getSimpleName());

		Field[] fields = manClass.getDeclaredFields();

		System.out.println("Fields declared in class Man:");
		for (Field field : fields) {
			System.out.println(
					"name = " + field.getName() + ", type = " + field.getType().getSimpleName());
		}

		Method[] methods = manClass.getDeclaredMethods();

		System.out.println("Methods declared in class Man:");
		for (Method method : methods) {
			System.out.println("name = " + method.getName() + ", return type = "
					+ method.getReturnType().getSimpleName() + ", parameter count = "
					+ method.getParameterCount());
		}

		Class<?>[] manInterfaces = manClass.getInterfaces();

		System.out.println("Inteerfaces declared in class Man:");
		for (Class<?> manInterface : manInterfaces) {
			System.out.println("name = " + manInterface.getSimpleName());
		}

		Annotation[] manAnnotations = manClass.getDeclaredAnnotations();
		System.out.println("Annotations declared in class Man:");
		for (Annotation manAnnotation : manAnnotations) {
			System.out.println("name = " + manAnnotation.toString());
		}
	}
}
