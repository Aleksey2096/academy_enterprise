package by.academy.task02reflection.task2_2.controller;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import by.academy.task02reflection.task2_2.service.ReflectionService;

public class Controller {
	public static void main(String[] args) {
		Class<?> reflectionServiceClass = ReflectionService.class;
		Method[] methods = reflectionServiceClass.getDeclaredMethods();
		try {
			methods[0].invoke(null);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}
}
