package by.academy.task02reflection.task2_2.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Man implements Serializable {
	private String name;
	private String surname;
	private Integer age;
	private Date dateOfBirth;

	public Man() {
	}

	public Man(String name, String surname, Integer age, Date dateOfBirth) {
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.dateOfBirth = dateOfBirth;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, dateOfBirth, name, surname);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Man other = (Man) obj;
		return Objects.equals(age, other.age) && Objects.equals(dateOfBirth, other.dateOfBirth)
				&& Objects.equals(name, other.name) && Objects.equals(surname, other.surname);
	}

	@Override
	public String toString() {
		return "Man [name=" + name + ", surname=" + surname + ", age=" + age + ", dateOfBirth="
				+ dateOfBirth + "]";
	}
}
