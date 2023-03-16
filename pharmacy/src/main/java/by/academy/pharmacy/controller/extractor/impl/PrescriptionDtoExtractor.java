package by.academy.pharmacy.controller.extractor.impl;

import by.academy.pharmacy.controller.extractor.Extractor;
import by.academy.pharmacy.dto.PrescriptionDTO;
import by.academy.pharmacy.service.util.RequestDataUtil;

import javax.servlet.http.HttpServletRequest;

import static by.academy.pharmacy.entity.Constant.AMOUNT;
import static by.academy.pharmacy.entity.Constant.DATE;
import static by.academy.pharmacy.entity.Constant.PRESCRIPTION_ID_DB;

public class PrescriptionDtoExtractor implements Extractor<PrescriptionDTO> {
    private final RequestDataUtil requestDataUtil
            = RequestDataUtil.getInstance();

    @Override
    public PrescriptionDTO extract(final HttpServletRequest request) {
        PrescriptionDTO prescriptionDTO = new PrescriptionDTO();
        prescriptionDTO.setId(
                requestDataUtil.getLong(PRESCRIPTION_ID_DB, request));
//		UserDTO userDTO = new UserDTO();
//		userDTO.setHealthCareCardNumber(
//				requestDataUtil.getLong(HEALTH_CARE_CARD_NUMBER_DB, request));
//		prescriptionDTO.setUserDTO(userDTO);
//		MedicineProductDTO medicineProductDTO = new MedicineProductDTO();
//		medicineProductDTO.setId(requestDataUtil.getLong(MEDICINE_PRODUCT_ID_DB, request));
//		prescriptionDTO.setMedicineProductDTO(medicineProductDTO);
        prescriptionDTO.setAmount(requestDataUtil.getInteger(AMOUNT, request));
        prescriptionDTO.setDate(requestDataUtil.getDate(DATE, request));
        return prescriptionDTO;
    }
}
