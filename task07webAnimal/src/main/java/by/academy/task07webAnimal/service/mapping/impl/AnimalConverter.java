package by.academy.task07webAnimal.service.mapping.impl;

import by.academy.task07webAnimal.entity.Animal;
import by.academy.task07webAnimal.entity.AnimalDTO;
import by.academy.task07webAnimal.service.mapping.Converter;

public final class AnimalConverter extends Converter<AnimalDTO, Animal> {
    /**
     * passes Function objects, which converting between dto and entity.
     */
    public AnimalConverter() {
        super(dto -> Animal.builder().id(dto.getId()).name(dto.getName())
                        .weight(dto.getWeight()).build(),
                entity -> AnimalDTO.builder().id(entity.getId())
                        .name(entity.getName()).weight(entity.getWeight())
                        .build());
    }
}
