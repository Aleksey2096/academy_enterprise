package org.example.controller;

import org.example.controller.impl.CreateCommand;
import org.example.controller.impl.DeleteCommand;
import org.example.controller.impl.ReadCommand;
import org.example.controller.impl.UpdateCommand;

public enum CommandEnum {
    CREATE(new CreateCommand()),
    READ(new ReadCommand()),
    UPDATE(new UpdateCommand()),
    DELETE(new DeleteCommand());
    private final ServletCommand servletCommand;

    CommandEnum(final ServletCommand newServletCommand) {
        servletCommand = newServletCommand;
    }

    public ServletCommand getCurrentCommand() {
        return servletCommand;
    }
}
