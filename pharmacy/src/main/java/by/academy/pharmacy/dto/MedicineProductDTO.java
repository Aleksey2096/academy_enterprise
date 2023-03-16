package by.academy.pharmacy.dto;

import by.academy.pharmacy.entity.Form;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public final class MedicineProductDTO implements Serializable {
	/**
	 * Contains identification number of medicine storage.
	 */
	private Long id;
	/**
	 * Reference to the object containing information about medicine.
	 */
	private MedicineDTO medicineDTO;
	/**
	 * Contains the size or frequency of a dose of a medicine or drug.
	 */
	private short dosage;
	/**
	 * Contains physical representation of medicine.
	 */
	private Form form;
	/**
	 * Contains price of the medicine.
	 */
	private BigDecimal price;
	/**
	 * Contains amount of concrete medicine available in the storage.
	 */
	private int amount;

	public MedicineProductDTO() {
	}

	public MedicineProductDTO(final Long id, final MedicineDTO medicineDTO,
							  final short dosage,
							  final Form form, final BigDecimal price,
							  final int amount) {
		this.id = id;
		this.medicineDTO = medicineDTO;
		this.dosage = dosage;
		this.form = form;
		this.price = price;
		this.amount = amount;
	}

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public MedicineDTO getMedicineDTO() {
		return medicineDTO;
	}

	public void setMedicineDTO(final MedicineDTO medicineDTO) {
		this.medicineDTO = medicineDTO;
	}

	public short getDosage() {
		return dosage;
	}

	public void setDosage(final short dosage) {
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

	public int getAmount() {
		return amount;
	}

	public void setAmount(final int amount) {
		this.amount = amount;
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
		MedicineProductDTO other = (MedicineProductDTO) obj;
		return amount == other.amount && dosage == other.dosage
				&& form == other.form
				&& Objects.equals(id, other.id) && Objects.equals(price,
				other.price);
	}

	@Override
	public String toString() {
		return "MedicineProductDTO [id=" + id + ", dosage=" + dosage + ", form="
				+ form + ", price="
				+ price + ", amount=" + amount + "]";
	}
}
