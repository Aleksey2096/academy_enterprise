package by.academy.task07webAnimal.servlet;

import by.academy.task07webAnimal.service.util.HibernateUtil;
import by.academy.task07webAnimal.servlet.command.Command;
import by.academy.task07webAnimal.servlet.command.CommandFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

import static by.academy.task07webAnimal.entity.Constant.COM_MYSQL_CJ_JDBC_DRIVER;

/**
 * @author Alexey
 * @version 1.0
 * extends HttpServlet.
 */
public final class DispatcherServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        try {
            Class.forName(COM_MYSQL_CJ_JDBC_DRIVER);
        } catch (ClassNotFoundException newE) {
            throw new ServletException(newE);
        }
    }

    @Override
    protected void doGet(final HttpServletRequest request,
                         final HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(final HttpServletRequest request,
                          final HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * processRequest.
     *
     * @param req  http request from the client
     * @param resp http response to the client
     * @throws ServletException exception
     * @throws IOException      exception
     */
    private void processRequest(final HttpServletRequest req,
                                final HttpServletResponse resp)
            throws ServletException, IOException {
        Command command = CommandFactory.getInstance().defineCommand(req);
        String page = Objects.requireNonNull(command).execute(req);
        getServletContext().getRequestDispatcher(page).forward(req, resp);
    }

    @Override
    public void destroy() {
        HibernateUtil.close();
    }
}
