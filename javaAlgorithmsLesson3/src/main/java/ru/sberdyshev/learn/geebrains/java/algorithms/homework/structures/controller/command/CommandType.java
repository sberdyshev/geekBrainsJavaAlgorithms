package ru.sberdyshev.learn.geebrains.java.algorithms.homework.structures.controller.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum CommandType {
    CREATE_STACK("/crtSt", "Creates a stack with specified name. Format - \"/crtSt <stack name (string)>\".", 1, String.class),
    DELETE_STACK("/dltSt", "Deletes a stack with specified name. Format - \"/dltSt <stack name (string)>\".", 1, String.class),
    SHOW_STACKS_LIST("/shSL", "Shows all stacks. Format - \"/shSL\".", 0),
    PUSH_INTO_STACK("/pushS", "Pushes an element into a stack with specified name. Format - \"/pushS <stack name (string)><value to push (string)>\".", 2, String.class, String.class),
    POP_FROM_STACK("/popS", "Pops an element from a stack with specified name. Format - \"/popS <stack name (string)>\".", 1, String.class),
    PEEK_IN_STACK("/peekS", "Gets first element (doesn't delete it) from a stack with specified name. Format - \"/peekS <stack name (string)>\".", 1, String.class),
    PRINT_STACK("/prtS", "Prints all stack elements in a line. Format - \"/prtS <stack name (string)>\".", 1, String.class),
    PRINT_STACK_SIZE("/prtSSz", "Prints stack size. Format - \"/prtSSz <stack name (string)>\".", 1, String.class),

    CREATE_QUEUE("/crtQ", "Creates a queue with specified name. Format - \"/crtQ <stack name (string)>\".", 1, String.class),
    DELETE_QUEUE("/dltQ", "Deletes a queue with specified name. Format - \"/dltQ <stack name (string)>\".", 1, String.class),
    SHOW_QUEUES_LIST("/shQL", "Shows all queues. Format - \"/shQL\".", 0),
    WRITE_INTO_QUEUE("/wQ", "Writes an element into a queue with specified name. Format - \"/wQ <stack name (string)><value to push (string)>\".", 2, String.class, String.class),
    READ_FROM_QUEUE("/rQ", "Reads an element from a queue with specified name. Format - \"/rQ <stack name (string)>\".", 1, String.class),
    BROWSE_QUEUE("/bQ", "Browses first element (doesn't delete it) from a queue with specified name. Format - \"/bQ <stack name (string)>\".", 1, String.class),
    PRINT_QUEUE("/pQ", "Prints all queue elements in a line. Format - \"/pQ <stack name (string)>\".", 1, String.class),
    PRINT_QUEUE_SIZE("/pQSz", "Prints queue size. Format - \"/pQSz <stack name (string)>\".", 1, String.class),

    HELP("/help", "Get command list. Format - \"/help\".", 0),
    EXIT("/exit", "Exit. Format - \"/exit\".", 0),
    NONE(null, null, 0);

    private final static Logger logger = LoggerFactory.getLogger(CommandType.class);
    private String commandName;
    private String commandDescr;
    private int argsAmount;
    private Class<?>[] paramClassTypeList;

    public int getArgsAmount() {
        return argsAmount;
    }

    CommandType(String commandName, String commandDescr, int argsAmount, Class<?>... paramClassTypeList) {
        if (paramClassTypeList.length != argsAmount) {
            IllegalArgumentException e = new IllegalArgumentException("Amount of args should be equal to amount of Class variables");
            //TODO add logging
            throw e;
        }
        this.commandName = commandName;
        this.argsAmount = argsAmount;
        this.commandDescr = commandDescr;
        this.paramClassTypeList = paramClassTypeList;
    }
}
