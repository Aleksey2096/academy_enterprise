package by.academy.pharmacy.dto;

import by.academy.pharmacy.entity.Role;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public final class UserDTO implements Serializable {
    /**
     * Contains health care card number of user.
     */
    private Long healthCareCardNumber;
    /**
     * Contains users' login.
     */
    private String login;
    /**
     * Contains users' password.
     */
    private String password;
    /**
     * Contains client, pharmacist, administrator roles of users.
     */
    private Role role;
    /**
     * Contains date when user created account.
     */
    private Date joinedDate;
    /**
     * Contains users' personal information.
     */
    private PersonalInfoDTO personalInfoDTO = new PersonalInfoDTO();
    private String avatarImagePath;
    private Set<MedicineProductDTO> cart = new LinkedHashSet<>();
    private Set<PrescriptionDTO> prescriptionDTOs;
    private Set<OrderDTO> orderDTOs;
    private Set<PrescriptionRequestDTO> prescriptionRequestDTOs;

    public UserDTO() {
    }

    public UserDTO(final Long healthCareCardNumber, final String login,
                   final String password,
                   final Role role, final Date joinedDate,
                   final PersonalInfoDTO personalInfoDTO,
                   final String avatarImagePath,
                   final Set<MedicineProductDTO> cart,
                   final Set<PrescriptionDTO> prescriptionDTOs,
                   final Set<OrderDTO> orderDTOs,
                   final Set<PrescriptionRequestDTO> prescriptionRequestDTOs) {
        this.healthCareCardNumber = healthCareCardNumber;
        this.login = login;
        this.password = password;
        this.role = role;
        this.joinedDate = joinedDate;
        this.personalInfoDTO = personalInfoDTO;
        this.avatarImagePath = avatarImagePath;
        this.cart = cart;
        this.prescriptionDTOs = prescriptionDTOs;
        this.orderDTOs = orderDTOs;
        this.prescriptionRequestDTOs = prescriptionRequestDTOs;
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

    public PersonalInfoDTO getPersonalInfoDTO() {
        return personalInfoDTO;
    }

    public void setPersonalInfoDTO(final PersonalInfoDTO personalInfoDTO) {
        this.personalInfoDTO = personalInfoDTO;
    }

    public String getAvatarImagePath() {
        return avatarImagePath;
    }

    public void setAvatarImagePath(final String avatarImagePath) {
        this.avatarImagePath = avatarImagePath;
    }

    public Set<MedicineProductDTO> getCart() {
        return cart;
    }

    public void setCart(final Set<MedicineProductDTO> cart) {
        this.cart = cart;
    }

    public Set<PrescriptionDTO> getPrescriptionDTOs() {
        return prescriptionDTOs;
    }

    public void setPrescriptionDTOs(
            final Set<PrescriptionDTO> prescriptionDTOs) {
        this.prescriptionDTOs = prescriptionDTOs;
    }

    public Set<OrderDTO> getOrderDTOs() {
        return orderDTOs;
    }

    public void setOrderDTOs(final Set<OrderDTO> orderDTOs) {
        this.orderDTOs = orderDTOs;
    }

    public Set<PrescriptionRequestDTO> getPrescriptionRequestDTOs() {
        return prescriptionRequestDTOs;
    }

    public void setPrescriptionRequestDTOs(
            final Set<PrescriptionRequestDTO> prescriptionRequestDTOs) {
        this.prescriptionRequestDTOs = prescriptionRequestDTOs;
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
        UserDTO other = (UserDTO) obj;
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
        return "UserDTO [healthCareCardNumber=" + healthCareCardNumber
                + ", login=" + login
                + ", password=" + password + ", role=" + role + ", joinedDate="
                + joinedDate
                + ", avatarImagePath=" + avatarImagePath + "]";
    }
}
