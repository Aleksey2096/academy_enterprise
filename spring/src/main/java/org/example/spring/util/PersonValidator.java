package org.example.spring.util;

import org.example.spring.model.Person;
import org.example.spring.repository.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class PersonValidator implements Validator {

	private final PeopleRepository peopleRepository;

	@Autowired
	public PersonValidator(final PeopleRepository peopleRepository) {
		this.peopleRepository = peopleRepository;
	}

	@Override
	public boolean supports(final Class<?> clazz) {
		return Person.class.equals(clazz);
	}

	@Override
	public void validate(final Object target, final Errors errors) {
		Person person = (Person) target;

		if (peopleRepository.findById(person.getId()).isPresent()
				&& peopleRepository.findByEmail(person.getEmail()).size() > 1) {
			errors.rejectValue("email", "", "This email is already taken!");
		} else if (peopleRepository.findById(person.getId()).isEmpty()
				&& !peopleRepository.findByEmail(person.getEmail()).isEmpty()) {
			errors.rejectValue("email", "", "This email is already taken!");
		}
	}
}
