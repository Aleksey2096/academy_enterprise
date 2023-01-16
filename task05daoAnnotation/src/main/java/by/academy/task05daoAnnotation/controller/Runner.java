package by.academy.task05daoAnnotation.controller;

import static by.academy.task05daoAnnotation.entity.Constant.DELETE_MESSAGE_1;
import static by.academy.task05daoAnnotation.entity.Constant.DELETE_MESSAGE_2;
import static by.academy.task05daoAnnotation.entity.Constant.INSERT_MESSAGE;
import static by.academy.task05daoAnnotation.entity.Constant.SELECT_MESSAGE;
import static by.academy.task05daoAnnotation.entity.Constant.TEST_NAME;
import static by.academy.task05daoAnnotation.entity.Constant.TEST_NAME_UPDATED;
import static by.academy.task05daoAnnotation.entity.Constant.TEST_SURNAME;
import static by.academy.task05daoAnnotation.entity.Constant.TEST_SURNAME_UPDATED;
import static by.academy.task05daoAnnotation.entity.Constant.UPDATE_MESSAGE;

import by.academy.task05daoAnnotation.entity.Person;
import by.academy.task05daoAnnotation.service.DaoService;
import by.academy.task05daoAnnotation.service.ServiceException;

public final class Runner {
	public static void main(final String[] args) {

		try {
			DaoService daoService = new DaoService();

			// INSERT

			Person person = new Person();
			person.setName(TEST_NAME);
			person.setSurname(TEST_SURNAME);
			System.out.println(INSERT_MESSAGE + daoService.create(person));

			// SELECT

			System.out.println(SELECT_MESSAGE + daoService.read(Person.class, person.getId()));

			// UPDATE

			person.setName(TEST_NAME_UPDATED);
			person.setSurname(TEST_SURNAME_UPDATED);
			daoService.update(person);
			System.out.println(UPDATE_MESSAGE + daoService.read(Person.class, person.getId()));

			// DELETE

			System.out.println(DELETE_MESSAGE_1 + daoService.delete(Person.class, person.getId()));
			System.out.println(DELETE_MESSAGE_2 + daoService.read(Person.class, person.getId()));
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
}
