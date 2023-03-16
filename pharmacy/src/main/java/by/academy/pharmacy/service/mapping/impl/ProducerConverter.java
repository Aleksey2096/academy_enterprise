package by.academy.pharmacy.service.mapping.impl;

import by.academy.pharmacy.dto.ProducerDTO;
import by.academy.pharmacy.entity.ProducerEntity;
import by.academy.pharmacy.service.mapping.Converter;

public class ProducerConverter
        implements Converter<ProducerEntity, ProducerDTO> {
    @Override
    public ProducerDTO convertToDto(final ProducerEntity entity) {
        if (entity == null) {
            return null;
        }
        ProducerDTO producerDTO = new ProducerDTO();
        producerDTO.setId(entity.getId());
        producerDTO.setCompanyName(entity.getCompanyName());
        producerDTO.setCountry(entity.getCountry());
        producerDTO.setCreationDate(entity.getCreationDate());
        return producerDTO;
    }

    @Override
    public ProducerEntity convertToEntity(final ProducerDTO dto) {
        if (dto == null) {
            return null;
        }
        ProducerEntity producerEntity = new ProducerEntity();
        producerEntity.setId(dto.getId());
        producerEntity.setCompanyName(dto.getCompanyName());
        producerEntity.setCountry(dto.getCountry());
        producerEntity.setCreationDate(dto.getCreationDate());
        return producerEntity;
    }
}
