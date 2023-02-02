package org.example.service.impl;

import org.example.DAOPerson;
import org.example.Person;
import org.example.service.ConnectionDB;
import org.example.service.PersonDaoService;

import java.util.List;

public final class PersonDaoServiceImpl implements PersonDaoService {
    @Override
    public Person readById(final int id) {
        DAOPerson daoPerson = new DAOPerson();
        daoPerson.setConnection(ConnectionDB.initConnection());
        Person person = daoPerson.readById(id);
        ConnectionDB.closeConnection(daoPerson);
        return person;
    }

    @Override
    public List<Person> readAll() {
        DAOPerson daoPerson = new DAOPerson();
        daoPerson.setConnection(ConnectionDB.initConnection());
        List<Person> people = daoPerson.readAll();
        ConnectionDB.closeConnection(daoPerson);
        return people;
    }
}
