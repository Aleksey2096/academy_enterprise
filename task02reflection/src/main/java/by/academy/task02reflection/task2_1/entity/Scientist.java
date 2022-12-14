package by.academy.task02reflection.task2_1.entity;

import java.util.HashMap;
import java.util.Map;

public class Scientist {
	private final Map<RobotPart, Integer> robotPartsMap = new HashMap<>();

	public Map<RobotPart, Integer> getRobotPartsMap() {
		return robotPartsMap;
	}

	public void addRobotPart(final RobotPart robotPart) {
		if (robotPartsMap.containsKey(robotPart)) {
			robotPartsMap.put(robotPart, robotPartsMap.get(robotPart) + 1);
		} else {
			robotPartsMap.put(robotPart, 1);
		}
	}
}
