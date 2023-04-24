package org.example.boot.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.example.boot.model.Book;
import org.example.boot.model.Person;
import org.example.boot.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class BooksService {

	private final BooksRepository booksRepository;

	@Autowired
	public BooksService(final BooksRepository booksRepository) {
		this.booksRepository = booksRepository;
	}

	public List<Book> findAll(final boolean sortByYear) {
		if (sortByYear)
			return booksRepository.findAll(Sort.by("year"));
		else
			return booksRepository.findAll();
	}

	public List<Book> findWithPagination(final Integer page, final Integer booksPerPage,
			final boolean sortByYear) {
		if (sortByYear)
			return booksRepository.findAll(PageRequest.of(page, booksPerPage, Sort.by("year")))
					.getContent();
		else
			return booksRepository.findAll(PageRequest.of(page, booksPerPage)).getContent();
	}

	public Book findOne(final int id) {
		Optional<Book> foundBook = booksRepository.findById(id);
		return foundBook.orElse(null);
	}

	public List<Book> searchByTitle(final String query) {
		return booksRepository.findByTitleStartingWith(query);
	}

	@Transactional
	public void save(final Book book) {
		booksRepository.save(book);
	}

	@Transactional
	public void update(final int id, final Book updatedBook) {
		Book bookToBeUpdated = booksRepository.findById(id).get();

		// добавляем по сути новую книгу (которая не находится в Persistence context),
		// поэтому нужен save()
		updatedBook.setId(id);
		updatedBook.setOwner(bookToBeUpdated.getOwner()); // чтобы не терялась связь при обновлении

		booksRepository.save(updatedBook);
	}

	@Transactional
	public void delete(final int id) {
		booksRepository.deleteById(id);
	}

	// Returns null if book has no owner
	public Person getBookOwner(final int id) {
		// Здесь Hibernate.initialize() не нужен, так как владелец (сторона One)
		// загружается не лениво
		return booksRepository.findById(id).map(Book::getOwner).orElse(null);
	}

	// Освбождает книгу (этот метод вызывается, когда человек возвращает книгу в
	// библиотеку)
	@Transactional
	public void release(final int id) {
		booksRepository.findById(id).ifPresent(book -> {
			book.setOwner(null);
			book.setTakenAt(null);
		});
	}

	// Назначает книгу человеку (этот метод вызывается, когда человек забирает книгу
	// из библиотеки)
	@Transactional
	public void assign(final int id, final Person selectedPerson) {
		booksRepository.findById(id).ifPresent(book -> {
			book.setOwner(selectedPerson);
			book.setTakenAt(new Date()); // текущее время
		});
	}
}
