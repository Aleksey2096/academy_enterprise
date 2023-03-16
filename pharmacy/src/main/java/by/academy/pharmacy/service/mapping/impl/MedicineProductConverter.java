package by.academy.pharmacy.service.mapping.impl;

import by.academy.pharmacy.dto.MedicineDTO;
import by.academy.pharmacy.dto.MedicineProductDTO;
import by.academy.pharmacy.entity.MedicineEntity;
import by.academy.pharmacy.entity.MedicineProductEntity;
import by.academy.pharmacy.service.mapping.Converter;

public class MedicineProductConverter
        implements Converter<MedicineProductEntity, MedicineProductDTO> {
    private final Converter<MedicineEntity, MedicineDTO> medicineConverter
            = new MedicineConverter();

    @Override
    public MedicineProductDTO convertToDto(final MedicineProductEntity entity) {
        if (entity == null) {
            return null;
        }
        MedicineProductDTO medicineProductDTO = new MedicineProductDTO();
        medicineProductDTO.setId(entity.getId());
        medicineProductDTO
                .setMedicineDTO(medicineConverter.convertToDto(
                        entity.getMedicineEntity()));
        medicineProductDTO.setDosage(entity.getDosage());
        medicineProductDTO.setForm(entity.getForm());
        medicineProductDTO.setPrice(entity.getPrice());
        medicineProductDTO.setAmount(entity.getAmount());
        return medicineProductDTO;
    }

    @Override
    public MedicineProductEntity convertToEntity(final MedicineProductDTO dto) {
        if (dto == null) {
            return null;
        }
        MedicineProductEntity medicineProductEntity
                = new MedicineProductEntity();
        medicineProductEntity.setId(dto.getId());
        medicineProductEntity
                .setMedicineEntity(medicineConverter.convertToEntity(
                        dto.getMedicineDTO()));
        medicineProductEntity.setDosage(dto.getDosage());
        medicineProductEntity.setForm(dto.getForm());
        medicineProductEntity.setPrice(dto.getPrice());
        medicineProductEntity.setAmount(dto.getAmount());
        return medicineProductEntity;
    }
}
