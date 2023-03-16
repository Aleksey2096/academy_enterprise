package by.academy.pharmacy.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

import static by.academy.pharmacy.entity.Constant.ADDRESSES;
import static by.academy.pharmacy.entity.Constant.ADDRESS_ENTITY;
import static by.academy.pharmacy.entity.Constant.APARTMENT;
import static by.academy.pharmacy.entity.Constant.CITY;
import static by.academy.pharmacy.entity.Constant.HEALTH_CARE_CARD_NUMBER_DB;
import static by.academy.pharmacy.entity.Constant.HOUSE;
import static by.academy.pharmacy.entity.Constant.POSTCODE;
import static by.academy.pharmacy.entity.Constant.STREET;

@Entity
@Table(name = ADDRESSES)
public class AddressEntity implements Serializable {
	@Id
	@Column(name = HEALTH_CARE_CARD_NUMBER_DB)
	private Long healthCareCardNumber;
	@Column(name = POSTCODE)
	private Integer postcode;
	@Column(name = CITY)
	private String city;
	@Column(name = STREET)
	private String street;
	@Column(name = HOUSE)
	private Integer house;
	@Column(name = APARTMENT)
	private Integer apartment;
	@OneToOne(mappedBy = ADDRESS_ENTITY, cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private PersonalInfoEntity personalInfoEntity;

	public AddressEntity() {
	}

	public AddressEntity(final Long healthCareCardNumber,
						 final Integer postcode, final String city,
						 final String street, final Integer house,
						 final Integer apartment,
						 final PersonalInfoEntity personalInfoEntity) {
		this.healthCareCardNumber = healthCareCardNumber;
		this.postcode = postcode;
		this.city = city;
		this.street = street;
		this.house = house;
		this.apartment = apartment;
		this.personalInfoEntity = personalInfoEntity;
	}

	public Long getHealthCareCardNumber() {
		return healthCareCardNumber;
	}

	public void setHealthCareCardNumber(final Long healthCareCardNumber) {
		this.healthCareCardNumber = healthCareCardNumber;
	}

	public Integer getPostcode() {
		return postcode;
	}

	public void setPostcode(final Integer postcode) {
		this.postcode = postcode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(final String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(final String street) {
		this.street = street;
	}

	public Integer getHouse() {
		return house;
	}

	public void setHouse(final Integer house) {
		this.house = house;
	}

	public Integer getApartment() {
		return apartment;
	}

	public void setApartment(final Integer apartment) {
		this.apartment = apartment;
	}

	public PersonalInfoEntity getPersonalInfoEntity() {
		return personalInfoEntity;
	}

	public void setPersonalInfoEntity(
			final PersonalInfoEntity personalInfoEntity) {
		this.personalInfoEntity = personalInfoEntity;
	}

	@Override
	public int hashCode() {
		return Objects.hash(apartment, city, healthCareCardNumber, house,
				postcode, street);
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
		AddressEntity other = (AddressEntity) obj;
		return Objects.equals(apartment, other.apartment) && Objects.equals(
				city, other.city)
				&& Objects.equals(healthCareCardNumber,
				other.healthCareCardNumber)
				&& Objects.equals(house, other.house) && Objects.equals(
				postcode, other.postcode)
				&& Objects.equals(street, other.street);
	}

	@Override
	public String toString() {
		return "AddressEntity [healthCareCardNumber=" + healthCareCardNumber
				+ ", postcode="
				+ postcode + ", city=" + city + ", street=" + street
				+ ", house=" + house
				+ ", apartment=" + apartment + "]";
	}
}
