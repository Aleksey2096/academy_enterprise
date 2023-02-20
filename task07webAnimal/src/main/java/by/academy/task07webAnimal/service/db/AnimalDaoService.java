package by.academy.task07webAnimal.service.db;

import by.academy.task07webAnimal.dao.impl.AnimalDaoImpl;
import by.academy.task07webAnimal.entity.Animal;
import by.academy.task07webAnimal.entity.AnimalDTO;
import by.academy.task07webAnimal.service.mapping.impl.AnimalConverter;

public abstract class AnimalDaoService
        extends AbstractDaoService<Animal, AnimalDTO, Integer> {
    /**
     * sets dao and converter values to use it in service dao methods.
     */
    public AnimalDaoService() {
        super(new AnimalDaoImpl(), new AnimalConverter());
    }
}
