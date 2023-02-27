package by.academy.pagination.service.mapping.impl;

import by.academy.pagination.entity.Person;
import by.academy.pagination.entity.PersonDTO;
import by.academy.pagination.service.mapping.Converter;

public final class PersonConverter implements Converter<Person, PersonDTO> {

    @Override
    public PersonDTO convertToDto(final Person entity) {
        return PersonDTO.builder().id(entity.getId()).name(entity.getName())
                .surname(entity.getSurname()).build();
    }

    @Override
    public Person convertToEntity(final PersonDTO dto) {
        return Person.builder().id(dto.getId()).name(dto.getName())
                .surname(dto.getSurname()).build();
    }
}
