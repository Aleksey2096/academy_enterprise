package by.academy.pagination.servlet.command.impl;

import by.academy.pagination.entity.PersonDTO;
import by.academy.pagination.service.database.PersonDaoService;
import by.academy.pagination.service.database.impl.PersonDaoServiceImpl;
import by.academy.pagination.servlet.command.Command;
import by.academy.pagination.servlet.extractor.Extractor;
import by.academy.pagination.servlet.extractor.impl.PersonDtoExtractor;

import javax.servlet.http.HttpServletRequest;

import static by.academy.pagination.entity.Constant.INDEX_JSP;

public final class SaveUpdatedPersonCommand implements Command {
    /**
     * service working with dao layer.
     */
    private final PersonDaoService service = new PersonDaoServiceImpl();
    /**
     * extracts AnimalDTO objects from request.
     */
    private final Extractor<PersonDTO> dtoExtractor
            = new PersonDtoExtractor();

    @Override
    public String execute(final HttpServletRequest request) {
        service.update(dtoExtractor.extract(request));
        return INDEX_JSP;
    }
}
