package org.example.controller;

import javax.servlet.http.HttpServletRequest;

public final class CommandFactory {
    private static final CommandFactory COMMAND_FACTORY = new CommandFactory();
    private static final String COMMAND = "command";

    private CommandFactory() {
    }

    public static CommandFactory getInstance() {
        return COMMAND_FACTORY;
    }

    public ServletCommand defineCommand(final HttpServletRequest request) {
        String action = request.getParameter(COMMAND);
        if (action == null || action.isEmpty()) {
            return null;
        }
        CommandEnum commandEnum = CommandEnum.valueOf(action.toUpperCase());
        return commandEnum.getCurrentCommand();
    }
}
