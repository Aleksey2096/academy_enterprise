package by.academy.dao;

import java.util.List;

public interface DAO<T> {
    T create(T object);
    List<T> read();
    T update(T object);
    void delete(int id);
    T selectById(int id);
}
