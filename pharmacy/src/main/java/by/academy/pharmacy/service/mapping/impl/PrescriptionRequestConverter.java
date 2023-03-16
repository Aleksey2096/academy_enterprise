package by.academy.pharmacy.service.mapping.impl;

import by.academy.pharmacy.dto.PrescriptionRequestDTO;
import by.academy.pharmacy.dto.UserDTO;
import by.academy.pharmacy.entity.PrescriptionRequestEntity;
import by.academy.pharmacy.entity.UserEntity;
import by.academy.pharmacy.service.mapping.Converter;

public class PrescriptionRequestConverter
        implements
        Converter<PrescriptionRequestEntity, PrescriptionRequestDTO> {
    private final Converter<UserEntity, UserDTO> userConverter
            = new UserConverter();

    @Override
    public PrescriptionRequestDTO convertToDto(
            final PrescriptionRequestEntity entity) {
        if (entity == null) {
            return null;
        }
        PrescriptionRequestDTO prescriptionRequestDTO
                = new PrescriptionRequestDTO();
        prescriptionRequestDTO.setId(entity.getId());
        prescriptionRequestDTO.setPrescriptionScanPath(
                entity.getPrescriptionScanPath());
        prescriptionRequestDTO.setUploadDateTime(entity.getUploadDateTime());
        prescriptionRequestDTO.setPrescriptionRequestStatus(
                entity.getPrescriptionRequestStatus());
        prescriptionRequestDTO.setUserDTO(
                userConverter.convertToDto(entity.getUserEntity()));
        return prescriptionRequestDTO;
    }

    @Override
    public PrescriptionRequestEntity convertToEntity(
            final PrescriptionRequestDTO dto) {
        if (dto == null) {
            return null;
        }
        PrescriptionRequestEntity prescriptionRequestEntity
                = new PrescriptionRequestEntity();
        prescriptionRequestEntity.setId(dto.getId());
        prescriptionRequestEntity.setPrescriptionScanPath(
                dto.getPrescriptionScanPath());
        prescriptionRequestEntity.setUploadDateTime(dto.getUploadDateTime());
        prescriptionRequestEntity.setPrescriptionRequestStatus(
                dto.getPrescriptionRequestStatus());
        prescriptionRequestEntity.setUserEntity(
                userConverter.convertToEntity(dto.getUserDTO()));
        return prescriptionRequestEntity;
    }
}
