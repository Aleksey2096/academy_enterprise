package by.academy.task04mysql.service;

import java.util.Collection;

public final class CollectionPrinter {
	public <T> void printCollection(final Collection<T> collection) {
		collection.forEach(System.out::println);
	}
}
