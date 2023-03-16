package by.academy.pharmacy.service.mapping.impl;

import by.academy.pharmacy.dto.MedicineDTO;
import by.academy.pharmacy.dto.ProducerDTO;
import by.academy.pharmacy.entity.MedicineEntity;
import by.academy.pharmacy.entity.ProducerEntity;
import by.academy.pharmacy.service.mapping.Converter;

public class MedicineConverter
        implements Converter<MedicineEntity, MedicineDTO> {
    private final Converter<ProducerEntity, ProducerDTO> producerConverter
            = new ProducerConverter();

    @Override
    public MedicineDTO convertToDto(final MedicineEntity entity) {
        if (entity == null) {
            return null;
        }
        MedicineDTO medicineDTO = new MedicineDTO();
        medicineDTO.setId(entity.getId());
        medicineDTO.setTitle(entity.getTitle());
        medicineDTO.setIsNonprescription(entity.isNonprescription());
        medicineDTO.setProducerDTO(
                producerConverter.convertToDto(entity.getProducerEntity()));
        medicineDTO.setApprovalDate(entity.getApprovalDate());
        medicineDTO.setMedicineImagePath(entity.getMedicineImagePath());
        return medicineDTO;
    }

    @Override
    public MedicineEntity convertToEntity(final MedicineDTO dto) {
        if (dto == null) {
            return null;
        }
        MedicineEntity medicineEntity = new MedicineEntity();
        medicineEntity.setId(dto.getId());
        medicineEntity.setTitle(dto.getTitle());
        medicineEntity.setNonprescription(dto.getIsNonprescription());
        medicineEntity.setProducerEntity(
                producerConverter.convertToEntity(dto.getProducerDTO()));
        medicineEntity.setApprovalDate(dto.getApprovalDate());
        medicineEntity.setMedicineImagePath(dto.getMedicineImagePath());
        return medicineEntity;
    }
}
