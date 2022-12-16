package by.academy.task02reflection.task2_1.controller;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import by.academy.task02reflection.task2_1.entity.Competition;
import by.academy.task02reflection.task2_1.entity.Scientist;

public class Runner {
	public static void main(String[] args) {
		try {
			Competition competition = new Competition(new Scientist("Bob"), new Scientist("Jack"));
			ExecutorService executor = Executors.newSingleThreadExecutor();
			Future<String> result = executor.submit(competition);
			executor.shutdown();
			System.out.println(result.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}

	}
}
