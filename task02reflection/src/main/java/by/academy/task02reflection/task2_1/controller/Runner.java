package by.academy.task02reflection.task2_1.controller;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import by.academy.task02reflection.task2_1.entity.Dump;
import by.academy.task02reflection.task2_1.entity.Scientist;
import by.academy.task02reflection.task2_1.service.ScientistService;

public class Runner {

	public static final int NIGHTS_NUMBER = 100;

	public static void main(String[] args) {

		Scientist scientist1 = new Scientist();
		Scientist scientist2 = new Scientist();

		List<Scientist> scientistList = Arrays.asList(scientist1, scientist2);

		for (int i = 0; i < NIGHTS_NUMBER; ++i) {
			Dump.dumpRobotParts();
			Collections.shuffle(scientistList);
			scientistList.forEach(x -> ScientistService.receiveDumpedRobotParts(x));
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		ScientistService.printWinner(scientist1, scientist2);
	}
}
