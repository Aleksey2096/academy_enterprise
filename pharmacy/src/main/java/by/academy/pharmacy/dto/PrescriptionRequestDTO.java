package by.academy.pharmacy.dto;

import by.academy.pharmacy.entity.PrescriptionRequestStatus;

import java.time.LocalDateTime;
import java.util.Objects;

public class PrescriptionRequestDTO {
    /**
     * Contains identification number of prescription request.
     */
    private Long id;
    /**
     * Contains path to prescription scan.
     */
    private String prescriptionScanPath;
    /**
     * Contains time and date of prescription scan uploading.
     */
    private LocalDateTime uploadDateTime;
    /**
     * Contains status of prescription request.
     */
    private PrescriptionRequestStatus prescriptionRequestStatus;
    private UserDTO userDTO;

    public PrescriptionRequestDTO() {
    }

    public PrescriptionRequestDTO(final Long id,
                                  final String prescriptionScanPath,
                                  final LocalDateTime uploadDateTime,
                                  final PrescriptionRequestStatus prescriptionRequestStatus,
                                  final UserDTO userDTO) {
        this.id = id;
        this.prescriptionScanPath = prescriptionScanPath;
        this.uploadDateTime = uploadDateTime;
        this.prescriptionRequestStatus = prescriptionRequestStatus;
        this.userDTO = userDTO;
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

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(final UserDTO userDTO) {
        this.userDTO = userDTO;
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
        PrescriptionRequestDTO other = (PrescriptionRequestDTO) obj;
        return Objects.equals(id, other.id)
                && prescriptionRequestStatus == other.prescriptionRequestStatus
                && Objects.equals(prescriptionScanPath,
                other.prescriptionScanPath)
                && Objects.equals(uploadDateTime, other.uploadDateTime);
    }

    @Override
    public String toString() {
        return "PrescriptionRequestDTO [id=" + id + ", prescriptionScanPath="
                + prescriptionScanPath
                + ", uploadDateTime=" + uploadDateTime
                + ", prescriptionRequestStatus="
                + prescriptionRequestStatus + "]";
    }
}
