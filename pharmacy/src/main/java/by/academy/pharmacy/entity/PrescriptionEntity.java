package by.academy.pharmacy.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import static by.academy.pharmacy.entity.Constant.AMOUNT;
import static by.academy.pharmacy.entity.Constant.DATE;
import static by.academy.pharmacy.entity.Constant.HEALTH_CARE_CARD_NUMBER_DB;
import static by.academy.pharmacy.entity.Constant.ID;
import static by.academy.pharmacy.entity.Constant.MEDICINE_PRODUCT_ID_DB;
import static by.academy.pharmacy.entity.Constant.PRESCRIPTIONS;

@Entity
@Table(name = PRESCRIPTIONS)
public class PrescriptionEntity implements Serializable {
    /**
     * Contains identification number of prescription.
     */
    @Id
    @Column(name = ID)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * Contains user who has the prescription.
     */
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = HEALTH_CARE_CARD_NUMBER_DB,
            referencedColumnName = HEALTH_CARE_CARD_NUMBER_DB)
    private UserEntity userEntity;
    /**
     * Contains information about medicine product.
     */
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = MEDICINE_PRODUCT_ID_DB, referencedColumnName = ID)
    private MedicineProductEntity medicineProductEntity;
    /**
     * Contains amount of prescribed medicine.
     */
    @Column(name = AMOUNT)
    private Integer amount;
    /**
     * Contains date of prescription.
     */
    @Column(name = DATE)
    private Date date;

    public PrescriptionEntity() {
    }

    public PrescriptionEntity(final Long id, final UserEntity userEntity,
                              final MedicineProductEntity medicineProductEntity,
                              final Integer amount,
                              final Date date) {
        this.id = id;
        this.userEntity = userEntity;
        this.medicineProductEntity = medicineProductEntity;
        this.amount = amount;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(final UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public MedicineProductEntity getMedicineProductEntity() {
        return medicineProductEntity;
    }

    public void setMedicineProductEntity(
            final MedicineProductEntity medicineProductEntity) {
        this.medicineProductEntity = medicineProductEntity;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(final Integer amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(final Date date) {
        this.date = date;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, date, id);
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
        PrescriptionEntity other = (PrescriptionEntity) obj;
        return Objects.equals(amount, other.amount) && Objects.equals(date,
                other.date)
                && Objects.equals(id, other.id);
    }

    @Override
    public String toString() {
        return "PrescriptionEntity [id=" + id + ", amount=" + amount + ", date="
                + date + "]";
    }
}
