package by.academy.task04mysql.service;

import static by.academy.task04mysql.entity.Constant.SPACE;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import by.academy.task04mysql.entity.Person;

public final class PersonCollectionUtilService {
	public Collection<Person> selectPeopleUnderAge(final Collection<Person> people,
			final int maxAge) {
		return people.stream().filter(person -> person.getAge() < maxAge)
				.collect(Collectors.toList());
	}

	public List<Person> sortPeople(final Collection<Person> people,
			final Comparator<Person> personComparator) {
		return people.stream().sorted(personComparator).collect(Collectors.toList());
	}

	public List<Person> selectDistinctPeople(final Collection<Person> people) {
		return people.stream().distinct().collect(Collectors.toList());
	}

	public List<String> convertIntoSurnameNameList(final Collection<Person> people) {
		return people.stream().map(person -> person.getSurname() + SPACE + person.getName())
				.collect(Collectors.toList());
	}
}