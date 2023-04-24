package org.example.spring.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "items")
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotEmpty(message = "Item name should not be empty")
	@Column(name = "item_name")
	private String itemName;
	@ManyToOne
	@JoinColumn(name = "person_id", referencedColumnName = "id")
	private Person owner;

	public Item() {
	}

	public Item(@NotEmpty(message = "Item name should not be empty") final String itemName) {
		this.itemName = itemName;
	}

	public int getId() {
		return id;
	}

	public void setId(final int id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(final String itemName) {
		this.itemName = itemName;
	}

	public Person getOwner() {
		return owner;
	}

	public void setOwner(final Person owner) {
		this.owner = owner;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Item other = (Item) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", itemName=" + itemName + "]";
	}
}
