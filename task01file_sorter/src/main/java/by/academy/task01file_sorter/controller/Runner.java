package by.academy.task01file_sorter.controller;

import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

import by.academy.task01file_sorter.service.ArrayComparator;
import by.academy.task01file_sorter.service.MatrixService;
import by.academy.task01file_sorter.service.ServiceException;

public class Runner {
	private static final URL INPUT_URL = Runner.class.getClassLoader().getResource("data/in.txt");
	private static final URL OUTPUT_URL = Runner.class.getClassLoader().getResource("data/out.txt");

	public static void main(String[] args) {
		try {
			MatrixService matrixService = new MatrixService();

			List<String[]> matrix = matrixService.readMatrix(INPUT_URL);

			List<String[]> sortedMatrix = matrix.stream().sorted(new ArrayComparator())
					.collect(Collectors.toList());

			matrixService.writeMatrix(OUTPUT_URL, sortedMatrix);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
}
