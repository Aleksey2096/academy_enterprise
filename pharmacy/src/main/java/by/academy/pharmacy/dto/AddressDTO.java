package by.academy.pharmacy.dto;

import java.io.Serializable;
import java.util.Objects;

public final class AddressDTO implements Serializable {
    private Long healthCareCardNumber;
    private Integer postcode;
    private String city;
    private String street;
    private Integer house;
    private Integer apartment;

    public AddressDTO() {
    }

    public AddressDTO(final Long healthCareCardNumber, final Integer postcode,
                      final String city,
                      final String street, final Integer house,
                      final Integer apartment) {
        this.healthCareCardNumber = healthCareCardNumber;
        this.postcode = postcode;
        this.city = city;
        this.street = street;
        this.house = house;
        this.apartment = apartment;
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
        AddressDTO other = (AddressDTO) obj;
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
        return "AddressDTO [healthCareCardNumber=" + healthCareCardNumber
                + ", postcode=" + postcode
                + ", city=" + city + ", street=" + street + ", house=" + house
                + ", apartment="
                + apartment + "]";
    }
}
