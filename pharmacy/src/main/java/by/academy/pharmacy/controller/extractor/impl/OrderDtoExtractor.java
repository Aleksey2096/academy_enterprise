package by.academy.pharmacy.controller.extractor.impl;

import by.academy.pharmacy.controller.extractor.Extractor;
import by.academy.pharmacy.dto.MedicineProductDTO;
import by.academy.pharmacy.dto.OrderDTO;
import by.academy.pharmacy.dto.UserDTO;
import by.academy.pharmacy.service.util.RequestDataUtil;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

import static by.academy.pharmacy.entity.Constant.AMOUNT;
import static by.academy.pharmacy.entity.Constant.CONTACT_PHONE_DB;
import static by.academy.pharmacy.entity.Constant.DELIVERY_ADDRESS_DB;
import static by.academy.pharmacy.entity.Constant.HEALTH_CARE_CARD_NUMBER_DB;
import static by.academy.pharmacy.entity.Constant.MEDICINE_PRODUCT_ID_DB;
import static by.academy.pharmacy.entity.Constant.ORDER_ID_DB;
import static by.academy.pharmacy.entity.Constant.PAYMENT_CARD_NUMBER_DB;
import static by.academy.pharmacy.entity.Constant.PRICE;

public class OrderDtoExtractor implements Extractor<OrderDTO> {
    private final RequestDataUtil requestDataUtil
            = RequestDataUtil.getInstance();

    @Override
    public OrderDTO extract(final HttpServletRequest request) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(requestDataUtil.getLong(ORDER_ID_DB, request));
        orderDTO.setLocalDateTime(LocalDateTime.now());
        UserDTO userDTO = new UserDTO();
        userDTO.setHealthCareCardNumber(
                requestDataUtil.getLong(HEALTH_CARE_CARD_NUMBER_DB, request));
        orderDTO.setUserDTO(userDTO);
        MedicineProductDTO medicineProductDTO = new MedicineProductDTO();
        medicineProductDTO.setId(
                requestDataUtil.getLong(MEDICINE_PRODUCT_ID_DB, request));
        orderDTO.setMedicineProductDTO(medicineProductDTO);
        orderDTO.setAmount(requestDataUtil.getInteger(AMOUNT, request));
        orderDTO.setPrice(requestDataUtil.getBigDecimal(PRICE, request));
        orderDTO.setPaymentCardNumber(
                requestDataUtil.getLong(PAYMENT_CARD_NUMBER_DB, request));
        orderDTO.setContactPhone(
                requestDataUtil.getString(CONTACT_PHONE_DB, request));
        orderDTO.setDeliveryAddress(
                requestDataUtil.getString(DELIVERY_ADDRESS_DB, request));
        return orderDTO;
    }
}
