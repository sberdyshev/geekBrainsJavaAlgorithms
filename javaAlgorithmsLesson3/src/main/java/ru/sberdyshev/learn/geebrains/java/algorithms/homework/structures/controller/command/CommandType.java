package ru.sberdyshev.learn.geebrains.java.algorithms.homework.structures.controller.command;

import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Represents possible command variations
 * @author sberdyshev
 */
public enum CommandType {
    CREATE_STACK("/crtS", "create stack", "Creates a stack with specified name. Format - \"/crtS <stack name (string)>\".", 1),
    DELETE_STACK("/dltS", "delete stack","Deletes a stack with specified name. Format - \"/dltS <stack name (string)>\".", 1),
    SHOW_STACK_LIST("/shSL", "show stack list","Shows all stacks. Format - \"/shSL\".", 0),
    PUSH_INTO_STACK("/pushS", "push into stack","Pushes an element into a stack with specified name. Format - \"/pushS <stack name (string)> <value to push (string)>\".", 2),
    POP_FROM_STACK("/popS", "pop from stack","Pops an element from a stack with specified name. Format - \"/popS <stack name (string)>\".", 1),
    PEEK_IN_STACK("/peekS", "peek in stack","Gets first element (doesn't delete it) from a stack with specified name. Format - \"/peekS <stack name (string)>\".", 1),
    PRINT_STACK("/prtS", "print stack","Prints all stack elements in a line. Format - \"/prtS <stack name (string)>\".", 1),
    SHOW_STACK_SIZE("/shSS", "show stack size","Prints stack size. Format - \"/shSS <stack name (string)>\".", 1),

    CREATE_QUEUE("/crtQ", "create queue","Creates a queue with specified name. Format - \"/crtQ <queue name (string)>\".", 1),
    DELETE_QUEUE("/dltQ", "delete queue","Deletes a queue with specified name. Format - \"/dltQ <queue name (string)>\".", 1),
    SHOW_QUEUE_LIST("/shQL", "show queue list","Shows all queues. Format - \"/shQL\".", 0),
    WRITE_INTO_QUEUE("/wQ", "write into queue","Writes an element into a queue with specified name. Format - \"/wQ <queue name (string)> <value to write (string)>\".", 2),
    READ_FROM_QUEUE("/rQ", "read from queue","Reads an element from a queue with specified name. Format - \"/rQ <queue name (string)>\".", 1),
    BROWSE_QUEUE("/bQ", "browse queue","Browses first element (doesn't delete it) from a queue with specified name. Format - \"/bQ <queue name (string)>\".", 1),
    PRINT_QUEUE("/pQ", "print queue","Prints all queue elements in a line. Format - \"/pQ <queue name (string)>\".", 1),
    SHOW_QUEUE_SIZE("/shQS", "show queue size","Prints queue size. Format - \"/shQS <queue name (string)>\".", 1),

    HELP("/help", "help", "Get command list. Format - \"/help\".", 0),
    EXIT("/exit", "exit","Exit. Format - \"/exit\".", 0),
    NONE(null, null,null, 0);

    private static final Logger logger = LoggerFactory.getLogger(CommandType.class);
    @Getter
    private String command;
    @Getter
    private String commandShortDescr;
    @Getter
    private String commandDescr;
    @Getter
    private int argsAmount;

    CommandType(String command, String commandShortDescr, String commandDescr, int argsAmount) {
        this.command = command;
        this.argsAmount = argsAmount;
        this.commandDescr = commandDescr;
        this.commandShortDescr = commandShortDescr;
    }
}
