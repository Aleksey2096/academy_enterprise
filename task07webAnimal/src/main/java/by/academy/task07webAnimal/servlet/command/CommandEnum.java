package by.academy.task07webAnimal.servlet.command;

import by.academy.task07webAnimal.servlet.command.impl.DeleteAnimalCommand;
import by.academy.task07webAnimal.servlet.command.impl.GetAnimalCreateFormCommand;
import by.academy.task07webAnimal.servlet.command.impl.GetAnimalEditFormCommand;
import by.academy.task07webAnimal.servlet.command.impl.ReadAnimalsCommand;
import by.academy.task07webAnimal.servlet.command.impl.SaveNewAnimalCommand;
import by.academy.task07webAnimal.servlet.command.impl.SaveUpdatedAnimalCommand;

/**
 * @author Alexey
 * @version 1.0
 * Enum with Command implementations.
 */
public enum CommandEnum {
    /**
     * command for displaying all animals on page.
     */
    READ_ANIMALS(new ReadAnimalsCommand()),
    /**
     * command for transmitting new animal form.
     */
    GET_ANIMAL_CREATE_FORM(new GetAnimalCreateFormCommand()),
    /**
     * command for saving new animal entities in database.
     */
    SAVE_NEW_ANIMAL(new SaveNewAnimalCommand()),
    /**
     * command for transmitting edit animal form.
     */
    GET_ANIMAL_EDIT_FORM(new GetAnimalEditFormCommand()),
    /**
     * command for saving updated animal entities in database.
     */
    SAVE_UPDATED_ANIMAL(new SaveUpdatedAnimalCommand()),
    /**
     * command for deleting animal entities in database.
     */
    DELETE_ANIMAL(new DeleteAnimalCommand());
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
    public Command getCurrentCommand() {
        return command;
    }
}

