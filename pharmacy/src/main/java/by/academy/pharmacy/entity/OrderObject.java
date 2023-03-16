package by.academy.pharmacy.entity;

import java.util.Objects;

public final class OrderObject {
    /**
     * field which needs to sort objects.
     */
    private String orderField;
    /**
     * descending or ascending type of ordering.
     */
    private OrderType orderType;

    public OrderObject() {
    }

    public OrderObject(final String orderField, final OrderType orderType) {
        this.orderField = orderField;
        this.orderType = orderType;
    }

    public String getOrderField() {
        return orderField;
    }

    public void setOrderField(final String orderField) {
        this.orderField = orderField;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public void setOrderType(final OrderType orderType) {
        this.orderType = orderType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderField, orderType);
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
        OrderObject other = (OrderObject) obj;
        return Objects.equals(orderField, other.orderField)
                && orderType == other.orderType;
    }

    @Override
    public String toString() {
        return "OrderObject [orderField=" + orderField + ", orderType="
                + orderType + "]";
    }
}
