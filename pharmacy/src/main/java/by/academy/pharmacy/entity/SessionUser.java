package by.academy.pharmacy.entity;

import java.io.Serializable;
import java.util.Objects;

public final class SessionUser implements Serializable {
    private Long healthCareCardNumber;
    private String login;
    private Role role;

    public SessionUser() {
    }

    public SessionUser(final Long healthCareCardNumber, final String login,
                       final Role role) {
        this.healthCareCardNumber = healthCareCardNumber;
        this.login = login;
        this.role = role;
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

    public Role getRole() {
        return role;
    }

    public void setRole(final Role role) {
        this.role = role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(healthCareCardNumber, login, role);
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
        SessionUser other = (SessionUser) obj;
        return Objects.equals(healthCareCardNumber, other.healthCareCardNumber)
                && Objects.equals(login, other.login) && role == other.role;
    }

    @Override
    public String toString() {
        return "SessionUser [healthCareCardNumber=" + healthCareCardNumber
                + ", login=" + login
                + ", role=" + role + "]";
    }
}
