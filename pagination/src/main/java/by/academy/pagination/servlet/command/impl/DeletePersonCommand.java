package by.academy.pagination.servlet.command.impl;

import by.academy.pagination.service.database.PersonDaoService;
import by.academy.pagination.service.database.impl.PersonDaoServiceImpl;
import by.academy.pagination.service.util.RequestParameterUtil;
import by.academy.pagination.servlet.command.Command;

import javax.servlet.http.HttpServletRequest;

import static by.academy.pagination.entity.Constant.ID;
import static by.academy.pagination.entity.Constant.INDEX_JSP;

public final class DeletePersonCommand implements Command {
    /**
     * service working with dao layer.
     */
    private final PersonDaoService service = new PersonDaoServiceImpl();

    @Override
    public String execute(final HttpServletRequest request) {
        service.deleteById(RequestParameterUtil.getInteger(ID, request));
        return INDEX_JSP;
    }
}
