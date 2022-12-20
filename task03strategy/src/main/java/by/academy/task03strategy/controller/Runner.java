package by.academy.task03strategy.controller;

import by.academy.task03strategy.service.ClassManager;

public class Runner {
	public static void main(String[] args) {
		ClassManager classManager = new ClassManager(3, 3, 3);
		classManager.setClassForSubject(66, "Java Core");
		classManager.printClassInfo();
	}
}
