package org.example.boot.util;

import org.example.boot.model.Person;
import org.example.boot.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class PersonValidator implements Validator {

	private final PeopleService peopleService;

	@Autowired
	public PersonValidator(final PeopleService peopleService) {
		this.peopleService = peopleService;
	}

	@Override
	public boolean supports(final Class<?> aClass) {
		return Person.class.equals(aClass);
	}

	@Override
	public void validate(final Object o, final Errors errors) {
		Person person = (Person) o;

		if (peopleService.getPersonByFullName(person.getFullName()).isPresent())
			errors.rejectValue("fullName", "", "Человек с таким ФИО уже существует");
	}
}
