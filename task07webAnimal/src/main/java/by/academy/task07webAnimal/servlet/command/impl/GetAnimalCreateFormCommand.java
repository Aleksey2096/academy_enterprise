package by.academy.task07webAnimal.servlet.command.impl;

import by.academy.task07webAnimal.servlet.command.Command;

import javax.servlet.http.HttpServletRequest;

import static by.academy.task07webAnimal.entity.Constant.JSP_ANIMALS_NEW_JSP;

/**
 * @author Alexey
 * @version 1.0
 * implements ServletCommand.
 */
public final class GetAnimalCreateFormCommand implements Command {
    @Override
    public String execute(final HttpServletRequest request) {
        return JSP_ANIMALS_NEW_JSP;
    }
}
