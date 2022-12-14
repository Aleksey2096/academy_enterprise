package by.academy.task02reflection.task2_1.service;

import java.util.Map;

import by.academy.task02reflection.task2_1.entity.Dump;
import by.academy.task02reflection.task2_1.entity.RobotPart;
import by.academy.task02reflection.task2_1.entity.Scientist;

public class ScientistService {
	public static void receiveDumpedRobotParts(final Scientist scientist) {
		for (int i = 0; i < RandomGeneratorService.getRandomRobotPartsNumber(); ++i) {
			if (Dump.getDumpedRobotPartsNumber() > 0) {
				scientist.addRobotPart(Dump.giveAwayRobotPart());
			} else {
				break;
			}
		}
	}

	public static void printWinner(final Scientist s1, final Scientist s2) {
		int fullRobotsNum1 = countFullRobots(s1.getRobotPartsMap());
		int fullRobotsNum2 = countFullRobots(s2.getRobotPartsMap());
		if (fullRobotsNum1 > fullRobotsNum2) {
			System.out.println("First scientist won with " + fullRobotsNum1
					+ " full robots (second scientist has " + fullRobotsNum2 + " full robots).");
		} else if (fullRobotsNum1 < fullRobotsNum2) {
			System.out.println("Second scientist won with " + fullRobotsNum2
					+ " full robots (first scientist has " + fullRobotsNum1 + " full robots).");
		} else {
			System.out.println("They both have " + fullRobotsNum1 + " full robots each.");
		}
	}

	private static int countFullRobots(final Map<RobotPart, Integer> robotPartsMap) {
		return robotPartsMap.values().stream().mapToInt(x -> x).min().orElse(0);
	}
}
