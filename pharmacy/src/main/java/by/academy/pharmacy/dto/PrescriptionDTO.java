package by.academy.pharmacy.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public final class PrescriptionDTO implements Serializable {
    /**
     * Contains identification number of prescription.
     */
    private Long id;
    /**
     * Contains user who has the prescription.
     */
    private UserDTO userDTO;
    /**
     * Contains information about medicine product.
     */
    private MedicineProductDTO medicineProductDTO;
    /**
     * Contains amount of prescribed medicine.
     */
    private int amount;
    /**
     * Contains date of prescription.
     */
    private Date date;

    public PrescriptionDTO() {
    }

    public PrescriptionDTO(final Long id, final UserDTO userDTO,
                           final MedicineProductDTO medicineProductDTO,
                           final int amount, final Date date) {
        this.id = id;
        this.userDTO = userDTO;
        this.medicineProductDTO = medicineProductDTO;
        this.amount = amount;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(final UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public MedicineProductDTO getMedicineProductDTO() {
        return medicineProductDTO;
    }

    public void setMedicineProductDTO(
            final MedicineProductDTO medicineProductDTO) {
        this.medicineProductDTO = medicineProductDTO;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(final int amount) {
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
        PrescriptionDTO other = (PrescriptionDTO) obj;
        return amount == other.amount && Objects.equals(date, other.date)
                && Objects.equals(id, other.id);
    }

    @Override
    public String toString() {
        return "PrescriptionDTO [id=" + id + ", amount=" + amount + ", date="
                + date + "]";
    }
}
