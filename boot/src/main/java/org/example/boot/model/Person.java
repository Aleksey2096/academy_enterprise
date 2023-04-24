package org.example.boot.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Person")
public class Person {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotEmpty(message = "Имя не должно быть пустым")
	@Size(min = 2, max = 100, message = "Имя должно быть от 2 до 100 символов длиной")
	@Column(name = "full_name")
	private String fullName;

	@Min(value = 1900, message = "Год рождения должен быть больше, чем 1900")
	@Column(name = "year_of_birth")
	private int yearOfBirth;

	@OneToMany(mappedBy = "owner")
	private List<Book> books;

	// Конструктор по умолчанию нужен для Spring
	public Person() {

	}

	public Person(final String fullName, final int yearOfBirth) {
		this.fullName = fullName;
		this.yearOfBirth = yearOfBirth;
	}

	public int getId() {
		return id;
	}

	public void setId(final int id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(final String fullName) {
		this.fullName = fullName;
	}

	public int getYearOfBirth() {
		return yearOfBirth;
	}

	public void setYearOfBirth(final int yearOfBirth) {
		this.yearOfBirth = yearOfBirth;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(final List<Book> books) {
		this.books = books;
	}
}
