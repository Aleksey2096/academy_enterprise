package by.academy.task07webAnimal.service.db.impl;

import by.academy.task07webAnimal.entity.Animal;
import by.academy.task07webAnimal.entity.AnimalDTO;
import by.academy.task07webAnimal.service.db.AnimalDaoService;
import by.academy.task07webAnimal.service.mapping.Converter;
import by.academy.task07webAnimal.service.mapping.impl.AnimalConverter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

import static by.academy.task07webAnimal.service.db.impl.MockUtil.clearAnimalTable;
import static by.academy.task07webAnimal.service.db.impl.MockUtil.createTestAnimal;
import static by.academy.task07webAnimal.service.db.impl.MockUtil.getConnection;
import static by.academy.task07webAnimal.service.db.impl.MockUtil.insertAnimal;
import static by.academy.task07webAnimal.service.db.impl.MockUtil.selectById;
import static by.academy.task07webAnimal.service.db.impl.TestConstant.EQUALS_ALL_FIELDS;
import static by.academy.task07webAnimal.service.db.impl.TestConstant.UPDATED_STRING;
import static by.academy.task07webAnimal.service.db.impl.TestConstant.UPDATED_WEIGHT;
import static by.academy.task07webAnimal.service.db.impl.TestConstant.ZERO_INDEX;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class AnimalDaoServiceImplTest {
    private static final AnimalDaoService ANIMAL_DAO_SERVICE
            = new AnimalDaoServiceImpl();
    private static final Converter<AnimalDTO, Animal> CONVERTER
            = new AnimalConverter();

    @Test
    public void testCreate() throws SQLException {
        Animal animal = createTestAnimal();
        AnimalDTO animalDTO = CONVERTER.convertToDTO(animal);
        AnimalDTO createdAnimalDTO = ANIMAL_DAO_SERVICE.create(animalDTO);
        Animal expectedAnimal = CONVERTER.convertToEntity(createdAnimalDTO);
        Animal actualAnimal = selectById(expectedAnimal.getId(),
                getConnection());
        assertAll(EQUALS_ALL_FIELDS,
                () -> assertEquals(expectedAnimal.getId(),
                        actualAnimal.getId()),
                () -> assertEquals(expectedAnimal.getName(),
                        actualAnimal.getName()),
                () -> assertEquals(expectedAnimal.getWeight(),
                        actualAnimal.getWeight())
        );
    }

    @Test
    public void testReadById() throws SQLException {
        Animal actualAnimal = createTestAnimal();
        insertAnimal(actualAnimal, getConnection());
        AnimalDTO animalDTO = ANIMAL_DAO_SERVICE.readById(actualAnimal.getId());
        Animal expectedAnimal = CONVERTER.convertToEntity(animalDTO);
        assertAll(EQUALS_ALL_FIELDS,
                () -> assertEquals(expectedAnimal.getId(),
                        actualAnimal.getId()),
                () -> assertEquals(expectedAnimal.getName(),
                        actualAnimal.getName()),
                () -> assertEquals(expectedAnimal.getWeight(),
                        actualAnimal.getWeight())
        );
    }

    @Test
    public void testUpdate() throws SQLException {
        Animal expectedAnimal = createTestAnimal();
        insertAnimal(expectedAnimal, getConnection());
        expectedAnimal.setName(expectedAnimal.getName() + UPDATED_STRING);
        expectedAnimal.setWeight(UPDATED_WEIGHT);
        AnimalDTO animalDTO = CONVERTER.convertToDTO(expectedAnimal);
        ANIMAL_DAO_SERVICE.update(animalDTO);
        Animal actualAnimal = selectById(expectedAnimal.getId(),
                getConnection());
        assertAll(EQUALS_ALL_FIELDS,
                () -> assertEquals(expectedAnimal.getId(),
                        actualAnimal.getId()),
                () -> assertEquals(expectedAnimal.getName(),
                        actualAnimal.getName()),
                () -> assertEquals(expectedAnimal.getWeight(),
                        actualAnimal.getWeight())
        );
    }

    @Test
    public void testDelete() throws SQLException {
        Animal initialAnimal = createTestAnimal();
        insertAnimal(initialAnimal, getConnection());
        AnimalDTO animalDTO = CONVERTER.convertToDTO(initialAnimal);
        ANIMAL_DAO_SERVICE.delete(animalDTO);
        Animal deletedAnimal = selectById(initialAnimal.getId(),
                getConnection());
        assertAll(EQUALS_ALL_FIELDS,
                () -> assertNotNull(initialAnimal.getId()),
                () -> assertNotNull(initialAnimal.getName()),
                () -> assertNotNull(initialAnimal.getWeight()),
                () -> assertNull(deletedAnimal)
        );
    }

    @Test
    public void testDeleteById() throws SQLException {
        Animal initialAnimal = createTestAnimal();
        insertAnimal(initialAnimal, getConnection());
        ANIMAL_DAO_SERVICE.deleteById(initialAnimal.getId());
        Animal deletedAnimal = selectById(initialAnimal.getId(),
                getConnection());
        assertAll(EQUALS_ALL_FIELDS,
                () -> assertNotNull(initialAnimal.getId()),
                () -> assertNotNull(initialAnimal.getName()),
                () -> assertNotNull(initialAnimal.getWeight()),
                () -> assertNull(deletedAnimal)
        );
    }

    @Test
    public void testReadAll() throws SQLException {
        List<Animal> actualAnimals = List.of(createTestAnimal());
        for (Animal animal : actualAnimals) {
            insertAnimal(animal, getConnection());
        }
        List<Animal> expectedAnimals = ANIMAL_DAO_SERVICE.readAll().stream()
                .map(CONVERTER::convertToEntity).toList();
        assertAll(EQUALS_ALL_FIELDS,
                () -> assertEquals(expectedAnimals.get(ZERO_INDEX).getId(),
                        actualAnimals.get(ZERO_INDEX).getId()),
                () -> assertEquals(expectedAnimals.get(ZERO_INDEX).getName(),
                        actualAnimals.get(ZERO_INDEX).getName()),
                () -> assertEquals(expectedAnimals.get(ZERO_INDEX).getWeight(),
                        actualAnimals.get(ZERO_INDEX).getWeight())
        );
    }

    @AfterEach
    public void clearTable() throws SQLException {
        clearAnimalTable(Objects.requireNonNull(getConnection()));
    }
}
