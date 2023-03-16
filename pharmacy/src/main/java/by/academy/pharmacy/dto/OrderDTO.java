package by.academy.pharmacy.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public final class OrderDTO implements Serializable {
    /**
     * Contains identification number of order.
     */
    private Long id;
    /**
     * Contains precise time and date of the order.
     */
    private LocalDateTime localDateTime;
    /**
     * Contains user who ordered the medicine.
     */
    private UserDTO userDTO = new UserDTO();
    /**
     * Contains medicine storage with medicine which was ordered by user.
     */
    private MedicineProductDTO medicineProductDTO;
    /**
     * Contains ordered amount of the medicine.
     */
    private int amount;
    /**
     * Contains price of the medicine product, while purchasing.
     */
    private BigDecimal price;

    /**
     * Contains number of clients' payment card.
     */
    private Long paymentCardNumber;
    /**
     * Contains users' contact phone number.
     */
    private String contactPhone;
    /**
     * Contains users' delivery address.
     */
    private String deliveryAddress;

    public OrderDTO() {
    }

    public OrderDTO(final Long id, final LocalDateTime localDateTime,
                    final UserDTO userDTO,
                    final MedicineProductDTO medicineProductDTO,
                    final int amount, final BigDecimal price,
                    final Long paymentCardNumber, final String contactPhone,
                    final String deliveryAddress) {
        this.id = id;
        this.localDateTime = localDateTime;
        this.userDTO = userDTO;
        this.medicineProductDTO = medicineProductDTO;
        this.amount = amount;
        this.price = price;
        this.paymentCardNumber = paymentCardNumber;
        this.contactPhone = contactPhone;
        this.deliveryAddress = deliveryAddress;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(final LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(final BigDecimal price) {
        this.price = price;
    }

    public Long getPaymentCardNumber() {
        return paymentCardNumber;
    }

    public void setPaymentCardNumber(final Long paymentCardNumber) {
        this.paymentCardNumber = paymentCardNumber;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(final String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(final String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, contactPhone, deliveryAddress, id,
                localDateTime,
                paymentCardNumber, price);
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
        OrderDTO other = (OrderDTO) obj;
        return amount == other.amount && Objects.equals(contactPhone,
                other.contactPhone)
                && Objects.equals(deliveryAddress, other.deliveryAddress)
                && Objects.equals(id, other.id)
                && Objects.equals(localDateTime, other.localDateTime)
                && Objects.equals(paymentCardNumber, other.paymentCardNumber)
                && Objects.equals(price, other.price);
    }

    @Override
    public String toString() {
        return "OrderDTO [id=" + id + ", localDateTime=" + localDateTime
                + ", amount=" + amount
                + ", price=" + price + ", paymentCardNumber="
                + paymentCardNumber
                + ", contactPhone=" + contactPhone + ", deliveryAddress="
                + deliveryAddress + "]";
    }
}
