package by.academy.task02reflection.task2_1.entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Scientist {
	private final Map<RobotPart, Integer> robotPartsMap = new HashMap<>();
	private String name;

	public Scientist(String name) {
		this.name = name;
	}

	public Map<RobotPart, Integer> getRobotPartsMap() {
		return robotPartsMap;
	}

	public String getName() {
		return name;
	}

	public void addRobotParts(final List<RobotPart> robotParts) {
		for (RobotPart robotPart : robotParts) {
			if (robotPartsMap.containsKey(robotPart)) {
				robotPartsMap.put(robotPart, robotPartsMap.get(robotPart) + 1);
			} else {
				robotPartsMap.put(robotPart, 1);
			}
		}
	}
}
