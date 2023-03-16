package by.academy.pharmacy.service.mapping.impl;

import by.academy.pharmacy.dto.MedicineProductDTO;
import by.academy.pharmacy.dto.PrescriptionDTO;
import by.academy.pharmacy.dto.UserDTO;
import by.academy.pharmacy.entity.MedicineProductEntity;
import by.academy.pharmacy.entity.PrescriptionEntity;
import by.academy.pharmacy.entity.UserEntity;
import by.academy.pharmacy.service.mapping.Converter;

public class PrescriptionConverter
        implements Converter<PrescriptionEntity, PrescriptionDTO> {
    private final Converter<UserEntity, UserDTO> userConverter
            = new UserConverter();
    private final Converter<MedicineProductEntity, MedicineProductDTO>
            medicineProductConverter = new MedicineProductConverter();

    @Override
    public PrescriptionDTO convertToDto(final PrescriptionEntity entity) {
        if (entity == null) {
            return null;
        }
        PrescriptionDTO prescriptionDTO = new PrescriptionDTO();
        prescriptionDTO.setId(entity.getId());
        prescriptionDTO.setUserDTO(
                userConverter.convertToDto(entity.getUserEntity()));
        prescriptionDTO.setMedicineProductDTO(
                medicineProductConverter.convertToDto(
                        entity.getMedicineProductEntity()));
        prescriptionDTO.setAmount(entity.getAmount());
        prescriptionDTO.setDate(entity.getDate());
        return prescriptionDTO;
    }

    @Override
    public PrescriptionEntity convertToEntity(final PrescriptionDTO dto) {
        if (dto == null) {
            return null;
        }
        PrescriptionEntity prescriptionEntity = new PrescriptionEntity();
        prescriptionEntity.setId(dto.getId());
        prescriptionEntity.setUserEntity(
                userConverter.convertToEntity(dto.getUserDTO()));
        prescriptionEntity.setMedicineProductEntity(
                medicineProductConverter.convertToEntity(
                        dto.getMedicineProductDTO()));
        prescriptionEntity.setAmount(dto.getAmount());
        prescriptionEntity.setDate(dto.getDate());
        return prescriptionEntity;
    }
}
