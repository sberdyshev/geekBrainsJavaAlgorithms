package ru.sberdyshev.learn.geebrains.java.algorithms.homework.structures.controller.command;

import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum CommandType {
    CREATE_STACK("/crtSt", "Creates a stack with specified name. Format - \"/crtSt <stack name (string)>\".", 1),
    DELETE_STACK("/dltSt", "Deletes a stack with specified name. Format - \"/dltSt <stack name (string)>\".", 1),
    SHOW_STACK_LIST("/shSL", "Shows all stacks. Format - \"/shSL\".", 0),
    PUSH_INTO_STACK("/pushS", "Pushes an element into a stack with specified name. Format - \"/pushS <stack name (string)><value to push (string)>\".", 2),
    POP_FROM_STACK("/popS", "Pops an element from a stack with specified name. Format - \"/popS <stack name (string)>\".", 1),
    PEEK_IN_STACK("/peekS", "Gets first element (doesn't delete it) from a stack with specified name. Format - \"/peekS <stack name (string)>\".", 1),
    PRINT_STACK("/prtS", "Prints all stack elements in a line. Format - \"/prtS <stack name (string)>\".", 1),
    PRINT_STACK_SIZE("/prtSSz", "Prints stack size. Format - \"/prtSSz <stack name (string)>\".", 1),

    CREATE_QUEUE("/crtQ", "Creates a queue with specified name. Format - \"/crtQ <queue name (string)>\".", 1),
    DELETE_QUEUE("/dltQ", "Deletes a queue with specified name. Format - \"/dltQ <queue name (string)>\".", 1),
    SHOW_QUEUE_LIST("/shQL", "Shows all queues. Format - \"/shQL\".", 0),
    WRITE_INTO_QUEUE("/wQ", "Writes an element into a queue with specified name. Format - \"/wQ <queue name (string)><value to write (string)>\".", 2),
    READ_FROM_QUEUE("/rQ", "Reads an element from a queue with specified name. Format - \"/rQ <queue name (string)>\".", 1),
    BROWSE_QUEUE("/bQ", "Browses first element (doesn't delete it) from a queue with specified name. Format - \"/bQ <queue name (string)>\".", 1),
    PRINT_QUEUE("/pQ", "Prints all queue elements in a line. Format - \"/pQ <queue name (string)>\".", 1),
    PRINT_QUEUE_SIZE("/pQSz", "Prints queue size. Format - \"/pQSz <queue name (string)>\".", 1),

    HELP("/help", "Get command list. Format - \"/help\".", 0),
    EXIT("/exit", "Exit. Format - \"/exit\".", 0),
    NONE(null, null, 0);

    private final static Logger logger = LoggerFactory.getLogger(CommandType.class);
    @Getter
    private String commandName;
    @Getter
    private String commandDescr;
    @Getter
    private int argsAmount;

    CommandType(String commandName, String commandDescr, int argsAmount) {
        this.commandName = commandName;
        this.argsAmount = argsAmount;
        this.commandDescr = commandDescr;
    }
}
