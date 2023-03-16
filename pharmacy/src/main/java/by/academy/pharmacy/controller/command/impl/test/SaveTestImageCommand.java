package by.academy.pharmacy.controller.command.impl.test;

import by.academy.pharmacy.controller.command.Command;
import by.academy.pharmacy.service.util.RequestDataUtil;

import javax.servlet.http.HttpServletRequest;

import static by.academy.pharmacy.entity.Constant.IMAGE;
import static by.academy.pharmacy.entity.Constant.INDEX_JSP;

;

public class SaveTestImageCommand implements Command {

    @Override
    public String execute(final HttpServletRequest request) {
        String path = request.getServletContext().getRealPath("") + "/img/"
                + 100000000000000L
                + ".jpg";

        RequestDataUtil.getInstance().saveFile(path, request, IMAGE);

        request.setAttribute("photoPath", "/img/100000000000000.jpg");

        return INDEX_JSP;
    }
}
