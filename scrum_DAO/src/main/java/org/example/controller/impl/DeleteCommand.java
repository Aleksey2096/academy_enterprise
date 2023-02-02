package org.example.controller.impl;

import org.example.Person;
import org.example.controller.ServletCommand;
import org.example.service.DaoService;
import org.example.service.impl.PersonDaoServiceImpl;

import javax.servlet.http.HttpServletRequest;

public final class DeleteCommand implements ServletCommand {
    public static final String PERSON_ID = "personId";
    public static final String INDEX_JSP = "/index.jsp";

    @Override
    public String execute(final HttpServletRequest request) {
        DaoService daoService = new PersonDaoServiceImpl();
        daoService.delete(new Person(Integer.parseInt(
                request.getParameter(PERSON_ID)), null, null));
        return INDEX_JSP;
    }
}
