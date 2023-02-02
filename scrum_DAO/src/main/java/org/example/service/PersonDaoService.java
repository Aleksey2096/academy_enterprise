package org.example.service;

import org.example.Person;

import java.util.List;

public interface PersonDaoService extends DaoService {
    Person readById(final int id);

    public List<Person> readAll();
}
