package by.academy.task07webAnimal.servlet.command.impl;

import by.academy.task07webAnimal.entity.AnimalDTO;
import by.academy.task07webAnimal.service.db.AnimalDaoService;
import by.academy.task07webAnimal.service.db.impl.AnimalDaoServiceImpl;
import by.academy.task07webAnimal.servlet.command.Command;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static by.academy.task07webAnimal.entity.Constant.ANIMALS;
import static by.academy.task07webAnimal.entity.Constant.JSP_ANIMALS_INDEX_JSP;

public final class ReadAnimalsCommand implements Command {
    /**
     * service working with dao layer.
     */
    private final AnimalDaoService animalDaoService
            = new AnimalDaoServiceImpl();

    @Override
    public String execute(final HttpServletRequest request) {
        List<AnimalDTO> personDTOList = animalDaoService.readAll();
        request.setAttribute(ANIMALS, personDTOList);
        return JSP_ANIMALS_INDEX_JSP;
    }
}
