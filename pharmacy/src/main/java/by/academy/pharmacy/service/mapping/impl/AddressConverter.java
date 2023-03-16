package by.academy.pharmacy.service.mapping.impl;

import by.academy.pharmacy.dto.AddressDTO;
import by.academy.pharmacy.entity.AddressEntity;
import by.academy.pharmacy.service.mapping.Converter;

public class AddressConverter implements Converter<AddressEntity, AddressDTO> {
    @Override
    public AddressDTO convertToDto(final AddressEntity entity) {
        if (entity == null) {
            return null;
        }
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setHealthCareCardNumber(entity.getHealthCareCardNumber());
        addressDTO.setPostcode(entity.getPostcode());
        addressDTO.setCity(entity.getCity());
        addressDTO.setStreet(entity.getStreet());
        addressDTO.setHouse(entity.getHouse());
        addressDTO.setApartment(entity.getApartment());
        return addressDTO;
    }

    @Override
    public AddressEntity convertToEntity(final AddressDTO dto) {
        if (dto == null) {
            return null;
        }
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setHealthCareCardNumber(dto.getHealthCareCardNumber());
        addressEntity.setPostcode(dto.getPostcode());
        addressEntity.setCity(dto.getCity());
        addressEntity.setStreet(dto.getStreet());
        addressEntity.setHouse(dto.getHouse());
        addressEntity.setApartment(dto.getApartment());
        return addressEntity;
    }
}
