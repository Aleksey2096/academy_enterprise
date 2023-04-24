package org.example.boot.service;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.example.boot.model.Book;
import org.example.boot.model.Person;
import org.example.boot.repository.PeopleRepository;
import org.hibernate.Hibernate;
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

	public Optional<Person> getPersonByFullName(final String fullName) {
		return peopleRepository.findByFullName(fullName);
	}

	public List<Book> getBooksByPersonId(final int id) {
		Optional<Person> person = peopleRepository.findById(id);

		if (person.isPresent()) {
			Hibernate.initialize(person.get().getBooks());
			// Мы внизу итерируемся по книгам, поэтому они точно будут загружены, но на
			// всякий случай
			// не мешает всегда вызывать Hibernate.initialize()
			// (на случай, например, если код в дальнейшем поменяется и итерация по книгам
			// удалится)

			// Проверка просроченности книг
			person.get().getBooks().forEach(book -> {
				long diffInMillies = Math.abs(book.getTakenAt().getTime() - new Date().getTime());
				// 864000000 милисекунд = 10 суток
				if (diffInMillies > 864000000)
					book.setExpired(true); // книга просрочена
			});

			return person.get().getBooks();
		} else {
			return Collections.emptyList();
		}
	}
}
