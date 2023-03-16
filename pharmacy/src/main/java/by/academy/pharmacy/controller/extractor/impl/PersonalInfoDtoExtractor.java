package by.academy.pharmacy.controller.extractor.impl;

import by.academy.pharmacy.controller.extractor.Extractor;
import by.academy.pharmacy.dto.PersonalInfoDTO;
import by.academy.pharmacy.service.util.RequestDataUtil;

import javax.servlet.http.HttpServletRequest;

import static by.academy.pharmacy.entity.Constant.DATE_OF_BIRTH_DB;
import static by.academy.pharmacy.entity.Constant.EMAIL;
import static by.academy.pharmacy.entity.Constant.HEALTH_CARE_CARD_NUMBER_DB;
import static by.academy.pharmacy.entity.Constant.NAME;
import static by.academy.pharmacy.entity.Constant.PAYMENT_CARD_NUMBER_DB;
import static by.academy.pharmacy.entity.Constant.PERSONAL_ACCOUNT_DB;
import static by.academy.pharmacy.entity.Constant.PHONE;
import static by.academy.pharmacy.entity.Constant.POSITION;
import static by.academy.pharmacy.entity.Constant.SURNAME;

public class PersonalInfoDtoExtractor implements Extractor<PersonalInfoDTO> {
    private final RequestDataUtil requestDataUtil
            = RequestDataUtil.getInstance();

    @Override
    public PersonalInfoDTO extract(final HttpServletRequest request) {
        PersonalInfoDTO personalInfoDTO = new PersonalInfoDTO();
        personalInfoDTO.setHealthCareCardNumber(
                requestDataUtil.getLong(HEALTH_CARE_CARD_NUMBER_DB, request));
        personalInfoDTO.setSurname(requestDataUtil.getString(SURNAME, request));
        personalInfoDTO.setName(requestDataUtil.getString(NAME, request));
        personalInfoDTO.setBirthDate(
                requestDataUtil.getDate(DATE_OF_BIRTH_DB, request));
        personalInfoDTO.setPhone(requestDataUtil.getString(PHONE, request));
        personalInfoDTO.setEmail(requestDataUtil.getString(EMAIL, request));
        personalInfoDTO.setPosition(
                requestDataUtil.getString(POSITION, request));
        personalInfoDTO
                .setPersonalAccount(
                        requestDataUtil.getBigDecimal(PERSONAL_ACCOUNT_DB,
                                request));
        personalInfoDTO
                .setPaymentCardNumber(
                        requestDataUtil.getLong(PAYMENT_CARD_NUMBER_DB,
                                request));
        return personalInfoDTO;
    }
}
