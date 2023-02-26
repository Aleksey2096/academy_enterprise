package by.academy.pagination.servlet.command.impl;

import by.academy.pagination.service.database.PersonDaoService;
import by.academy.pagination.service.database.impl.PersonDaoServiceImpl;
import by.academy.pagination.service.util.RequestParameterUtil;
import by.academy.pagination.servlet.command.Command;

import javax.servlet.http.HttpServletRequest;

import static by.academy.pagination.entity.Constant.COMMAND;
import static by.academy.pagination.entity.Constant.JSP_PEOPLE_INDEX_JSP;
import static by.academy.pagination.entity.Constant.PEOPLE;

public class ReadPaginatedPeopleCommand implements Command {
    /**
     * service working with dao layer.
     */
    private final PersonDaoService service = new PersonDaoServiceImpl();

    @Override
    public String execute(final HttpServletRequest request) {
        request.setAttribute(COMMAND, request.getParameter(COMMAND));
        int recordsPerPage = RequestParameterUtil.getRecordsPerPage(request);
        int currentPage = RequestParameterUtil.getCurrentPage(request);
        request.setAttribute(PEOPLE,
                service.readAllWithPagination(recordsPerPage, currentPage));
        return JSP_PEOPLE_INDEX_JSP;
    }
}
