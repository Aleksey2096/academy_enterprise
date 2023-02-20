package by.academy.task07webAnimal.servlet.command.impl;

import by.academy.task07webAnimal.entity.AnimalDTO;
import by.academy.task07webAnimal.service.db.AnimalDaoService;
import by.academy.task07webAnimal.service.db.impl.AnimalDaoServiceImpl;
import by.academy.task07webAnimal.servlet.command.Command;
import by.academy.task07webAnimal.servlet.extractor.DtoExtractor;
import by.academy.task07webAnimal.servlet.extractor.impl.AnimalDtoExtractor;

import javax.servlet.http.HttpServletRequest;

import static by.academy.task07webAnimal.entity.Constant.INDEX_JSP;

public final class SaveUpdatedAnimalCommand implements Command {
    /**
     * service working with dao layer.
     */
    private final AnimalDaoService animalDaoService
            = new AnimalDaoServiceImpl();
    /**
     * extracts AnimalDTO objects from request.
     */
    private final DtoExtractor<AnimalDTO> dtoExtractor
            = new AnimalDtoExtractor();

    @Override
    public String execute(final HttpServletRequest request) {
        animalDaoService.update(dtoExtractor.extract(request));
        return INDEX_JSP;
    }
}
