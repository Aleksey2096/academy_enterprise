package by.academy.pagination.servlet.command.impl;

import by.academy.pagination.servlet.command.Command;

import javax.servlet.http.HttpServletRequest;

import static by.academy.pagination.entity.Constant.JSP_PEOPLE_NEW_JSP;

/**
 * @author Alexey
 * @version 1.0
 * implements ServletCommand.
 */
public final class GetPersonCreateFormCommand implements Command {
    @Override
    public String execute(final HttpServletRequest request) {
        return JSP_PEOPLE_NEW_JSP;
    }
}
