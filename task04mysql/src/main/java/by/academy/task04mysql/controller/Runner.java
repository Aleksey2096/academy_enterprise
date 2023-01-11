package by.academy.task04mysql.controller;

import static by.academy.task04mysql.entity.Constant.MAX_AGE;
import static by.academy.task04mysql.entity.Constant.MIN_AGE;
import static by.academy.task04mysql.entity.Constant.PEOPLE_QUANTITY;
import static by.academy.task04mysql.entity.Constant.PEOPLE_RESOURCE_FILE;
import static by.academy.task04mysql.entity.Constant.UNDER_AGE_VALUE;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

import by.academy.task04mysql.entity.Person;
import by.academy.task04mysql.exception.ServiceException;
import by.academy.task04mysql.service.CollectionPrinter;
import by.academy.task04mysql.service.PersonCollectionDaoService;
import by.academy.task04mysql.service.PersonCollectionUtilService;
import by.academy.task04mysql.service.ServiceFactory;

public final class Runner {

	public static void main(final String[] args) {
		try {
			final Collection<Person> people = ServiceFactory.getInstance()
					.getPersonCollectionCreator().create(PEOPLE_QUANTITY, MIN_AGE, MAX_AGE);
			final PersonCollectionUtilService utilService = ServiceFactory.getInstance()
					.getPersonCollectionUtilService();
			final Collection<Person> peopleYoungerThan21 = utilService.selectPeopleUnderAge(people,
					UNDER_AGE_VALUE);
			final CollectionPrinter printer = ServiceFactory.getInstance().getCollectionPrinter();
			printer.printCollection(peopleYoungerThan21);
			final Comparator<Person> fullNamePersonComparator = Comparator
					.comparing(Person::getSurname).thenComparing(Person::getName);
			final Collection<Person> sortedPeople = utilService.sortPeople(peopleYoungerThan21,
					fullNamePersonComparator);
			final Collection<Person> distinctPeople = utilService
					.selectDistinctPeople(sortedPeople);
			final PersonCollectionDaoService daoService = ServiceFactory.getInstance()
					.getPersonCollectionDaoService();
			daoService.savePersonCollection(distinctPeople, PEOPLE_RESOURCE_FILE);
			final Collection<Person> deserializedPeople = daoService
					.readPersonCollection(PEOPLE_RESOURCE_FILE);
			final List<String> fullNamePeopleCollection = utilService
					.convertIntoSurnameNameList(deserializedPeople);
			printer.printCollection(fullNamePeopleCollection);
		} catch (final ServiceException e) {
			e.printStackTrace();
		}
	}
}