package org.example.boot.repository;

import java.util.List;

import org.example.boot.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksRepository extends JpaRepository<Book, Integer> {
	List<Book> findByTitleStartingWith(String title);
}
