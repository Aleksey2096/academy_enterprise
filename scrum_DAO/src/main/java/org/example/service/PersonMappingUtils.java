package org.example.service;

import org.example.Person;
import org.example.dto.PersonDTO;

public final class PersonMappingUtils {
    private static final PersonMappingUtils PERSON_MAPPING_UTILS
            = new PersonMappingUtils();

    private PersonMappingUtils() {
    }

    public static PersonMappingUtils getInstance() {
        return PERSON_MAPPING_UTILS;
    }

    public PersonDTO mapToPersonDTO(Person person) {
        return PersonDTO.builder().id(person.getId()).name(person.getName())
                .surname(person.getSurname()).build();
    }

    public Person mapToPerson(PersonDTO personDTO) {
        return Person.builder().id(personDTO.getId()).name(personDTO.getName())
                .surname(personDTO.getSurname()).build();
    }
}
