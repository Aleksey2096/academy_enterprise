package org.example.boot.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Book")
public class Book {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotEmpty(message = "Название книги не должно быть пустым")
	@Size(min = 2, max = 100, message = "Название книги должно быть от 2 до 100 символов длиной")
	@Column(name = "title")
	private String title;

	@NotEmpty(message = "Автор не должен быть пустым")
	@Size(min = 2, max = 100, message = "Имя автора должно быть от 2 до 100 символов длиной")
	@Column(name = "author")
	private String author;

	@Min(value = 1500, message = "Год должен быть больше, чем 1500")
	@Column(name = "year")
	private int year;

	@ManyToOne
	@JoinColumn(name = "person_id", referencedColumnName = "id")
	private Person owner;

	@Column(name = "taken_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date takenAt;

	@Transient
	private boolean expired; // Hibernate не будет замечать этого поля, что нам и нужно.
								// По-умолчанию false.

	public Book() {

	}

	public Book(final String title, final String author, final int year) {
		this.title = title;
		this.author = author;
		this.year = year;
	}

	public int getId() {
		return id;
	}

	public void setId(final int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(final String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(final String author) {
		this.author = author;
	}

	public int getYear() {
		return year;
	}

	public void setYear(final int year) {
		this.year = year;
	}

	public Person getOwner() {
		return owner;
	}

	public void setOwner(final Person owner) {
		this.owner = owner;
	}

	public Date getTakenAt() {
		return takenAt;
	}

	public void setTakenAt(final Date takenAt) {
		this.takenAt = takenAt;
	}

	public boolean isExpired() {
		return expired;
	}

	public void setExpired(final boolean expired) {
		this.expired = expired;
	}
}
