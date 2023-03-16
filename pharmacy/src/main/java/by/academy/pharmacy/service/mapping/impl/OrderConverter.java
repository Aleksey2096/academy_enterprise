package by.academy.pharmacy.service.mapping.impl;

import by.academy.pharmacy.dto.MedicineProductDTO;
import by.academy.pharmacy.dto.OrderDTO;
import by.academy.pharmacy.dto.UserDTO;
import by.academy.pharmacy.entity.MedicineProductEntity;
import by.academy.pharmacy.entity.OrderEntity;
import by.academy.pharmacy.entity.UserEntity;
import by.academy.pharmacy.service.mapping.Converter;

public class OrderConverter implements Converter<OrderEntity, OrderDTO> {
    private final Converter<UserEntity, UserDTO> userConverter
            = new UserConverter();
    private final Converter<MedicineProductEntity, MedicineProductDTO>
            medicineProductConverter = new MedicineProductConverter();

    @Override
    public OrderDTO convertToDto(final OrderEntity entity) {
        if (entity == null) {
            return null;
        }
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(entity.getId());
        orderDTO.setLocalDateTime(entity.getLocalDateTime());
        orderDTO.setUserDTO(userConverter.convertToDto(entity.getUserEntity()));
        orderDTO.setMedicineProductDTO(
                medicineProductConverter.convertToDto(
                        entity.getMedicineProductEntity()));
        orderDTO.setAmount(entity.getAmount());
        orderDTO.setPrice(entity.getPrice());
        orderDTO.setPaymentCardNumber(entity.getPaymentCardNumber());
        orderDTO.setContactPhone(entity.getContactPhone());
        orderDTO.setDeliveryAddress(entity.getDeliveryAddress());
        return orderDTO;
    }

    @Override
    public OrderEntity convertToEntity(final OrderDTO dto) {
        if (dto == null) {
            return null;
        }
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setId(dto.getId());
        orderEntity.setLocalDateTime(dto.getLocalDateTime());
        orderEntity.setUserEntity(
                userConverter.convertToEntity(dto.getUserDTO()));
        orderEntity.setMedicineProductEntity(
                medicineProductConverter.convertToEntity(
                        dto.getMedicineProductDTO()));
        orderEntity.setAmount(dto.getAmount());
        orderEntity.setPrice(dto.getPrice());
        orderEntity.setPaymentCardNumber(dto.getPaymentCardNumber());
        orderEntity.setContactPhone(dto.getContactPhone());
        orderEntity.setDeliveryAddress(dto.getDeliveryAddress());
        return orderEntity;
    }
}
