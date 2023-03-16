package by.academy.pharmacy.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class MedicineDTO implements Serializable {
    /**
     * Contains identification number of medicine.
     */
    private Long id;
    /**
     * Contains title of the medicine.
     */
    private String title;
    /**
     * Indicates whether medicine needs prescription to be sold or not.
     */
    private boolean isNonprescription;
    /**
     * Contains information about medicine producer.
     */
    private ProducerDTO producerDTO = new ProducerDTO();
    private Date approvalDate;
    private String medicineImagePath;

    public MedicineDTO() {
    }

    public MedicineDTO(final Long id, final String title,
                       final boolean isNonprescription,
                       final ProducerDTO producerDTO, final Date approvalDate,
                       final String medicineImagePath) {
        this.id = id;
        this.title = title;
        this.isNonprescription = isNonprescription;
        this.producerDTO = producerDTO;
        this.approvalDate = approvalDate;
        this.medicineImagePath = medicineImagePath;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public boolean getIsNonprescription() {
        return isNonprescription;
    }

    public void setIsNonprescription(final boolean isNonprescription) {
        this.isNonprescription = isNonprescription;
    }

    public ProducerDTO getProducerDTO() {
        return producerDTO;
    }

    public void setProducerDTO(final ProducerDTO producerDTO) {
        this.producerDTO = producerDTO;
    }

    public Date getApprovalDate() {
        return approvalDate;
    }

    public void setApprovalDate(final Date approvalDate) {
        this.approvalDate = approvalDate;
    }

    public String getMedicineImagePath() {
        return medicineImagePath;
    }

    public void setMedicineImagePath(final String medicineImagePath) {
        this.medicineImagePath = medicineImagePath;
    }

    @Override
    public int hashCode() {
        return Objects.hash(approvalDate, id, isNonprescription,
                medicineImagePath, title);
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
        MedicineDTO other = (MedicineDTO) obj;
        return Objects.equals(approvalDate, other.approvalDate)
                && Objects.equals(id, other.id)
                && isNonprescription == other.isNonprescription
                && Objects.equals(medicineImagePath, other.medicineImagePath)
                && Objects.equals(title, other.title);
    }

    @Override
    public String toString() {
        return "MedicineDTO [id=" + id + ", title=" + title
                + ", isNonprescription="
                + isNonprescription + ", approvalDate=" + approvalDate
                + ", medicineImagePath="
                + medicineImagePath + "]";
    }
}
