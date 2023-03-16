package by.academy.pharmacy.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public final class PersonalInfoDTO implements Serializable {
    /**
     * Contains health care card number of personal info.
     */
    private Long healthCareCardNumber;
    /**
     * Contains surname of the user.
     */
    private String surname;
    /**
     * Contains name of the user.
     */
    private String name;
    /**
     * Contains users' birthdate.
     */
    private Date birthDate;
    /**
     * Contains users' address.
     */
    private AddressDTO addressDTO = new AddressDTO();
    /**
     * Contains users' phone number.
     */
    private String phone;
    /**
     * Contains users' email address.
     */
    private String email;
    /**
     * Contains position of the pharmacist.
     */
    private String position;
    /**
     * Contains clients' personal account value.
     */
    private BigDecimal personalAccount;
    /**
     * Contains number of clients' payment card.
     */
    private Long paymentCardNumber;

    public PersonalInfoDTO() {
    }

    public PersonalInfoDTO(final Long healthCareCardNumber,
                           final String surname, final String name,
                           final Date birthDate, final AddressDTO addressDTO,
                           final String phone,
                           final String email, final String position,
                           final BigDecimal personalAccount,
                           final Long paymentCardNumber) {
        this.healthCareCardNumber = healthCareCardNumber;
        this.surname = surname;
        this.name = name;
        this.birthDate = birthDate;
        this.addressDTO = addressDTO;
        this.phone = phone;
        this.email = email;
        this.position = position;
        this.personalAccount = personalAccount;
        this.paymentCardNumber = paymentCardNumber;
    }

    public Long getHealthCareCardNumber() {
        return healthCareCardNumber;
    }

    public void setHealthCareCardNumber(final Long healthCareCardNumber) {
        this.healthCareCardNumber = healthCareCardNumber;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(final String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(final Date birthDate) {
        this.birthDate = birthDate;
    }

    public AddressDTO getAddressDTO() {
        return addressDTO;
    }

    public void setAddressDTO(final AddressDTO addressDTO) {
        this.addressDTO = addressDTO;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(final String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(final String position) {
        this.position = position;
    }

    public BigDecimal getPersonalAccount() {
        return personalAccount;
    }

    public void setPersonalAccount(final BigDecimal personalAccount) {
        this.personalAccount = personalAccount;
    }

    public Long getPaymentCardNumber() {
        return paymentCardNumber;
    }

    public void setPaymentCardNumber(final Long paymentCardNumber) {
        this.paymentCardNumber = paymentCardNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(birthDate, email, healthCareCardNumber, name,
                paymentCardNumber,
                personalAccount, phone, position, surname);
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
        PersonalInfoDTO other = (PersonalInfoDTO) obj;
        return Objects.equals(birthDate, other.birthDate) && Objects.equals(
                email, other.email)
                && Objects.equals(healthCareCardNumber,
                other.healthCareCardNumber)
                && Objects.equals(name, other.name)
                && Objects.equals(paymentCardNumber, other.paymentCardNumber)
                && Objects.equals(personalAccount, other.personalAccount)
                && Objects.equals(phone, other.phone) && Objects.equals(
                position, other.position)
                && Objects.equals(surname, other.surname);
    }

    @Override
    public String toString() {
        return "PersonalInfoDTO [healthCareCardNumber=" + healthCareCardNumber
                + ", surname="
                + surname + ", name=" + name + ", birthDate=" + birthDate
                + ", phone=" + phone
                + ", email=" + email + ", position=" + position
                + ", personalAccount="
                + personalAccount + ", paymentCardNumber=" + paymentCardNumber
                + "]";
    }
}
