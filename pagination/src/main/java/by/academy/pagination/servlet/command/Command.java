package by.academy.pagination.servlet.command;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Alexey.
 * @version 1.0.
 * interface Command.
 */
public interface Command {
    /**
     * @param request http request from client.
     * @return path to jsp page.
     */
    String execute(HttpServletRequest request);
}
