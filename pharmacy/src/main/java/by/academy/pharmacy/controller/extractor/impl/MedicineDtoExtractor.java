package by.academy.pharmacy.controller.extractor.impl;

import by.academy.pharmacy.controller.extractor.Extractor;
import by.academy.pharmacy.dto.MedicineDTO;
import by.academy.pharmacy.service.util.RequestDataUtil;

import javax.servlet.http.HttpServletRequest;

import static by.academy.pharmacy.entity.Constant.APPROVAL_DATE_DB;
import static by.academy.pharmacy.entity.Constant.EMPTY_PATH;
import static by.academy.pharmacy.entity.Constant.IMAGE;
import static by.academy.pharmacy.entity.Constant.IMG_MEDICINE;
import static by.academy.pharmacy.entity.Constant.IS_NONPRESCRIPTION_DB;
import static by.academy.pharmacy.entity.Constant.JPG;
import static by.academy.pharmacy.entity.Constant.MEDICINE_ID_DB;
import static by.academy.pharmacy.entity.Constant.TITLE;

public class MedicineDtoExtractor implements Extractor<MedicineDTO> {
	private final RequestDataUtil requestDataUtil
			= RequestDataUtil.getInstance();

	@Override
	public MedicineDTO extract(final HttpServletRequest request) {
		MedicineDTO medicineDTO = new MedicineDTO();
		medicineDTO.setId(requestDataUtil.getLong(MEDICINE_ID_DB, request));
		medicineDTO.setTitle(requestDataUtil.getString(TITLE, request));
		medicineDTO
				.setIsNonprescription(
						requestDataUtil.getDBoolean(IS_NONPRESCRIPTION_DB,
								request));
//		ProducerDTO producerDTO = new ProducerDTO();
//		producerDTO.setId(requestDataUtil.getLong(PRODUCER_ID_DB, request));
//		medicineDTO.setProducerDTO(producerDTO);
		medicineDTO.setApprovalDate(
				requestDataUtil.getDate(APPROVAL_DATE_DB, request));
		String medicineImagePath = IMG_MEDICINE + medicineDTO.getTitle() + JPG;
		medicineDTO.setMedicineImagePath(medicineImagePath);
		requestDataUtil.saveFile(
				request.getServletContext().getRealPath(EMPTY_PATH)
						+ medicineImagePath, request, IMAGE);
		return medicineDTO;
	}

}
