package by.academy.task06dao.controller;

import by.academy.task06dao.entity.Person;
import by.academy.task06dao.service.DaoService;
import by.academy.task06dao.service.PersonDaoService;
import by.academy.task06dao.service.ServiceException;
import by.academy.task06dao.service.impl.PersonDaoServiceImpl;

import static by.academy.task06dao.entity.Constant.DELETE_MESSAGE_1;
import static by.academy.task06dao.entity.Constant.DELETE_MESSAGE_2;
import static by.academy.task06dao.entity.Constant.INSERT_MESSAGE;
import static by.academy.task06dao.entity.Constant.SELECT_MESSAGE;
import static by.academy.task06dao.entity.Constant.TEST_FIND_NAME;
import static by.academy.task06dao.entity.Constant.TEST_FIND_SURNAME;
import static by.academy.task06dao.entity.Constant.TEST_NAME;
import static by.academy.task06dao.entity.Constant.TEST_NAME_UPDATED;
import static by.academy.task06dao.entity.Constant.TEST_SURNAME;
import static by.academy.task06dao.entity.Constant.TEST_SURNAME_UPDATED;
import static by.academy.task06dao.entity.Constant.UPDATE_MESSAGE;

public final class Runner {
    private Runner() {
    }

    /**
     * Checks if everything works.
     *
     * @param args default arguments
     */
    public static void main(final String[] args) {

        try {
            DaoService daoService = new PersonDaoServiceImpl();
            Person person = new Person();
            person.setName(TEST_NAME);
            person.setSurname(TEST_SURNAME);
            System.out.println(person);

            // INSERT

            System.out.println(INSERT_MESSAGE + daoService.create(person));

            // SELECT

            System.out.println(SELECT_MESSAGE + daoService.read(Person.class,
                    person.getId()));

            // UPDATE

            person.setName(TEST_NAME_UPDATED);
            person.setSurname(TEST_SURNAME_UPDATED);
            daoService.update(person);
            System.out.println(UPDATE_MESSAGE + daoService.read(Person.class,
                    person.getId()));

            // DELETE

            System.out.println(
                    DELETE_MESSAGE_1 + daoService.delete(Person.class,
                            person.getId()));
            System.out.println(DELETE_MESSAGE_2 + daoService.read(Person.class,
                    person.getId()));

            // SELECT BY

            PersonDaoService personDaoService = new PersonDaoServiceImpl();
            System.out.println(personDaoService.readByName(TEST_FIND_NAME));
            System.out.println(
                    personDaoService.readBySurname(TEST_FIND_SURNAME));
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }
}
