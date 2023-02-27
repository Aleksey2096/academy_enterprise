package by.academy.pagination.servlet.command.impl;

import by.academy.pagination.entity.PaginationObject;
import by.academy.pagination.entity.Person;
import by.academy.pagination.entity.PersonDTO;
import by.academy.pagination.service.database.PersonDaoService;
import by.academy.pagination.service.database.impl.PersonDaoServiceImpl;
import by.academy.pagination.service.util.RequestParameterUtil;
import by.academy.pagination.servlet.command.Command;
import by.academy.pagination.servlet.extractor.Extractor;
import by.academy.pagination.servlet.extractor.impl.PaginationObjectExtractor;
import by.academy.pagination.servlet.extractor.impl.PersonDtoExtractor;

import javax.servlet.http.HttpServletRequest;

import static by.academy.pagination.entity.Constant.COMMAND;
import static by.academy.pagination.entity.Constant.JSP_PEOPLE_INDEX_JSP;
import static by.academy.pagination.entity.Constant.PEOPLE;

public final class ReadPaginatedPeopleCommand implements Command {
    /**
     * service working with dao layer.
     */
    private final PersonDaoService service = new PersonDaoServiceImpl();
    /**
     * extracts PersonDTO objects from request.
     */
    private final Extractor<PaginationObject<Person>> extractor
            = new PaginationObjectExtractor();

    @Override
    public String execute(final HttpServletRequest request) {
        request.setAttribute(COMMAND, request.getParameter(COMMAND));
        PaginationObject<Person> paginationObject = extractor.extract(request);
        request.setAttribute(PEOPLE,
                service.readAllWithPagination(paginationObject));
        return JSP_PEOPLE_INDEX_JSP;
    }
}
