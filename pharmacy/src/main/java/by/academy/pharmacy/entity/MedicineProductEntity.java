package by.academy.pharmacy.entity;

import by.academy.pharmacy.service.util.FormConverter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

import static by.academy.pharmacy.entity.Constant.AMOUNT;
import static by.academy.pharmacy.entity.Constant.CART;
import static by.academy.pharmacy.entity.Constant.DOSAGE;
import static by.academy.pharmacy.entity.Constant.FORM;
import static by.academy.pharmacy.entity.Constant.ID;
import static by.academy.pharmacy.entity.Constant.MEDICINE_ID_DB;
import static by.academy.pharmacy.entity.Constant.MEDICINE_PRODUCTS_DB;
import static by.academy.pharmacy.entity.Constant.MEDICINE_PRODUCT_ENTITY;
import static by.academy.pharmacy.entity.Constant.PRICE;

@Entity
@Table(name = MEDICINE_PRODUCTS_DB)
public class MedicineProductEntity implements Serializable {
	/**
	 * Contains identification number of medicine storage.
	 */
	@Id
	@Column(name = ID)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	/**
	 * Reference to the object containing information about medicine.
	 */
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = MEDICINE_ID_DB, referencedColumnName = ID)
	private MedicineEntity medicineEntity;
	/**
	 * Contains the size or frequency of a dose of a medicine or drug.
	 */
	@Column(name = DOSAGE)
	private Short dosage;
	/**
	 * Contains physical representation of medicine.
	 */
	@Column(name = FORM)
	@Convert(converter = FormConverter.class)
	private Form form;
	/**
	 * Contains price of the medicine.
	 */
	@Column(name = PRICE)
	private BigDecimal price;
	/**
	 * Contains amount of concrete medicine available in the storage.
	 */
	@Column(name = AMOUNT)
	private Integer amount;
	@ManyToMany(mappedBy = CART, cascade = CascadeType.ALL)
	private Set<UserEntity> customers = new LinkedHashSet<>();
	@OneToMany(mappedBy = MEDICINE_PRODUCT_ENTITY, cascade = CascadeType.ALL)
	private Set<PrescriptionEntity> prescriptionEntities;
	@OneToMany(mappedBy = MEDICINE_PRODUCT_ENTITY, cascade = CascadeType.ALL)
	private Set<OrderEntity> orderEntities;

	public MedicineProductEntity() {
	}

	public MedicineProductEntity(final Long id,
								 final MedicineEntity medicineEntity,
								 final Short dosage, final Form form,
								 final BigDecimal price, final Integer amount,
								 final Set<UserEntity> customers,
								 final Set<PrescriptionEntity> prescriptionEntities,
								 final Set<OrderEntity> orderEntities) {
		this.id = id;
		this.medicineEntity = medicineEntity;
		this.dosage = dosage;
		this.form = form;
		this.price = price;
		this.amount = amount;
		this.customers = customers;
		this.prescriptionEntities = prescriptionEntities;
		this.orderEntities = orderEntities;
	}

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public MedicineEntity getMedicineEntity() {
		return medicineEntity;
	}

	public void setMedicineEntity(final MedicineEntity medicineEntity) {
		this.medicineEntity = medicineEntity;
	}

	public Short getDosage() {
		return dosage;
	}

	public void setDosage(final Short dosage) {
		this.dosage = dosage;
	}

	public Form getForm() {
		return form;
	}

	public void setForm(final Form form) {
		this.form = form;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(final BigDecimal price) {
		this.price = price;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(final Integer amount) {
		this.amount = amount;
	}

	public Set<UserEntity> getCustomers() {
		return customers;
	}

	public void setCustomers(final Set<UserEntity> customers) {
		this.customers = customers;
	}

	public Set<PrescriptionEntity> getPrescriptionEntities() {
		return prescriptionEntities;
	}

	public void setPrescriptionEntities(
			final Set<PrescriptionEntity> prescriptionEntities) {
		this.prescriptionEntities = prescriptionEntities;
	}

	public Set<OrderEntity> getOrderEntities() {
		return orderEntities;
	}

	public void setOrderEntities(final Set<OrderEntity> orderEntities) {
		this.orderEntities = orderEntities;
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount, dosage, form, id, price);
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
		MedicineProductEntity other = (MedicineProductEntity) obj;
		return Objects.equals(amount, other.amount) && Objects.equals(dosage,
				other.dosage)
				&& form == other.form && Objects.equals(id, other.id)
				&& Objects.equals(price, other.price);
	}

	@Override
	public String toString() {
		return "MedicineProductEntity [id=" + id + ", dosage=" + dosage
				+ ", form=" + form
				+ ", price=" + price + ", amount=" + amount + "]";
	}
}
