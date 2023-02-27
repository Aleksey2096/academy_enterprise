package by.academy.pagination.servlet.extractor.impl;

import by.academy.pagination.entity.PaginationObject;
import by.academy.pagination.entity.Person;
import by.academy.pagination.service.util.RequestParameterUtil;
import by.academy.pagination.servlet.extractor.Extractor;

import javax.servlet.http.HttpServletRequest;

import static by.academy.pagination.entity.Constant.ORDER_FIELD;

public final class PaginationObjectExtractor
        implements Extractor<PaginationObject<Person>> {

    @Override
    public PaginationObject<Person> extract(final HttpServletRequest request) {
        return PaginationObject.<Person>builder()
                .recordsPerPage(RequestParameterUtil.getRecordsPerPage(request))
                .currentPage(RequestParameterUtil.getCurrentPage(request))
                .orderField(RequestParameterUtil.getPersonOrderField(request))
                .orderType(RequestParameterUtil.getOrderType(request))
                .build();
    }
}
