package org.example.boot.repository;

import java.util.Optional;

import org.example.boot.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeopleRepository extends JpaRepository<Person, Integer> {
	Optional<Person> findByFullName(String fullName);
}
