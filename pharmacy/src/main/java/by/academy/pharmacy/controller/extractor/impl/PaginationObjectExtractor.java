package by.academy.pharmacy.controller.extractor.impl;

import by.academy.pharmacy.controller.extractor.Extractor;
import by.academy.pharmacy.entity.PaginationObject;
import by.academy.pharmacy.service.util.RequestDataUtil;

import javax.servlet.http.HttpServletRequest;

public class PaginationObjectExtractor<E>
        implements Extractor<PaginationObject<E>> {
    private final RequestDataUtil requestDataUtil
            = RequestDataUtil.getInstance();

    @Override
    public PaginationObject<E> extract(final HttpServletRequest request) {
        PaginationObject<E> paginationObject = new PaginationObject<>();
        paginationObject.setRecordsPerPage(
                requestDataUtil.getRecordsPerPage(request));
        paginationObject.setCurrentPage(
                requestDataUtil.getCurrentPage(request));
        return paginationObject;
    }

}
