package by.academy.pharmacy.controller.extractor.impl;

import by.academy.pharmacy.controller.extractor.Extractor;
import by.academy.pharmacy.dto.PrescriptionRequestDTO;
import by.academy.pharmacy.entity.PrescriptionRequestStatus;
import by.academy.pharmacy.service.util.RequestDataUtil;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

import static by.academy.pharmacy.entity.Constant.IMAGE;
import static by.academy.pharmacy.entity.Constant.IMG_PRESCRIPTION_SCAN;
import static by.academy.pharmacy.entity.Constant.JPG;
import static by.academy.pharmacy.entity.Constant.PRESCRIPTION_REQUEST_ID_DB;

public class PrescriptionRequestDtoExtractor
        implements Extractor<PrescriptionRequestDTO> {
    private final RequestDataUtil requestDataUtil
            = RequestDataUtil.getInstance();

    @Override
    public PrescriptionRequestDTO extract(final HttpServletRequest request) {
        PrescriptionRequestDTO prescriptionRequestDTO
                = new PrescriptionRequestDTO();
        prescriptionRequestDTO.setId(
                requestDataUtil.getLong(PRESCRIPTION_REQUEST_ID_DB, request));
        String prescriptionScanPath = IMG_PRESCRIPTION_SCAN
                + prescriptionRequestDTO.getId() + JPG;
        prescriptionRequestDTO.setPrescriptionScanPath(prescriptionScanPath);
        requestDataUtil.saveFile(request.getServletContext().getRealPath("")
                        + prescriptionScanPath,
                request, IMAGE);
        prescriptionRequestDTO.setUploadDateTime(LocalDateTime.now());
        prescriptionRequestDTO.setPrescriptionRequestStatus(
                PrescriptionRequestStatus.UNPROCESSED);
        return prescriptionRequestDTO;
    }
}
