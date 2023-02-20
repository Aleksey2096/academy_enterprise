package by.academy.task07webAnimal.servlet.command.impl;

import by.academy.task07webAnimal.entity.AnimalDTO;
import by.academy.task07webAnimal.service.db.AnimalDaoService;
import by.academy.task07webAnimal.service.db.impl.AnimalDaoServiceImpl;
import by.academy.task07webAnimal.servlet.command.Command;

import javax.servlet.http.HttpServletRequest;

import static by.academy.task07webAnimal.entity.Constant.ANIMAL;
import static by.academy.task07webAnimal.entity.Constant.ID;
import static by.academy.task07webAnimal.entity.Constant.JSP_ANIMALS_EDIT_JSP;

/**
 * @author Alexey
 * @version 1.0
 * implements ServletCommand.
 */
public final class GetAnimalEditFormCommand implements Command {
    /**
     * service working with dao layer.
     */
    private final AnimalDaoService animalDaoService
            = new AnimalDaoServiceImpl();

    @Override
    public String execute(final HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter(ID));
        AnimalDTO animalDTO = animalDaoService.readById(id);
        request.setAttribute(ANIMAL, animalDTO);
        return JSP_ANIMALS_EDIT_JSP;
    }
}
