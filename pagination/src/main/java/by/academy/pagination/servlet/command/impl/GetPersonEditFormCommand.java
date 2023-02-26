package by.academy.pagination.servlet.command.impl;

import by.academy.pagination.entity.PersonDTO;
import by.academy.pagination.service.database.PersonDaoService;
import by.academy.pagination.service.database.impl.PersonDaoServiceImpl;
import by.academy.pagination.service.util.RequestParameterUtil;
import by.academy.pagination.servlet.command.Command;

import javax.servlet.http.HttpServletRequest;

import static by.academy.pagination.entity.Constant.ID;
import static by.academy.pagination.entity.Constant.JSP_PEOPLE_EDIT_JSP;
import static by.academy.pagination.entity.Constant.PERSON;

/**
 * @author Alexey
 * @version 1.0
 * implements ServletCommand.
 */
public final class GetPersonEditFormCommand implements Command {
    /**
     * service working with dao layer.
     */
    private final PersonDaoService service = new PersonDaoServiceImpl();

    @Override
    public String execute(final HttpServletRequest request) {
        PersonDTO personDTO = service.readById(
                RequestParameterUtil.getInteger(ID, request));
        request.setAttribute(PERSON, personDTO);
        return JSP_PEOPLE_EDIT_JSP;
    }
}
