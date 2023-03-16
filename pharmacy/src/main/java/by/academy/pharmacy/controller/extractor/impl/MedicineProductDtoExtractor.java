package by.academy.pharmacy.controller.extractor.impl;

import by.academy.pharmacy.controller.extractor.Extractor;
import by.academy.pharmacy.dto.MedicineProductDTO;
import by.academy.pharmacy.service.util.RequestDataUtil;

import javax.servlet.http.HttpServletRequest;

import static by.academy.pharmacy.entity.Constant.AMOUNT;
import static by.academy.pharmacy.entity.Constant.DOSAGE;
import static by.academy.pharmacy.entity.Constant.FORM;
import static by.academy.pharmacy.entity.Constant.MEDICINE_PRODUCT_ID_DB;
import static by.academy.pharmacy.entity.Constant.PRICE;

public class MedicineProductDtoExtractor
		implements Extractor<MedicineProductDTO> {
	private final RequestDataUtil requestDataUtil
			= RequestDataUtil.getInstance();

	@Override
	public MedicineProductDTO extract(final HttpServletRequest request) {
		MedicineProductDTO medicineProductDTO = new MedicineProductDTO();
		medicineProductDTO.setId(
				requestDataUtil.getLong(MEDICINE_PRODUCT_ID_DB, request));
//		MedicineDTO medicineDTO = new MedicineDTO();
//		medicineDTO.setId(requestDataUtil.getLong(MEDICINE_ID_DB, request));
//		medicineProductDTO.setMedicineDTO(medicineDTO);
		medicineProductDTO.setDosage(requestDataUtil.getShort(DOSAGE, request));
		medicineProductDTO.setForm(requestDataUtil.getForm(FORM, request));
		medicineProductDTO.setPrice(
				requestDataUtil.getBigDecimal(PRICE, request));
		medicineProductDTO.setAmount(
				requestDataUtil.getInteger(AMOUNT, request));
		return medicineProductDTO;
	}
}
