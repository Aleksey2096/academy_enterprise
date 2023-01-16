package by.academy.task05daoAnnotation.entity;

import static by.academy.task05daoAnnotation.entity.Constant.ID_COLUMN_TITLE;
import static by.academy.task05daoAnnotation.entity.Constant.NAME_COLUMN_TITLE;
import static by.academy.task05daoAnnotation.entity.Constant.PERSON_TABLE_TITLE;
import static by.academy.task05daoAnnotation.entity.Constant.PERSON_TO_STRING_MESSAGE;
import static by.academy.task05daoAnnotation.entity.Constant.SURNAME_COLUMN_TITLE;

import java.io.Serializable;
import java.util.Objects;

@MyTable(name = PERSON_TABLE_TITLE)
public final class Person implements Serializable {
	@MyColumn(name = ID_COLUMN_TITLE)
	private Integer id;
	@MyColumn(name = NAME_COLUMN_TITLE)
	private String name;
	@MyColumn(name = SURNAME_COLUMN_TITLE)
	private String surname;

	public Person() {
	}

	public Person(final Integer id, final String name, final String surname) {
		this.id = id;
		this.name = name;
		this.surname = surname;
	}

	public Integer getId() {
		return id;
	}

	public void setId(final Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(final String surname) {
		this.surname = surname;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, surname);
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& Objects.equals(surname, other.surname);
	}

	@Override
	public String toString() {
		return String.format(PERSON_TO_STRING_MESSAGE, getId(), getName(), getSurname());
	}
}
