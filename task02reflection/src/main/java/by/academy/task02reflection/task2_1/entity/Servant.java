package by.academy.task02reflection.task2_1.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class Servant implements Callable<List<RobotPart>> {
	private int robotPartsNumber;

	public Servant(int robotPartsNumber) {
		this.robotPartsNumber = robotPartsNumber;
	}

	@Override
	public List<RobotPart> call() throws EntityException {
		List<RobotPart> robotParts = new ArrayList<>();
		for (int i = 0; i < robotPartsNumber; ++i) {
			try {
				TimeUnit.NANOSECONDS.sleep(10);
			} catch (InterruptedException e) {
				throw new EntityException(e);
			}
			RobotPart robotPart = Dump.giveAwayRobotPart();
			if (robotPart != null) {
				robotParts.add(robotPart);
			}
		}
		return robotParts;
	}
}
