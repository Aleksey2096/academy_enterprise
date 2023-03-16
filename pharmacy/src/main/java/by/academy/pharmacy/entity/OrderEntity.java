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
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

import static by.academy.pharmacy.entity.Constant.AMOUNT;
import static by.academy.pharmacy.entity.Constant.CONTACT_PHONE_DB;
import static by.academy.pharmacy.entity.Constant.DATE_TIME_DB;
import static by.academy.pharmacy.entity.Constant.DELIVERY_ADDRESS_DB;
import static by.academy.pharmacy.entity.Constant.HEALTH_CARE_CARD_NUMBER_DB;
import static by.academy.pharmacy.entity.Constant.ID;
import static by.academy.pharmacy.entity.Constant.MEDICINE_PRODUCT_ID_DB;
import static by.academy.pharmacy.entity.Constant.ORDERS;
import static by.academy.pharmacy.entity.Constant.PAYMENT_CARD_NUMBER_DB;
import static by.academy.pharmacy.entity.Constant.PRICE;

@Entity
@Table(name = ORDERS)
public class OrderEntity implements Serializable {
    /**
     * Contains identification number of order.
     */
    @Id
    @Column(name = ID)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * Contains precise time and date of the order.
     */
    @Column(name = DATE_TIME_DB)
    private LocalDateTime localDateTime;
    /**
     * Contains user who ordered the medicine.
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = HEALTH_CARE_CARD_NUMBER_DB,
            referencedColumnName = HEALTH_CARE_CARD_NUMBER_DB)
    private UserEntity userEntity;
    /**
     * Contains medicine product with medicine which was ordered by user.
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = MEDICINE_PRODUCT_ID_DB, referencedColumnName = ID)
    private MedicineProductEntity medicineProductEntity;
    /**
     * Contains ordered amount of the medicine.
     */
    @Column(name = AMOUNT)
    private Integer amount;
    /**
     * Contains price of the medicine product, while purchasing.
     */
    @Column(name = PRICE)
    private BigDecimal price;

    /**
     * Contains number of clients' payment card.
     */
    @Column(name = PAYMENT_CARD_NUMBER_DB)
    private Long paymentCardNumber;
    /**
     * Contains users' contact phone number.
     */
    @Column(name = CONTACT_PHONE_DB)
    private String contactPhone;
    /**
     * Contains users' delivery address.
     */
    @Column(name = DELIVERY_ADDRESS_DB)
    private String deliveryAddress;

    public OrderEntity() {
    }

    public OrderEntity(final Long id, final LocalDateTime localDateTime,
                       final UserEntity userEntity,
                       final MedicineProductEntity medicineProductEntity,
                       final Integer amount, final BigDecimal price,
                       final Long paymentCardNumber,
                       final String contactPhone,
                       final String deliveryAddress) {
        this.id = id;
        this.localDateTime = localDateTime;
        this.userEntity = userEntity;
        this.medicineProductEntity = medicineProductEntity;
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
        OrderEntity other = (OrderEntity) obj;
        return Objects.equals(amount, other.amount)
                && Objects.equals(contactPhone, other.contactPhone)
                && Objects.equals(deliveryAddress, other.deliveryAddress)
                && Objects.equals(id, other.id)
                && Objects.equals(localDateTime, other.localDateTime)
                && Objects.equals(paymentCardNumber, other.paymentCardNumber)
                && Objects.equals(price, other.price);
    }

    @Override
    public String toString() {
        return "OrderEntity [id=" + id + ", localDateTime=" + localDateTime
                + ", amount=" + amount
                + ", price=" + price + ", paymentCardNumber="
                + paymentCardNumber
                + ", contactPhone=" + contactPhone + ", deliveryAddress="
                + deliveryAddress + "]";
    }
}
