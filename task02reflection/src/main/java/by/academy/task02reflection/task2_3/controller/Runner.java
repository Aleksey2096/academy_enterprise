package by.academy.task02reflection.task2_3.controller;

import java.lang.reflect.InvocationTargetException;

import by.academy.task02reflection.task2_3.service.PrintService;

public class Runner {
	public static void main(String[] args) {
		PrintService printService = new PrintService();
		Class<?> printServiceClass = printService.getClass();
		try {
			printServiceClass.getDeclaredMethods()[0].invoke(printService);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| SecurityException e) {
			e.printStackTrace();
		}
	}
}
