package by.academy.task07webAnimal.servlet.command.impl;

import by.academy.task07webAnimal.service.db.AnimalDaoService;
import by.academy.task07webAnimal.service.db.impl.AnimalDaoServiceImpl;
import by.academy.task07webAnimal.servlet.command.Command;

import javax.servlet.http.HttpServletRequest;

import static by.academy.task07webAnimal.entity.Constant.ID;
import static by.academy.task07webAnimal.entity.Constant.INDEX_JSP;

public final class DeleteAnimalCommand implements Command {
    /**
     * service working with dao layer.
     */
    private final AnimalDaoService animalDaoService
            = new AnimalDaoServiceImpl();

    @Override
    public String execute(final HttpServletRequest request) {
        animalDaoService.deleteById(Integer.valueOf(request.getParameter(ID)));
        return INDEX_JSP;
    }
}
