package by.academy.pharmacy.controller.extractor.impl;

import by.academy.pharmacy.controller.extractor.Extractor;
import by.academy.pharmacy.dto.ProducerDTO;
import by.academy.pharmacy.service.util.RequestDataUtil;

import javax.servlet.http.HttpServletRequest;

import static by.academy.pharmacy.entity.Constant.COMPANY_NAME;
import static by.academy.pharmacy.entity.Constant.COUNTRY;
import static by.academy.pharmacy.entity.Constant.CREATION_DATE;
import static by.academy.pharmacy.entity.Constant.PRODUCER_ID_DB;

public class ProducerDtoExtractor implements Extractor<ProducerDTO> {
    private final RequestDataUtil requestDataUtil
            = RequestDataUtil.getInstance();

    @Override
    public ProducerDTO extract(final HttpServletRequest request) {
        ProducerDTO producerDTO = new ProducerDTO();
        producerDTO.setId(requestDataUtil.getLong(PRODUCER_ID_DB, request));
        producerDTO.setCompanyName(
                requestDataUtil.getString(COMPANY_NAME, request));
        producerDTO.setCountry(requestDataUtil.getCountry(COUNTRY, request));
        producerDTO.setCreationDate(
                requestDataUtil.getDate(CREATION_DATE, request));
        return producerDTO;
    }
}
