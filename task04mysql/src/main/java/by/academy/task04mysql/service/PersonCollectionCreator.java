package by.academy.task04mysql.service;

import static by.academy.task04mysql.entity.Constant.NAMES_ARRAY;
import static by.academy.task04mysql.entity.Constant.RANDOM;
import static by.academy.task04mysql.entity.Constant.SURNAMES_ARRAY;

import java.util.ArrayList;
import java.util.Collection;

import by.academy.task04mysql.entity.Person;

public final class PersonCollectionCreator {
	public Collection<Person> create(final int quantity, final int minAge, final int maxAge) {
		final Collection<Person> people = new ArrayList<>();
		for (int i = 0; i < quantity; ++i) {
			people.add(new Person(NAMES_ARRAY[RANDOM.nextInt(NAMES_ARRAY.length)].toString(),
					SURNAMES_ARRAY[RANDOM.nextInt(SURNAMES_ARRAY.length)].toString(),
					RANDOM.nextInt(maxAge - minAge) + minAge));
		}
		return people;
	}
}
