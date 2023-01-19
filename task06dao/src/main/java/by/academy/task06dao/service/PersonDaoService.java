package by.academy.task06dao.service;

import java.util.List;

import by.academy.task06dao.entity.Person;

public interface PersonDaoService extends DaoService<Person> {
	List<Person> readByName(String name) throws ServiceException;

	List<Person> readBySurname(String surname) throws ServiceException;
}
