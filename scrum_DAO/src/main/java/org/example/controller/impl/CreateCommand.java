package org.example.controller.impl;

import org.example.Person;
import org.example.controller.ServletCommand;
import org.example.dto.PersonDTO;
import org.example.service.DaoService;
import org.example.service.PersonMappingUtils;
import org.example.service.impl.PersonDaoServiceImpl;

import javax.servlet.http.HttpServletRequest;

import static org.example.controller.impl.DeleteCommand.INDEX_JSP;

public final class CreateCommand implements ServletCommand {
    public static final String JSP_PEOPLE_NEW_JSP = "/jsp/people/new.jsp";
    public static final String GET = "GET";
    public static final String NAME = "name";
    public static final String SURNAME = "surname";

    @Override
    public String execute(final HttpServletRequest request) {
        DaoService daoService = new PersonDaoServiceImpl();
        PersonMappingUtils personMappingUtils
                = PersonMappingUtils.getInstance();
        if (request.getMethod().equals(GET)) {
            return JSP_PEOPLE_NEW_JSP;
        } else {
            PersonDTO personDTO = PersonDTO.builder()
                    .name(request.getParameter(NAME))
                    .surname(request.getParameter(SURNAME)).build();
            Person person = personMappingUtils.mapToPerson(personDTO);
            daoService.create(person);
            return INDEX_JSP;
        }
    }
}
