package by.academy.task02reflection.task2_1.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import by.academy.task02reflection.task2_1.service.RandomGeneratorService;
import by.academy.task02reflection.task2_1.service.ScientistService;

public class Competition implements Callable<String> {
	public static final int NIGHTS_NUMBER = 100;
	public static final int NIGHT_LENGTH = 100;
	private static final int NUM_OF_SCIENTISTS = 2;
	private Scientist scientist1;
	private Scientist scientist2;

	public Competition(Scientist scientist1, Scientist scientist2) {
		this.scientist1 = scientist1;
		this.scientist2 = scientist2;
	}

	@Override
	public String call() throws EntityException {
		for (int i = 0; i < NIGHTS_NUMBER; ++i) {
			try {
				Dump.dumpRobotParts();
				ExecutorService executorService = Executors.newFixedThreadPool(NUM_OF_SCIENTISTS);
				List<Servant> servants = new ArrayList<>();
				servants.add(new Servant(RandomGeneratorService.getRandomRobotPartsNumber()));
				servants.add(new Servant(RandomGeneratorService.getRandomRobotPartsNumber()));
				Collections.shuffle(servants);
				List<Future<List<RobotPart>>> roboLists = executorService.invokeAll(servants);
				executorService.shutdown();
				scientist1.addRobotParts(roboLists.get(0).get());
				scientist2.addRobotParts(roboLists.get(1).get());
				TimeUnit.MILLISECONDS.sleep(NIGHT_LENGTH);
			} catch (InterruptedException | ExecutionException e) {
				throw new EntityException(e);
			}
		}
		return ScientistService.countWinner(scientist1, scientist2);
	}
}
