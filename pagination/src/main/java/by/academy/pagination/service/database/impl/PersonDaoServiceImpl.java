package by.academy.pagination.service.database.impl;

import by.academy.pagination.dao.impl.PersonDaoImpl;
import by.academy.pagination.entity.Person;
import by.academy.pagination.entity.PersonDTO;
import by.academy.pagination.service.database.AbstractDaoService;
import by.academy.pagination.service.database.PersonDaoService;
import by.academy.pagination.service.mapping.impl.PersonConverter;

public final class PersonDaoServiceImpl
        extends AbstractDaoService<Person, PersonDTO, Integer>
        implements PersonDaoService {
    /**
     * sets dao and converter values to use it in service dao methods.
     */
    public PersonDaoServiceImpl() {
        super(new PersonDaoImpl(), new PersonConverter());
    }
}
