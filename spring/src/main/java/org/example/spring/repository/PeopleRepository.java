package org.example.spring.repository;

import java.util.List;

import org.example.spring.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeopleRepository extends JpaRepository<Person, Integer> {
	List<Person> findByEmail(String email);

	List<Person> findByName(String name);

	List<Person> findByNameOrderByAge(String name);

	List<Person> findByNameStartingWith(String name);

	List<Person> findByNameOrEmail(String name, String email);

}
