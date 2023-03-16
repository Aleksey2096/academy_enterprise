package by.academy.pharmacy.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Objects;

import static by.academy.pharmacy.entity.Constant.HEALTH_CARE_CARD_NUMBER_DB;
import static by.academy.pharmacy.entity.Constant.ID;
import static by.academy.pharmacy.entity.Constant.PRESCRIPTION_REQUESTS_DB;
import static by.academy.pharmacy.entity.Constant.PRESCRIPTION_REQUEST_STATUS_DB;
import static by.academy.pharmacy.entity.Constant.PRESCRIPTION_SCAN_PATH_DB;
import static by.academy.pharmacy.entity.Constant.UPLOAD_DATE_TIME_DB;

@Entity
@Table(name = PRESCRIPTION_REQUESTS_DB)
public class PrescriptionRequestEntity {
    /**
     * Contains identification number of prescription request.
     */
    @Id
    @Column(name = ID)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * Contains path to prescription scan.
     */
    @Column(name = PRESCRIPTION_SCAN_PATH_DB)
    private String prescriptionScanPath;
    /**
     * Contains time and date of prescription scan uploading.
     */
    @Column(name = UPLOAD_DATE_TIME_DB)
    private LocalDateTime uploadDateTime;
    /**
     * Contains status of prescription request.
     */
    @Column(name = PRESCRIPTION_REQUEST_STATUS_DB)
    @Enumerated(EnumType.STRING)
    private PrescriptionRequestStatus prescriptionRequestStatus;
    /**
     * Contains user who made prescription request.
     */
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = HEALTH_CARE_CARD_NUMBER_DB,
            referencedColumnName = HEALTH_CARE_CARD_NUMBER_DB)
    private UserEntity userEntity;

    public PrescriptionRequestEntity() {
    }

    public PrescriptionRequestEntity(final Long id,
                                     final String prescriptionScanPath,
                                     final LocalDateTime uploadDateTime,
                                     final PrescriptionRequestStatus prescriptionRequestStatus,
                                     final UserEntity userEntity) {
        this.id = id;
        this.prescriptionScanPath = prescriptionScanPath;
        this.uploadDateTime = uploadDateTime;
        this.prescriptionRequestStatus = prescriptionRequestStatus;
        this.userEntity = userEntity;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getPrescriptionScanPath() {
        return prescriptionScanPath;
    }

    public void setPrescriptionScanPath(final String prescriptionScanPath) {
        this.prescriptionScanPath = prescriptionScanPath;
    }

    public LocalDateTime getUploadDateTime() {
        return uploadDateTime;
    }

    public void setUploadDateTime(final LocalDateTime uploadDateTime) {
        this.uploadDateTime = uploadDateTime;
    }

    public PrescriptionRequestStatus getPrescriptionRequestStatus() {
        return prescriptionRequestStatus;
    }

    public void setPrescriptionRequestStatus(
            final PrescriptionRequestStatus prescriptionRequestStatus) {
        this.prescriptionRequestStatus = prescriptionRequestStatus;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(final UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, prescriptionRequestStatus, prescriptionScanPath,
                uploadDateTime);
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
        PrescriptionRequestEntity other = (PrescriptionRequestEntity) obj;
        return Objects.equals(id, other.id)
                && prescriptionRequestStatus == other.prescriptionRequestStatus
                && Objects.equals(prescriptionScanPath,
                other.prescriptionScanPath)
                && Objects.equals(uploadDateTime, other.uploadDateTime);
    }

    @Override
    public String toString() {
        return "PrescriptionRequestEntity [id=" + id + ", prescriptionScanPath="
                + prescriptionScanPath + ", uploadDateTime=" + uploadDateTime
                + ", prescriptionRequestStatus=" + prescriptionRequestStatus
                + "]";
    }
}
