package org.example.controller.impl;

import org.example.Person;
import org.example.controller.ServletCommand;
import org.example.dto.PersonDTO;
import org.example.service.PersonDaoService;
import org.example.service.PersonMappingUtils;
import org.example.service.impl.PersonDaoServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

public final class ReadCommand implements ServletCommand {
    public static final String PEOPLE = "people";
    public static final String JSP_PEOPLE_INDEX_JSP = "/jsp/people/index.jsp";

    @Override
    public String execute(final HttpServletRequest request) {
        PersonDaoService personDaoService = new PersonDaoServiceImpl();
        List<Person> people = personDaoService.readAll();
        PersonMappingUtils personMappingUtils
                = PersonMappingUtils.getInstance();
        List<PersonDTO> personDTOList = people.stream()
                .map(personMappingUtils::mapToPersonDTO)
                .collect(Collectors.toList());
        request.setAttribute(PEOPLE, personDTOList);
        return JSP_PEOPLE_INDEX_JSP;
    }
}
