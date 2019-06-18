package ru.sberdyshev.learn.geebrains.java.algorithms.homework.structures.controller;

import ru.sberdyshev.learn.geebrains.java.algorithms.homework.structures.controller.command.Command;
import ru.sberdyshev.learn.geebrains.java.algorithms.homework.structures.controller.command.CommandType;

public interface CLIController extends Controller {
    Command parse(String line);

    default void showEnterCommandInvitation() {
        System.out.print("Enter your command: ");
    }

    default void showWrongArgsMessage() {
        System.out.println("Wrong amount or type af arguments, try one more time.");
    }

    default void showGoodBuyMessage() {
        System.out.println("Thank you for using this, buy-buy!");
    }

    default void showExaustedTriesMessage() {
        System.out.println("You entered too many wrong commands. You are tired, probably. Try next time.");
    }

    default void showWrongCommandMessage() {
        System.out.println("Wrong command. Try " + CommandType.HELP.getCommand());
    }

    default void showHelpMessage() {
        System.out.println("All possible commands:");
        showCommands();
    }

    @Override
    default void showCommands() {
        CommandType[] commandList = CommandType.values();
        for (CommandType commandType : commandList) {
            if (commandType != CommandType.NONE) {
                System.out.println("Command: " + commandType.getCommand() + ". Description: " + commandType.getCommandDescr());
            }
        }
    }
}
