package by.academy.task04mysql.entity;

import java.io.Serializable;
import java.util.Objects;

public final class Person implements Serializable {
	private String name;
	private String surname;
	private Integer age;

	public Person() {
	}

	public Person(final String name, final String surname, final Integer age) {
		this.name = name;
		this.surname = surname;
		this.age = age;
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

	public Integer getAge() {
		return age;
	}

	public void setAge(final Integer age) {
		this.age = age;
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, name, surname);
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final Person other = (Person) obj;
		return Objects.equals(age, other.age) && Objects.equals(name, other.name)
				&& Objects.equals(surname, other.surname);
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", surname=" + surname + ", age=" + age + "]";
	}
}
