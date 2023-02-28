package by.academy.pagination.servlet.extractor.impl;

import by.academy.pagination.entity.PersonDTO;
import by.academy.pagination.service.util.RequestParameterUtil;
import by.academy.pagination.servlet.extractor.Extractor;

import javax.servlet.http.HttpServletRequest;

import static by.academy.pagination.entity.Constant.ID;
import static by.academy.pagination.entity.Constant.NAME;
import static by.academy.pagination.entity.Constant.SURNAME;

/**
 * extracts PersonDTO objects from request.
 */
public final class PersonDtoExtractor implements Extractor<PersonDTO> {
    @Override
    public PersonDTO extract(final HttpServletRequest request) {
        return PersonDTO.builder()
                .id(RequestParameterUtil.getInteger(ID, request))
                .name(request.getParameter(NAME))
                .surname(request.getParameter(SURNAME)).build();
    }
}
