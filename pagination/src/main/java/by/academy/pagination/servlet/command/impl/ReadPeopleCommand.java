package by.academy.pagination.servlet.command.impl;

import by.academy.pagination.entity.PersonDTO;
import by.academy.pagination.service.database.PersonDaoService;
import by.academy.pagination.service.database.impl.PersonDaoServiceImpl;
import by.academy.pagination.servlet.command.Command;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static by.academy.pagination.entity.Constant.JSP_PEOPLE_INDEX_JSP;
import static by.academy.pagination.entity.Constant.PEOPLE;

public final class ReadPeopleCommand implements Command {
    /**
     * service working with dao layer.
     */
    private final PersonDaoService service = new PersonDaoServiceImpl();

    @Override
    public String execute(final HttpServletRequest request) {
        List<PersonDTO> personDTOList = service.readAll();
        request.setAttribute(PEOPLE, personDTOList);
        return JSP_PEOPLE_INDEX_JSP;
    }
}
