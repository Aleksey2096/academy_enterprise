package by.academy.task04sql.controller;

import static by.academy.task04sql.entity.Constant.MAX_AGE;
import static by.academy.task04sql.entity.Constant.MIN_AGE;
import static by.academy.task04sql.entity.Constant.PEOPLE_QUANTITY;
import static by.academy.task04sql.entity.Constant.PEOPLE_RESOURCE_FILE;
import static by.academy.task04sql.entity.Constant.UNDER_AGE_VALUE;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

import by.academy.task04sql.entity.Person;
import by.academy.task04sql.exception.ServiceException;
import by.academy.task04sql.service.CollectionPrinter;
import by.academy.task04sql.service.PersonCollectionDaoService;
import by.academy.task04sql.service.PersonCollectionUtilService;
import by.academy.task04sql.service.ServiceFactory;

public final class Runner {

	public static void main(final String[] args) {
		try {
			final Collection<Person> people = ServiceFactory.getInstance()
					.getPersonCollectionCreator().create(PEOPLE_QUANTITY, MIN_AGE, MAX_AGE);
			final PersonCollectionUtilService utilService = ServiceFactory.getInstance()
					.getPersonCollectionUtilService();
			final Collection<Person> peopleYongerThan21 = utilService.selectPeopleUnderAge(people,
					UNDER_AGE_VALUE);
			final CollectionPrinter printer = ServiceFactory.getInstance().getCollectionPrinter();
			printer.printCollection(peopleYongerThan21);
			final Comparator<Person> fullNamePersonComparator = Comparator
					.comparing(Person::getSurname).thenComparing(Person::getName);
			final Collection<Person> sortedPeople = utilService.sortPeople(peopleYongerThan21,
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
