package by.academy.pharmacy.controller.extractor.impl;

import by.academy.pharmacy.controller.extractor.Extractor;
import by.academy.pharmacy.dto.AddressDTO;
import by.academy.pharmacy.service.util.RequestDataUtil;

import javax.servlet.http.HttpServletRequest;

import static by.academy.pharmacy.entity.Constant.APARTMENT;
import static by.academy.pharmacy.entity.Constant.CITY;
import static by.academy.pharmacy.entity.Constant.HEALTH_CARE_CARD_NUMBER_DB;
import static by.academy.pharmacy.entity.Constant.HOUSE;
import static by.academy.pharmacy.entity.Constant.POSTCODE;
import static by.academy.pharmacy.entity.Constant.STREET;

public class AddressDtoExtractor implements Extractor<AddressDTO> {
	private final RequestDataUtil requestDataUtil
			= RequestDataUtil.getInstance();

	@Override
	public AddressDTO extract(final HttpServletRequest request) {
		AddressDTO addressDTO = new AddressDTO();
		addressDTO.setHealthCareCardNumber(
				requestDataUtil.getLong(HEALTH_CARE_CARD_NUMBER_DB, request));
		addressDTO.setPostcode(requestDataUtil.getInteger(POSTCODE, request));
		addressDTO.setCity(requestDataUtil.getString(CITY, request));
		addressDTO.setStreet(requestDataUtil.getString(STREET, request));
		addressDTO.setHouse(requestDataUtil.getInteger(HOUSE, request));
		addressDTO.setApartment(requestDataUtil.getInteger(APARTMENT, request));
		return addressDTO;
	}
}
