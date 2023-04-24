package org.example.spring.repository;

import java.util.List;

import org.example.spring.model.Item;
import org.example.spring.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemsRepository extends JpaRepository<Item, Integer> {
	List<Item> findByItemName(String itemName);

	List<Item> findByOwner(Person owner);
}
