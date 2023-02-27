package by.academy.pagination.servlet.command;

import by.academy.pagination.servlet.command.impl.DeletePersonCommand;
import by.academy.pagination.servlet.command.impl.GetPersonCreateFormCommand;
import by.academy.pagination.servlet.command.impl.GetPersonEditFormCommand;
import by.academy.pagination.servlet.command.impl.ReadPaginatedPeopleCommand;
import by.academy.pagination.servlet.command.impl.ReadPeopleCommand;
import by.academy.pagination.servlet.command.impl.SaveNewPersonCommand;
import by.academy.pagination.servlet.command.impl.SaveUpdatedPersonCommand;

/**
 * @author Alexey
 * @version 1.0
 * Enum with Command implementations.
 */
public enum CommandEnum {
    /**
     * command for displaying all people on page.
     */
    READ_PEOPLE(new ReadPeopleCommand()),
    /**
     * command for displaying paginated collection of people on pages.
     */
    READ_PAGINATED_PEOPLE(new ReadPaginatedPeopleCommand()),
    /**
     * command for transmitting new person form.
     */
    GET_PERSON_CREATE_FORM(new GetPersonCreateFormCommand()),
    /**
     * command for saving new person entities in database.
     */
    SAVE_NEW_PERSON(new SaveNewPersonCommand()),
    /**
     * command for transmitting edit person form.
     */
    GET_PERSON_EDIT_FORM(new GetPersonEditFormCommand()),
    /**
     * command for saving updated person entities in database.
     */
    SAVE_UPDATED_PERSON(new SaveUpdatedPersonCommand()),
    /**
     * command for deleting person entities from database.
     */
    DELETE_PERSON(new DeletePersonCommand());
    /**
     * Command implementation.
     */
    private final Command command;

    /**
     * CommandEnum initialization.
     *
     * @param newCommand servletCommand
     */
    CommandEnum(final Command newCommand) {
        command = newCommand;
    }

    /**
     * @return command implementation from enum.
     */
    public Command getCommand() {
        return command;
    }
}
