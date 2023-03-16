package by.academy.pharmacy.service.mapping.impl;

import by.academy.pharmacy.dto.AddressDTO;
import by.academy.pharmacy.dto.PersonalInfoDTO;
import by.academy.pharmacy.entity.AddressEntity;
import by.academy.pharmacy.entity.PersonalInfoEntity;
import by.academy.pharmacy.service.mapping.Converter;

public class PersonalInfoConverter
        implements Converter<PersonalInfoEntity, PersonalInfoDTO> {
    private final Converter<AddressEntity, AddressDTO> addressConverter
            = new AddressConverter();

    @Override
    public PersonalInfoDTO convertToDto(final PersonalInfoEntity entity) {
        if (entity == null) {
            return null;
        }
        PersonalInfoDTO personalInfoDTO = new PersonalInfoDTO();
        personalInfoDTO.setHealthCareCardNumber(
                entity.getHealthCareCardNumber());
        personalInfoDTO.setSurname(entity.getSurname());
        personalInfoDTO.setName(entity.getName());
        personalInfoDTO.setBirthDate(entity.getBirthDate());
        personalInfoDTO.setAddressDTO(
                addressConverter.convertToDto(entity.getAddressEntity()));
        personalInfoDTO.setPhone(entity.getPhone());
        personalInfoDTO.setEmail(entity.getEmail());
        personalInfoDTO.setPosition(entity.getPosition());
        personalInfoDTO.setPersonalAccount(entity.getPersonalAccount());
        personalInfoDTO.setPaymentCardNumber(entity.getPaymentCardNumber());
        return personalInfoDTO;
    }

    @Override
    public PersonalInfoEntity convertToEntity(final PersonalInfoDTO dto) {
        if (dto == null) {
            return null;
        }
        PersonalInfoEntity personalInfoEntity = new PersonalInfoEntity();
        personalInfoEntity.setHealthCareCardNumber(
                dto.getHealthCareCardNumber());
        personalInfoEntity.setSurname(dto.getSurname());
        personalInfoEntity.setName(dto.getName());
        personalInfoEntity.setBirthDate(dto.getBirthDate());
        personalInfoEntity.setAddressEntity(
                addressConverter.convertToEntity(dto.getAddressDTO()));
        personalInfoEntity.setPhone(dto.getPhone());
        personalInfoEntity.setEmail(dto.getEmail());
        personalInfoEntity.setPosition(dto.getPosition());
        personalInfoEntity.setPersonalAccount(dto.getPersonalAccount());
        personalInfoEntity.setPaymentCardNumber(dto.getPaymentCardNumber());
        return personalInfoEntity;
    }
}
