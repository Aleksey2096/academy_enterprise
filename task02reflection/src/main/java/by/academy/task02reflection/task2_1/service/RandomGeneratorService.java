package by.academy.task02reflection.task2_1.service;

import java.util.Random;

import by.academy.task02reflection.task2_1.entity.RobotPart;

public class RandomGeneratorService {
	private static final Random RANDOM = new Random();
	private static final RobotPart[] ROBOT_PARTS_ARRAY = RobotPart.values();
	private static final int MIN_RANDOM_ROBOT_PARTS_NUMBER = 1;
	private static final int MAX_RANDOM_ROBOT_PARTS_NUMBER = 4;

	public static RobotPart getRandomRobotPart() {
		return ROBOT_PARTS_ARRAY[RANDOM.nextInt(ROBOT_PARTS_ARRAY.length)];
	}

	public static int getRandomRobotPartsNumber() {
		return RANDOM.nextInt(MAX_RANDOM_ROBOT_PARTS_NUMBER - MIN_RANDOM_ROBOT_PARTS_NUMBER)
				+ MIN_RANDOM_ROBOT_PARTS_NUMBER;
	}
}
