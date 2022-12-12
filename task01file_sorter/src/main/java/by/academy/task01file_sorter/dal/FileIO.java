package by.academy.task01file_sorter.dal;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.util.List;

public final class FileIO {
	public List<String> readFile(final URL inputURL) throws DalException {
		try {
			return new BufferedReader(new InputStreamReader(inputURL.openStream())).lines()
					.toList();
		} catch (IOException e) {
			throw new DalException(e);
		}
	}

	public void writeFile(final URL outputURL, final String outputString) throws DalException {
		try (PrintWriter writer = new PrintWriter(outputURL.getPath());) {
			writer.write(outputString);
		} catch (FileNotFoundException e) {
			throw new DalException(e);
		}
	}
}
