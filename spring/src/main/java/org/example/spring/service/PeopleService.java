package org.example.spring.service;

import java.util.List;
import java.util.Optional;

import org.example.spring.model.Person;
import org.example.spring.repository.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class PeopleService {

	private final PeopleRepository peopleRepository;

	@Autowired
	public PeopleService(final PeopleRepository peopleRepository) {
		this.peopleRepository = peopleRepository;
	}

	public List<Person> findAll() {
		return peopleRepository.findAll();
	}

	public Person findOne(final int id) {
		Optional<Person> foundPerson = peopleRepository.findById(id);
		return foundPerson.orElse(null);
	}

	@Transactional
	public void save(final Person person) {
		peopleRepository.save(person);
	}

	@Transactional
	public void update(final int id, final Person updatedPerson) {
		updatedPerson.setId(id);
		peopleRepository.save(updatedPerson);
	}

	@Transactional
	public void delete(final int id) {
		peopleRepository.deleteById(id);
	}
}
