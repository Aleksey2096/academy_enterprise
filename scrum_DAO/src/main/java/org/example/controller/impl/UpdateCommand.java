package org.example.controller.impl;

import org.example.Person;
import org.example.controller.ServletCommand;
import org.example.dto.PersonDTO;
import org.example.service.PersonDaoService;
import org.example.service.PersonMappingUtils;
import org.example.service.impl.PersonDaoServiceImpl;

import javax.servlet.http.HttpServletRequest;

import static org.example.controller.impl.CreateCommand.GET;
import static org.example.controller.impl.CreateCommand.NAME;
import static org.example.controller.impl.CreateCommand.SURNAME;
import static org.example.controller.impl.DeleteCommand.INDEX_JSP;
import static org.example.controller.impl.DeleteCommand.PERSON_ID;

public final class UpdateCommand implements ServletCommand {
    public static final String PERSON = "person";
    public static final String JSP_PEOPLE_EDIT_JSP = "/jsp/people/edit.jsp";

    @Override
    public String execute(final HttpServletRequest request) {
        PersonDaoService personDaoService = new PersonDaoServiceImpl();
        int id = Integer.parseInt(request.getParameter(PERSON_ID));
        PersonMappingUtils personMappingUtils
                = PersonMappingUtils.getInstance();
        if (request.getMethod().equals(GET)) {
            Person person = personDaoService.readById(id);
            PersonDTO personDTO = personMappingUtils.mapToPersonDTO(person);
            request.setAttribute(PERSON, personDTO);
            return JSP_PEOPLE_EDIT_JSP;
        } else {
            PersonDTO personDTO = PersonDTO.builder().id(id)
                    .name(request.getParameter(NAME))
                    .surname(request.getParameter(SURNAME)).build();
            Person person = personMappingUtils.mapToPerson(personDTO);
            personDaoService.update(person);
            return INDEX_JSP;
        }
    }
}
