package by.academy.task02reflection.task2_1.entity;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import by.academy.task02reflection.task2_1.service.RandomGeneratorService;

public class Dump {
	private static final int INITIAL_ROBOT_PARTS_NUMBER = 20;
	private static final int MAX_DUMPED_ROBOT_PARTS_NUMBER = 220;
	private static final BlockingQueue<RobotPart> dumpedRobotParts = new ArrayBlockingQueue<>(
			MAX_DUMPED_ROBOT_PARTS_NUMBER);

	static {
		for (int i = 0; i < INITIAL_ROBOT_PARTS_NUMBER; ++i) {
			dumpedRobotParts.add(RandomGeneratorService.getRandomRobotPart());
		}
	}

	public static void dumpRobotParts() {
		for (int i = 0; i < RandomGeneratorService.getRandomRobotPartsNumber(); ++i) {
			dumpedRobotParts.add(RandomGeneratorService.getRandomRobotPart());
		}
	}

	public static RobotPart giveAwayRobotPart() {
		return dumpedRobotParts.poll();
	}
}
