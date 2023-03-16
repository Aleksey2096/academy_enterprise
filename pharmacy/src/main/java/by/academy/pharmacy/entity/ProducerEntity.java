package by.academy.pharmacy.entity;

import by.academy.pharmacy.service.util.CountryConverter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

import static by.academy.pharmacy.entity.Constant.COMPANY_NAME_DB;
import static by.academy.pharmacy.entity.Constant.COUNTRY_CODE_DB;
import static by.academy.pharmacy.entity.Constant.CREATION_DATE_DB;
import static by.academy.pharmacy.entity.Constant.ID;
import static by.academy.pharmacy.entity.Constant.PRODUCERS;
import static by.academy.pharmacy.entity.Constant.PRODUCER_ENTITY;

@Entity
@Table(name = PRODUCERS)
public class ProducerEntity implements Serializable {
    /**
     * Contains identification number of producer.
     */
    @Id
    @Column(name = ID)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * Contains name of the company.
     */
    @Column(name = COMPANY_NAME_DB)
    private String companyName;
    /**
     * Contains information about country where medicine was produced.
     */
    @Column(name = COUNTRY_CODE_DB)
    @Convert(converter = CountryConverter.class)
    private Country country;
    /**
     * Contains date when company was created.
     */
    @Column(name = CREATION_DATE_DB)
    private Date creationDate;
    @OneToMany(mappedBy = PRODUCER_ENTITY, cascade = CascadeType.ALL)
    private Set<MedicineEntity> medicineEntities;

    public ProducerEntity() {
    }

    public ProducerEntity(final Long id, final String companyName,
                          final Country country,
                          final Date creationDate,
                          final Set<MedicineEntity> medicineEntities) {
        this.id = id;
        this.companyName = companyName;
        this.country = country;
        this.creationDate = creationDate;
        this.medicineEntities = medicineEntities;
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

    public Set<MedicineEntity> getMedicineEntities() {
        return medicineEntities;
    }

    public void setMedicineEntities(
            final Set<MedicineEntity> medicineEntities) {
        this.medicineEntities = medicineEntities;
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
        ProducerEntity other = (ProducerEntity) obj;
        return Objects.equals(companyName, other.companyName)
                && country == other.country
                && Objects.equals(creationDate, other.creationDate)
                && Objects.equals(id, other.id);
    }

    @Override
    public String toString() {
        return "ProducerEntity [id=" + id + ", companyName=" + companyName
                + ", country=" + country
                + ", creationDate=" + creationDate + "]";
    }
}
