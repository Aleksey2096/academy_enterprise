package org.example.service;

import org.example.DAO;
import org.example.DAOPerson;
import org.example.Person;

public interface DaoService {
    default void create(Object entity) {
        DAO<Person> dao = new DAOPerson();
        dao.setConnection(ConnectionDB.initConnection());
        dao.insert((Person) entity);
        ConnectionDB.closeConnection(dao);
    }

    default void read(Object entity) {
        DAO<Person> dao = new DAOPerson();
        dao.setConnection(ConnectionDB.initConnection());
        dao.select((Person) entity);
        ConnectionDB.closeConnection(dao);
    }

    default void update(Object entity) {
        DAO<Person> dao = new DAOPerson();
        dao.setConnection(ConnectionDB.initConnection());
        dao.update((Person) entity);
        ConnectionDB.closeConnection(dao);
    }

    default void delete(Object entity) {
        DAO<Person> dao = new DAOPerson();
        dao.setConnection(ConnectionDB.initConnection());
        dao.delete((Person) entity);
        ConnectionDB.closeConnection(dao);
    }
}
