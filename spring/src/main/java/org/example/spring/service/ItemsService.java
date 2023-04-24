package org.example.spring.service;

import java.util.List;

import org.example.spring.model.Item;
import org.example.spring.model.Person;
import org.example.spring.repository.ItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class ItemsService {
	private final ItemsRepository itemsRepository;

	@Autowired
	public ItemsService(final ItemsRepository itemsRepository) {
		this.itemsRepository = itemsRepository;
	}

	public List<Item> findByItemName(final String itemName) {
		return itemsRepository.findByItemName(itemName);
	}

	public List<Item> findByOwner(final Person owner) {
		return itemsRepository.findByOwner(owner);
	}
}
