package by.academy.pharmacy.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

import static by.academy.pharmacy.entity.Constant.DATE_OF_BIRTH_DB;
import static by.academy.pharmacy.entity.Constant.EMAIL;
import static by.academy.pharmacy.entity.Constant.HEALTH_CARE_CARD_NUMBER_DB;
import static by.academy.pharmacy.entity.Constant.NAME;
import static by.academy.pharmacy.entity.Constant.PAYMENT_CARD_NUMBER_DB;
import static by.academy.pharmacy.entity.Constant.PERSONAL_ACCOUNT_DB;
import static by.academy.pharmacy.entity.Constant.PERSONAL_INFO;
import static by.academy.pharmacy.entity.Constant.PERSONAL_INFO_ENTITY;
import static by.academy.pharmacy.entity.Constant.PHONE;
import static by.academy.pharmacy.entity.Constant.POSITION;
import static by.academy.pharmacy.entity.Constant.SURNAME;

@Entity
@Table(name = PERSONAL_INFO)
public class PersonalInfoEntity implements Serializable {
    /**
     * Contains health care card number of personal info.
     */
    @Id
    @Column(name = HEALTH_CARE_CARD_NUMBER_DB)
    private Long healthCareCardNumber;
    /**
     * Contains surname of the user.
     */
    @Column(name = SURNAME)
    private String surname;
    /**
     * Contains name of the user.
     */
    @Column(name = NAME)
    private String name;
    /**
     * Contains users' birthdate.
     */
    @Column(name = DATE_OF_BIRTH_DB)
    private Date birthDate;
    /**
     * Contains users' address.
     */
    @OneToOne(cascade = CascadeType.ALL)
    @MapsId
    @JoinColumn(name = HEALTH_CARE_CARD_NUMBER_DB)
    private AddressEntity addressEntity;
    /**
     * Contains users' phone number.
     */
    @Column(name = PHONE)
    private String phone;
    /**
     * Contains users' email address.
     */
    @Column(name = EMAIL)
    private String email;
    /**
     * Contains position of the pharmacist.
     */
    @Column(name = POSITION)
    private String position;
    /**
     * Contains clients' personal account value.
     */
    @Column(name = PERSONAL_ACCOUNT_DB)
    private BigDecimal personalAccount;
    /**
     * Contains number of clients' payment card.
     */
    @Column(name = PAYMENT_CARD_NUMBER_DB)
    private Long paymentCardNumber;
    @OneToOne(mappedBy = PERSONAL_INFO_ENTITY, cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private UserEntity userEntity;

    public PersonalInfoEntity() {
    }

    public PersonalInfoEntity(final Long healthCareCardNumber,
                              final String surname,
                              final String name, final Date birthDate,
                              final AddressEntity addressEntity,
                              final String phone, final String email,
                              final String position,
                              final BigDecimal personalAccount,
                              final Long paymentCardNumber,
                              final UserEntity userEntity) {
        this.healthCareCardNumber = healthCareCardNumber;
        this.surname = surname;
        this.name = name;
        this.birthDate = birthDate;
        this.addressEntity = addressEntity;
        this.phone = phone;
        this.email = email;
        this.position = position;
        this.personalAccount = personalAccount;
        this.paymentCardNumber = paymentCardNumber;
        this.userEntity = userEntity;
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

    public AddressEntity getAddressEntity() {
        return addressEntity;
    }

    public void setAddressEntity(final AddressEntity addressEntity) {
        this.addressEntity = addressEntity;
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

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(final UserEntity userEntity) {
        this.userEntity = userEntity;
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
        PersonalInfoEntity other = (PersonalInfoEntity) obj;
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
        return "PersonalInfoEntity [healthCareCardNumber="
                + healthCareCardNumber + ", surname="
                + surname + ", name=" + name + ", birthDate=" + birthDate
                + ", phone=" + phone
                + ", email=" + email + ", position=" + position
                + ", personalAccount="
                + personalAccount + ", paymentCardNumber=" + paymentCardNumber
                + "]";
    }
}
