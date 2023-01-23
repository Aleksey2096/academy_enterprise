package by.academy.task06dao.service;

import by.academy.task06dao.entity.Person;

import java.util.List;

public interface PersonDaoService extends DaoService {
    /**
     * @param name person field value.
     * @return people from database with concrete name.
     * @throws ServiceException if SQLException or DaoException occurred.
     */
    List<Person> readByName(String name) throws ServiceException;

    /**
     * @param surname person field value.
     * @return people from database with concrete surname.
     * @throws ServiceException if SQLException or DaoException occurred.
     */
    List<Person> readBySurname(String surname) throws ServiceException;
}
