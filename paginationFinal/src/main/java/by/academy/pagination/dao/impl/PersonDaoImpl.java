package by.academy.pagination.dao.impl;

import by.academy.pagination.dao.AbstractDAO;
import by.academy.pagination.dao.PersonDAO;
import by.academy.pagination.entity.Person;

public final class PersonDaoImpl extends AbstractDAO<Person, Integer> implements
        PersonDAO {
    /**
     * sets Class value to use it in dao methods.
     */
    public PersonDaoImpl() {
        super(Person.class);
    }
}
