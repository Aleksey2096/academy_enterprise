package by.academy.pharmacy.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

import static by.academy.pharmacy.entity.Constant.AVATAR_IMAGE_PATH_DB;
import static by.academy.pharmacy.entity.Constant.CARTS;
import static by.academy.pharmacy.entity.Constant.DATE_JOINED_DB;
import static by.academy.pharmacy.entity.Constant.HEALTH_CARE_CARD_NUMBER_DB;
import static by.academy.pharmacy.entity.Constant.LOGIN;
import static by.academy.pharmacy.entity.Constant.MEDICINE_PRODUCT_ID_DB;
import static by.academy.pharmacy.entity.Constant.PASSWORD;
import static by.academy.pharmacy.entity.Constant.USERS;
import static by.academy.pharmacy.entity.Constant.USER_ENTITY;

@Entity
@Table(name = USERS)
public class UserEntity implements Serializable {
    /**
     * Contains health care card number of user.
     */
    @Id
    @Column(name = HEALTH_CARE_CARD_NUMBER_DB)
    private Long healthCareCardNumber;
    /**
     * Contains users' login.
     */
    @Column(name = LOGIN)
    private String login;
    /**
     * Contains users' password.
     */
    @Column(name = PASSWORD)
    private String password;
    /**
     * Contains client, pharmacist, administrator roles of users.
     */
    @Enumerated(EnumType.ORDINAL)
    private Role role;
    /**
     * Contains date when user created account.
     */
    @Column(name = DATE_JOINED_DB)
    private Date joinedDate;
    /**
     * Contains users' personal information.
     */
    @OneToOne(cascade = CascadeType.ALL)
    @MapsId
    @JoinColumn(name = HEALTH_CARE_CARD_NUMBER_DB)
    private PersonalInfoEntity personalInfoEntity = new PersonalInfoEntity();
    @Column(name = AVATAR_IMAGE_PATH_DB)
    private String avatarImagePath;
    @ManyToMany
    @JoinTable(name = CARTS,
            joinColumns = @JoinColumn(name = HEALTH_CARE_CARD_NUMBER_DB),
            inverseJoinColumns = @JoinColumn(name = MEDICINE_PRODUCT_ID_DB))
    private Set<MedicineProductEntity> cart = new LinkedHashSet<>();
    @OneToMany(mappedBy = USER_ENTITY, cascade = CascadeType.ALL)
    private Set<PrescriptionEntity> prescriptionEntities;
    @OneToMany(mappedBy = USER_ENTITY, cascade = CascadeType.ALL)
    private Set<OrderEntity> orderEntities;
    @OneToMany(mappedBy = USER_ENTITY, cascade = CascadeType.ALL)
    private Set<PrescriptionRequestEntity> prescriptionRequestEntities;

    public UserEntity() {
    }

    public UserEntity(final Long healthCareCardNumber, final String login,
                      final String password,
                      final Role role, final Date joinedDate,
                      final PersonalInfoEntity personalInfoEntity,
                      final String avatarImagePath,
                      final Set<MedicineProductEntity> cart,
                      final Set<PrescriptionEntity> prescriptionEntities,
                      final Set<OrderEntity> orderEntities,
                      final Set<PrescriptionRequestEntity> prescriptionRequestEntities) {
        this.healthCareCardNumber = healthCareCardNumber;
        this.login = login;
        this.password = password;
        this.role = role;
        this.joinedDate = joinedDate;
        this.personalInfoEntity = personalInfoEntity;
        this.avatarImagePath = avatarImagePath;
        this.cart = cart;
        this.prescriptionEntities = prescriptionEntities;
        this.orderEntities = orderEntities;
        this.prescriptionRequestEntities = prescriptionRequestEntities;
    }

    public Long getHealthCareCardNumber() {
        return healthCareCardNumber;
    }

    public void setHealthCareCardNumber(final Long healthCareCardNumber) {
        this.healthCareCardNumber = healthCareCardNumber;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(final String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(final Role role) {
        this.role = role;
    }

    public Date getJoinedDate() {
        return joinedDate;
    }

    public void setJoinedDate(final Date joinedDate) {
        this.joinedDate = joinedDate;
    }

    public PersonalInfoEntity getPersonalInfoEntity() {
        return personalInfoEntity;
    }

    public void setPersonalInfoEntity(
            final PersonalInfoEntity personalInfoEntity) {
        this.personalInfoEntity = personalInfoEntity;
    }

    public String getAvatarImagePath() {
        return avatarImagePath;
    }

    public void setAvatarImagePath(final String avatarImagePath) {
        this.avatarImagePath = avatarImagePath;
    }

    public Set<MedicineProductEntity> getCart() {
        return cart;
    }

    public void setCart(final Set<MedicineProductEntity> cart) {
        this.cart = cart;
    }

    public Set<PrescriptionEntity> getPrescriptionEntities() {
        return prescriptionEntities;
    }

    public void setPrescriptionEntities(
            final Set<PrescriptionEntity> prescriptionEntities) {
        this.prescriptionEntities = prescriptionEntities;
    }

    public Set<OrderEntity> getOrderEntities() {
        return orderEntities;
    }

    public void setOrderEntities(final Set<OrderEntity> orderEntities) {
        this.orderEntities = orderEntities;
    }

    public Set<PrescriptionRequestEntity> getPrescriptionRequestEntities() {
        return prescriptionRequestEntities;
    }

    public void setPrescriptionRequestEntities(
            final Set<PrescriptionRequestEntity> prescriptionRequestEntities) {
        this.prescriptionRequestEntities = prescriptionRequestEntities;
    }

    @Override
    public int hashCode() {
        return Objects.hash(avatarImagePath, healthCareCardNumber, joinedDate,
                login, password,
                role);
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
        UserEntity other = (UserEntity) obj;
        return Objects.equals(avatarImagePath, other.avatarImagePath)
                && Objects.equals(healthCareCardNumber,
                other.healthCareCardNumber)
                && Objects.equals(joinedDate, other.joinedDate)
                && Objects.equals(login, other.login) && Objects.equals(
                password, other.password)
                && role == other.role;
    }

    @Override
    public String toString() {
        return "UserEntity [healthCareCardNumber=" + healthCareCardNumber
                + ", login=" + login
                + ", password=" + password + ", role=" + role + ", joinedDate="
                + joinedDate
                + ", avatarImagePath=" + avatarImagePath + "]";
    }
}
