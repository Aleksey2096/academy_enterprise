package by.academy.pharmacy.dto;

import by.academy.pharmacy.entity.Country;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public final class ProducerDTO implements Serializable {
    /**
     * Contains identification number of producer.
     */
    private Long id;
    /**
     * Contains name of the company.
     */
    private String companyName;
    /**
     * Contains information about country where medicine was produced.
     */
    private Country country;
    /**
     * Contains date when company was created.
     */
    private Date creationDate;

    public ProducerDTO() {
    }

    public ProducerDTO(final Long id, final String companyName,
                       final Country country,
                       final Date creationDate) {
        this.id = id;
        this.companyName = companyName;
        this.country = country;
        this.creationDate = creationDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(final String companyName) {
        this.companyName = companyName;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(final Country country) {
        this.country = country;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(final Date creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(companyName, country, creationDate, id);
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
        ProducerDTO other = (ProducerDTO) obj;
        return Objects.equals(companyName, other.companyName)
                && country == other.country
                && Objects.equals(creationDate, other.creationDate)
                && Objects.equals(id, other.id);
    }

    @Override
    public String toString() {
        return "ProducerDTO [id=" + id + ", companyName=" + companyName
                + ", country=" + country
                + ", creationDate=" + creationDate + "]";
    }
}