package by.academy.pagination.service.database.impl;

import by.academy.pagination.entity.Person;
import by.academy.pagination.entity.PersonDTO;
import by.academy.pagination.service.database.PersonDaoService;
import by.academy.pagination.service.mapping.Converter;
import by.academy.pagination.service.mapping.impl.PersonConverter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

import static by.academy.pagination.service.database.impl.MockUtil.clearPersonTable;
import static by.academy.pagination.service.database.impl.MockUtil.createTestPerson;
import static by.academy.pagination.service.database.impl.MockUtil.getConnection;
import static by.academy.pagination.service.database.impl.MockUtil.insertPerson;
import static by.academy.pagination.service.database.impl.MockUtil.selectById;
import static by.academy.pagination.service.database.impl.TestConstant.EQUALS_ALL_FIELDS;
import static by.academy.pagination.service.database.impl.TestConstant.UPDATED_STRING;
import static by.academy.pagination.service.database.impl.TestConstant.ZERO_INDEX;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class PersonDaoServiceImplTest {
    private static final PersonDaoService PERSON_DAO_SERVICE
            = new PersonDaoServiceImpl();
    private static final Converter<Person, PersonDTO> CONVERTER
            = new PersonConverter();

    @Test
    public void testCreate() throws SQLException {
        Person person = createTestPerson();
        PersonDTO personDTO = CONVERTER.convertToDto(person);
        PersonDTO createdPersonDTO = PERSON_DAO_SERVICE.create(personDTO);
        Person expectedPerson = CONVERTER.convertToEntity(createdPersonDTO);
        Person actualPerson = selectById(expectedPerson.getId(),
                getConnection());
        assertAll(EQUALS_ALL_FIELDS,
                () -> assertEquals(expectedPerson.getId(),
                        actualPerson.getId()),
                () -> assertEquals(expectedPerson.getName(),
                        actualPerson.getName()),
                () -> assertEquals(expectedPerson.getSurname(),
                        actualPerson.getSurname())
        );
    }

    @Test
    public void testReadById() throws SQLException {
        Person actualPerson = createTestPerson();
        insertPerson(actualPerson, getConnection());
        PersonDTO personDTO = PERSON_DAO_SERVICE.readById(actualPerson.getId());
        Person expectedPerson = CONVERTER.convertToEntity(personDTO);
        assertAll(EQUALS_ALL_FIELDS,
                () -> assertEquals(expectedPerson.getId(),
                        actualPerson.getId()),
                () -> assertEquals(expectedPerson.getName(),
                        actualPerson.getName()),
                () -> assertEquals(expectedPerson.getSurname(),
                        actualPerson.getSurname())
        );
    }

    @Test
    public void testUpdate() throws SQLException {
        Person expectedPerson = createTestPerson();
        insertPerson(expectedPerson, getConnection());
        expectedPerson.setName(expectedPerson.getName() + UPDATED_STRING);
        expectedPerson.setSurname(expectedPerson.getSurname() + UPDATED_STRING);
        PersonDTO personDTO = CONVERTER.convertToDto(expectedPerson);
        PERSON_DAO_SERVICE.update(personDTO);
        Person actualPerson = selectById(expectedPerson.getId(),
                getConnection());
        assertAll(EQUALS_ALL_FIELDS,
                () -> assertEquals(expectedPerson.getId(),
                        actualPerson.getId()),
                () -> assertEquals(expectedPerson.getName(),
                        actualPerson.getName()),
                () -> assertEquals(expectedPerson.getSurname(),
                        actualPerson.getSurname())
        );
    }

    @Test
    public void testDeleteById() throws SQLException {
        Person initialPerson = createTestPerson();
        insertPerson(initialPerson, getConnection());
        PERSON_DAO_SERVICE.deleteById(initialPerson.getId());
        Person deletedPerson = selectById(initialPerson.getId(),
                getConnection());
        assertAll(EQUALS_ALL_FIELDS,
                () -> assertNotNull(initialPerson.getId()),
                () -> assertNotNull(initialPerson.getName()),
                () -> assertNotNull(initialPerson.getSurname()),
                () -> assertNull(deletedPerson)
        );
    }

    @Test
    public void testReadAll() throws SQLException {
        List<Person> actualPeople = List.of(createTestPerson());
        for (Person person : actualPeople) {
            insertPerson(person, getConnection());
        }
        List<Person> expectedPeople = PERSON_DAO_SERVICE.readAll().stream()
                .map(CONVERTER::convertToEntity).toList();
        assertAll(EQUALS_ALL_FIELDS,
                () -> assertEquals(expectedPeople.get(ZERO_INDEX).getId(),
                        actualPeople.get(ZERO_INDEX).getId()),
                () -> assertEquals(expectedPeople.get(ZERO_INDEX).getName(),
                        actualPeople.get(ZERO_INDEX).getName()),
                () -> assertEquals(expectedPeople.get(ZERO_INDEX).getSurname(),
                        actualPeople.get(ZERO_INDEX).getSurname())
        );
    }

    @AfterEach
    public void clearTable() throws SQLException {
        clearPersonTable(Objects.requireNonNull(getConnection()));
    }
}
