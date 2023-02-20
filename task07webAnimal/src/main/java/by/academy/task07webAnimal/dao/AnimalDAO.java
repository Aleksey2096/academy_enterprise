package by.academy.task07webAnimal.dao;

import by.academy.task07webAnimal.entity.Animal;

public abstract class AnimalDAO extends AbstractDAO<Animal, Integer> {
    /**
     * sets class value to use it in jpa methods.
     */
    public AnimalDAO() {
        super(Animal.class);
    }
}
