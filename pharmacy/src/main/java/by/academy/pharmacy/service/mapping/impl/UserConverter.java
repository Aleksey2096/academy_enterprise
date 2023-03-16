package by.academy.pharmacy.service.mapping.impl;

import by.academy.pharmacy.dto.MedicineProductDTO;
import by.academy.pharmacy.dto.PersonalInfoDTO;
import by.academy.pharmacy.dto.UserDTO;
import by.academy.pharmacy.entity.MedicineProductEntity;
import by.academy.pharmacy.entity.PersonalInfoEntity;
import by.academy.pharmacy.entity.UserEntity;
import by.academy.pharmacy.service.mapping.Converter;

public class UserConverter implements Converter<UserEntity, UserDTO> {
    private final Converter<PersonalInfoEntity, PersonalInfoDTO>
            personalInfoConverter = new PersonalInfoConverter();
    private final Converter<MedicineProductEntity, MedicineProductDTO>
            medicineProductConverter = new MedicineProductConverter();
//	private final Converter<PrescriptionEntity, PrescriptionDTO> prescriptionConverter = new PrescriptionConverter();
//	private final Converter<OrderEntity, OrderDTO> orderConverter = new OrderConverter();
//	private final Converter<PrescriptionRequestEntity, PrescriptionRequestDTO> prescriptionRequestConverter = new PrescriptionRequestConverter();

    @Override
    public UserDTO convertToDto(final UserEntity entity) {
        if (entity == null) {
            return null;
        }
        UserDTO userDTO = new UserDTO();
        userDTO.setHealthCareCardNumber(entity.getHealthCareCardNumber());
        userDTO.setLogin(entity.getLogin());
        userDTO.setPassword(entity.getPassword());
        userDTO.setRole(entity.getRole());
        userDTO.setJoinedDate(entity.getJoinedDate());
        userDTO.setPersonalInfoDTO(
                personalInfoConverter.convertToDto(
                        entity.getPersonalInfoEntity()));
        userDTO.setAvatarImagePath(entity.getAvatarImagePath());
        userDTO.setCart(medicineProductConverter.convertToDtoCollection(
                entity.getCart()));
//		userDTO.setPrescriptionDTOs(
//				prescriptionConverter.convertToDtoCollection(entity.getPrescriptionEntities()));
//		userDTO.setOrderDTOs(orderConverter.convertToDtoCollection(entity.getOrderEntities()));
//		userDTO.setPrescriptionRequestDTOs(prescriptionRequestConverter
//				.convertToDtoCollection(entity.getPrescriptionRequestEntities()));
        return userDTO;
    }

    @Override
    public UserEntity convertToEntity(final UserDTO dto) {
        if (dto == null) {
            return null;
        }
        UserEntity userEntity = new UserEntity();
        userEntity.setHealthCareCardNumber(dto.getHealthCareCardNumber());
        userEntity.setLogin(dto.getLogin());
        userEntity.setPassword(dto.getPassword());
        userEntity.setRole(dto.getRole());
        userEntity.setJoinedDate(dto.getJoinedDate());
        userEntity.setPersonalInfoEntity(
                personalInfoConverter.convertToEntity(
                        dto.getPersonalInfoDTO()));
        userEntity.setAvatarImagePath(dto.getAvatarImagePath());
        userEntity.setCart(
                medicineProductConverter.convertToEntities(dto.getCart()));
//		userEntity.setPrescriptionEntities(
//				prescriptionConverter.convertToEntities(dto.getPrescriptionDTOs()));
//		userEntity.setOrderEntities(orderConverter.convertToEntities(dto.getOrderDTOs()));
//		userEntity.setPrescriptionRequestEntities(
//				prescriptionRequestConverter.convertToEntities(dto.getPrescriptionRequestDTOs()));
        return userEntity;
    }
}
