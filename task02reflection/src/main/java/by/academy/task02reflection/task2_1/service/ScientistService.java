package by.academy.task02reflection.task2_1.service;

import java.util.Map;

import by.academy.task02reflection.task2_1.entity.RobotPart;
import by.academy.task02reflection.task2_1.entity.Scientist;

public class ScientistService {

	public static String countWinner(final Scientist s1, final Scientist s2) {
		int fullRobotsNum1 = countFullRobots(s1.getRobotPartsMap());
		int fullRobotsNum2 = countFullRobots(s2.getRobotPartsMap());
		if (fullRobotsNum1 > fullRobotsNum2) {
			return "Scientist " + s1.getName() + " won with " + fullRobotsNum1
					+ " full robots (scientist " + s2.getName() + " has " + fullRobotsNum2
					+ " full robots).";
		} else if (fullRobotsNum1 < fullRobotsNum2) {
			return "Scientist " + s2.getName() + " won with " + fullRobotsNum2
					+ " full robots (scientist " + s1.getName() + " has " + fullRobotsNum1
					+ " full robots).";
		} else {
			return "They both have " + fullRobotsNum1 + " full robots each.";
		}
	}

	private static int countFullRobots(final Map<RobotPart, Integer> robotPartsMap) {
		return robotPartsMap.values().stream().mapToInt(x -> x).min().orElse(0);
	}
}
