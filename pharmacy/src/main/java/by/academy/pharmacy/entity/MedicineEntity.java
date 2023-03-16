package by.academy.pharmacy.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

import static by.academy.pharmacy.entity.Constant.APPROVAL_DATE_DB;
import static by.academy.pharmacy.entity.Constant.ID;
import static by.academy.pharmacy.entity.Constant.IS_NONPRESCRIPTION_DB;
import static by.academy.pharmacy.entity.Constant.MEDICINES;
import static by.academy.pharmacy.entity.Constant.MEDICINE_ENTITY;
import static by.academy.pharmacy.entity.Constant.MEDICINE_IMAGE_PATH_DB;
import static by.academy.pharmacy.entity.Constant.PRODUCER_ID_DB;
import static by.academy.pharmacy.entity.Constant.TITLE;

@Entity
@Table(name = MEDICINES)
public class MedicineEntity implements Serializable {
	/**
	 * Contains identification number of medicine.
	 */
	@Id
	@Column(name = ID)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	/**
	 * Contains title of the medicine.
	 */
	@Column(name = TITLE)
	private String title;
	/**
	 * Indicates whether medicine needs prescription to be sold or not.
	 */
	@Column(name = IS_NONPRESCRIPTION_DB)
	private boolean isNonprescription;
	/**
	 * Contains information about medicine producer.
	 */
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = PRODUCER_ID_DB, referencedColumnName = ID)
	private ProducerEntity producerEntity;
	@Column(name = APPROVAL_DATE_DB)
	private Date approvalDate;
	@Column(name = MEDICINE_IMAGE_PATH_DB)
	private String medicineImagePath;
	@OneToMany(mappedBy = MEDICINE_ENTITY, cascade = CascadeType.ALL)
	private Set<MedicineProductEntity> medicineProductEntities;

	public MedicineEntity() {
	}

	public MedicineEntity(final Long id, final String title,
						  final boolean isNonprescription,
						  final ProducerEntity producerEntity,
						  final Date approvalDate,
						  final String medicineImagePath,
						  final Set<MedicineProductEntity> medicineProductEntities) {
		this.id = id;
		this.title = title;
		this.isNonprescription = isNonprescription;
		this.producerEntity = producerEntity;
		this.approvalDate = approvalDate;
		this.medicineImagePath = medicineImagePath;
		this.medicineProductEntities = medicineProductEntities;
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

	public boolean isNonprescription() {
		return isNonprescription;
	}

	public void setNonprescription(final boolean isNonprescription) {
		this.isNonprescription = isNonprescription;
	}

	public ProducerEntity getProducerEntity() {
		return producerEntity;
	}

	public void setProducerEntity(final ProducerEntity producerEntity) {
		this.producerEntity = producerEntity;
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

	public Set<MedicineProductEntity> getMedicineProductEntities() {
		return medicineProductEntities;
	}

	public void setMedicineProductEntities(
			final Set<MedicineProductEntity> medicineProductEntities) {
		this.medicineProductEntities = medicineProductEntities;
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
		MedicineEntity other = (MedicineEntity) obj;
		return Objects.equals(approvalDate, other.approvalDate)
				&& Objects.equals(id, other.id)
				&& isNonprescription == other.isNonprescription
				&& Objects.equals(medicineImagePath, other.medicineImagePath)
				&& Objects.equals(title, other.title);
	}

	@Override
	public String toString() {
		return "MedicineEntity [id=" + id + ", title=" + title
				+ ", isNonprescription="
				+ isNonprescription + ", approvalDate=" + approvalDate
				+ ", medicineImagePath="
				+ medicineImagePath + "]";
	}
}
