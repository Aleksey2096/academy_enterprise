package by.academy.task01file_sorter.service;

import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

import by.academy.task01file_sorter.dal.DalException;
import by.academy.task01file_sorter.dal.FileIO;

public final class MatrixService {
	private final FileIO fileIO = new FileIO();

	public List<String[]> readMatrix(final URL inputURL) throws ServiceException {
		try {
			List<String> strings = fileIO.readFile(inputURL);
			return strings.stream().map(x -> x.split("\t")).collect(Collectors.toList());
		} catch (DalException e) {
			throw new ServiceException(e);
		}
	}

	public void writeMatrix(final URL outputURL, final List<String[]> matrix)
			throws ServiceException {
		try {
			String resultString = matrix.stream().map(x -> String.join("\t", x))
					.collect(Collectors.joining("\n"));
			fileIO.writeFile(outputURL, resultString);
		} catch (DalException e) {
			throw new ServiceException(e);
		}
	}
}
