package by.academy.task02reflection.task2_1.entity;

import java.util.ArrayList;
import java.util.List;

import by.academy.task02reflection.task2_1.service.RandomGeneratorService;

public class Dump {
	private static final int INITIAL_ROBOT_PARTS_NUMBER = 20;
	private static final List<RobotPart> dumpedRobotParts = new ArrayList<>();
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
		RobotPart lastRobotPart = dumpedRobotParts.get(getDumpedRobotPartsNumber() - 1);
		dumpedRobotParts.remove(getDumpedRobotPartsNumber() - 1);
		return lastRobotPart;
	}

	public static int getDumpedRobotPartsNumber() {
		return dumpedRobotParts.size();
	}
}
