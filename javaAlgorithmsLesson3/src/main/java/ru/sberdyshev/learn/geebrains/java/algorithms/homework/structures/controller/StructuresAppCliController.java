package ru.sberdyshev.learn.geebrains.java.algorithms.homework.structures.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.sberdyshev.learn.geebrains.java.algorithms.homework.structures.controller.command.Command;
import ru.sberdyshev.learn.geebrains.java.algorithms.homework.structures.controller.command.CommandType;
import ru.sberdyshev.learn.geebrains.java.algorithms.homework.structures.queue.Queue;
import ru.sberdyshev.learn.geebrains.java.algorithms.homework.structures.queue.QueueImpl;
import ru.sberdyshev.learn.geebrains.java.algorithms.homework.structures.stack.Stack;
import ru.sberdyshev.learn.geebrains.java.algorithms.homework.structures.stack.StackImpl;

import java.util.*;

/**
 * @author sberdyshev
 */
public class StructuresAppCliController implements CLIController {
    private static final Logger logger = LoggerFactory.getLogger(StructuresAppCliController.class);
    private final int maxTryCount;
    private final Map<String, Stack<String>> stacks;
    private final Map<String, Queue<String>> queues;
    private static final String PROCESSING_METHOD_START_DEBUG = "Processing \"{}\"";
    private static final String PROCESSING_METHOD_END_DEBUG = "Processed \"{}\"";
    private static final String PROCESSING_METHOD_OUTPUT_SEPARATOR = "-----------------------";
    private static final String PROCESSIN_METHOD_NO_STACK_WARNING = "There is no stack with name \"{}\".";
    private static final String PROCESSIN_METHOD_NO_QUEUE_WARNING = "There is no queue with name \"{}\".";


    public StructuresAppCliController(int maxTryCount) {
        this.maxTryCount = maxTryCount;
        this.stacks = new HashMap();
        this.queues = new HashMap();
    }

    @Override
    public void start() {
        logger.debug("StructuresAppCliController started");
        Scanner scanner = new Scanner(System.in);
        boolean isExit = false;
        int tryCount = 0;
        do {
            showEnterCommandInvitation();
            String line = scanner.nextLine();
            logger.debug("Line read \"{}\"", line);
            Command command = parse(line);
            if (!command.checkArgsAreCorrrect()) {
                showWrongArgsMessage();
                tryCount += 1;
            } else {
                logger.debug("Choosed \"{}\"", command.getType().getCommandShortDescr());
                switch (command.getType()) {
                    case EXIT:
                        processExit();
                        isExit = true;
                        break;
                    case CREATE_STACK: {
                        tryCount = 0;
                        processCreateStack(command);
                        break;
                    }
                    case DELETE_STACK: {
                        tryCount = 0;
                        processDeleteStack(command);
                        break;
                    }
                    case SHOW_STACK_LIST: {
                        tryCount = 0;
                        processShowStackList(command);
                        break;
                    }
                    case PUSH_INTO_STACK: {
                        tryCount = 0;
                        processPushIntoStack(command);
                        break;
                    }
                    case POP_FROM_STACK: {
                        tryCount = 0;
                        processPopFromStack(command);
                        break;
                    }
                    case PEEK_IN_STACK: {
                        tryCount = 0;
                        processPeekInStack(command);
                        break;
                    }
                    case PRINT_STACK: {
                        tryCount = 0;
                        processPrintStack(command);
                        break;
                    }
                    case SHOW_STACK_SIZE: {
                        tryCount = 0;
                        processShowStackSize(command);
                        break;
                    }
                    case CREATE_QUEUE: {
                        tryCount = 0;
                        processCreateQueue(command);
                        break;
                    }
                    case DELETE_QUEUE: {
                        tryCount = 0;
                        processDeleteQueue(command);
                        break;
                    }
                    case SHOW_QUEUE_LIST: {
                        tryCount = 0;
                        processShowQueueList(command);
                        break;
                    }
                    case WRITE_INTO_QUEUE: {
                        tryCount = 0;
                        processWriteIntoQueue(command);
                        break;
                    }
                    case READ_FROM_QUEUE: {
                        tryCount = 0;
                        processReadFromQueue(command);
                        break;
                    }
                    case BROWSE_QUEUE: {
                        tryCount = 0;
                        processBrowseQueue(command);
                        break;
                    }
                    case PRINT_QUEUE: {
                        tryCount = 0;
                        processPrintQueue(command);
                        break;
                    }
                    case SHOW_QUEUE_SIZE: {
                        tryCount = 0;
                        processShowQueueSize(command);
                        break;
                    }
                    case HELP: {
                        tryCount = 0;
                        processHelp();
                        break;
                    }
                    case NONE: {
                        tryCount += 1;
                        logger.debug("Wrong command, tryCount = \"{}\"", tryCount);
                        isExit = processWrongCommand(tryCount);
                        break;
                    }
                    default: {
                        IllegalStateException e = new IllegalStateException("Wrong command type: " + command.getType());
                        logger.error(e.getLocalizedMessage(), e);
                        throw e;
                    }
                }
            }
        } while (!isExit);
    }

    private void processCreateStack(Command command) {
        logger.debug(PROCESSING_METHOD_START_DEBUG, command.getType().getCommandShortDescr());
        String newStackName = command.getArgAtPos(0);
        if (stacks.containsKey(newStackName)) {
            logger.warn("Stack list already has \"{}\" stack. Try deleting it first. Aborting.", newStackName);
            System.out.println("Stack list already has \"" + newStackName + "\" stack. Try deleting it first. Aborting.");
        } else {
            Stack<String> newStack = new StackImpl<>(String.class, newStackName);
            stacks.put(newStackName, newStack);
            logger.debug("Stack with name \"{}\" added to stack list.", newStackName);
            System.out.println("Stack with name \"" + newStackName + "\" added to stack list.");
        }
        logger.debug(PROCESSING_METHOD_END_DEBUG, command.getType().getCommandShortDescr());
    }

    private void processDeleteStack(Command command) {
        logger.debug(PROCESSING_METHOD_START_DEBUG, command.getType().getCommandShortDescr());
        String deleteStackName = command.getArgAtPos(0);
        Stack<String> removedStack = stacks.remove(deleteStackName);
        if (removedStack != null) {
            logger.debug("Stack with name \"{}\" deleted from stack list.", deleteStackName);
            System.out.println("Stack with name \"" + deleteStackName + "\" deleted from stack list.");
        } else {
            logger.debug("Stack with name \"{}\" hasn't been found in stack list.", deleteStackName);
            System.out.println("Stack with name \"" + deleteStackName + "\" hasn't been found in stack list.");
        }
        logger.debug(PROCESSING_METHOD_END_DEBUG, command.getType().getCommandShortDescr());
    }

    private void processShowStackList(Command command) {
        logger.debug(PROCESSING_METHOD_START_DEBUG, command.getType().getCommandShortDescr());
        System.out.println(PROCESSING_METHOD_OUTPUT_SEPARATOR);
        System.out.println("Stack list:");
        System.out.println(PROCESSING_METHOD_OUTPUT_SEPARATOR);
        stacks.forEach((stackName, stack) -> System.out.println(stackName));
        System.out.println(PROCESSING_METHOD_OUTPUT_SEPARATOR);
        logger.debug(PROCESSING_METHOD_END_DEBUG, command.getType().getCommandShortDescr());
    }

    private void processPushIntoStack(Command command) {
        logger.debug(PROCESSING_METHOD_START_DEBUG, command.getType().getCommandShortDescr());
        String stackName = command.getArgAtPos(0);
        String valueToPush = command.getArgAtPos(1);
        Stack<String> stack = stacks.get(stackName);
        if (stack != null) {
            stack.push(valueToPush);
            System.out.println("A value \"" + valueToPush + "\" has been pushed to stack \"" + stackName + "\".");
        } else {
            logger.warn(PROCESSIN_METHOD_NO_STACK_WARNING, stackName);
            System.out.println("There is no stack with name \"" + stackName + "\".");
        }
        logger.debug(PROCESSING_METHOD_END_DEBUG, command.getType().getCommandShortDescr());
    }

    private void processPopFromStack(Command command) {
        logger.debug(PROCESSING_METHOD_START_DEBUG, command.getType().getCommandShortDescr());
        String stackName = command.getArgAtPos(0);
        Stack<String> stack = stacks.get(stackName);
        if (stack != null) {
            if (stack.isEmpty()) {
                System.out.println("Stack \"" + stackName + "\" is empty.");
                logger.debug("Stack \"" + stackName + "\" is empty.");
            } else {
                String resultValue = stack.pop();
                System.out.println("Read a value from the stack \"" + stackName + "\": \"" + resultValue + "\".");
                logger.debug("Read a value from the stack \"" + stackName + "\": \"" + resultValue + "\".");
            }
        } else {
            logger.warn(PROCESSIN_METHOD_NO_STACK_WARNING, stackName);
            System.out.println("There is no stack with name \"" + stackName + "\".");
        }
        logger.debug(PROCESSING_METHOD_END_DEBUG, command.getType().getCommandShortDescr());
    }

    private void processPeekInStack(Command command) {
        logger.debug(PROCESSING_METHOD_START_DEBUG, command.getType().getCommandShortDescr());
        String stackName = command.getArgAtPos(0);
        Stack<String> stack = stacks.get(stackName);
        if (stack != null) {
            if (stack.isEmpty()) {
                System.out.println("Stack \"" + stackName + "\" is empty.");
                logger.debug("Stack \"" + stackName + "\" is empty.");
            } else {
                String resultValue = stack.peek();
                System.out.println("Read a value from the stack \"" + stackName + "\": \"" + resultValue + "\".");
                logger.debug("Read a value from the stack \"" + stackName + "\": \"" + resultValue + "\".");
            }
        } else {
            logger.warn(PROCESSIN_METHOD_NO_STACK_WARNING, stackName);
            System.out.println("There is no stack with name \"" + stackName + "\".");
        }
        logger.debug(PROCESSING_METHOD_END_DEBUG, command.getType().getCommandShortDescr());
    }

    private void processPrintStack(Command command) {
        logger.debug(PROCESSING_METHOD_START_DEBUG, command.getType().getCommandShortDescr());
        String stackName = command.getArgAtPos(0);
        Stack<String> stack = stacks.get(stackName);
        if (stack != null) {
            if (!stack.isEmpty()) {
                List<String> stackValues = stack.getValues();
                System.out.println(PROCESSING_METHOD_OUTPUT_SEPARATOR);
                System.out.println("Stack \"" + stackName + "\" values:");
                System.out.println(PROCESSING_METHOD_OUTPUT_SEPARATOR);
                for (String value : stackValues) {
                    System.out.print(value + " ");
                }
                System.out.println("\r\n-----------------------");
            } else {
                System.out.println("Stack \"" + stackName + "\" is empty.");
            }
        } else {
            logger.warn(PROCESSIN_METHOD_NO_STACK_WARNING, stackName);
            System.out.println("There is no stack with name \"" + stackName + "\".");
        }
        logger.debug(PROCESSING_METHOD_END_DEBUG, command.getType().getCommandShortDescr());
    }

    private void processShowStackSize(Command command) {
        logger.debug(PROCESSING_METHOD_START_DEBUG, command.getType().getCommandShortDescr());
        String stackName = command.getArgAtPos(0);
        Stack<String> stack = stacks.get(stackName);
        if (stack != null) {
            int stackSize = stack.getSize();
            System.out.println("Stack \"" + stackName + "\" has size: " + stackSize + ".");
        } else {
            logger.warn(PROCESSIN_METHOD_NO_STACK_WARNING, stackName);
            System.out.println("There is no stack with name \"" + stackName + "\".");
        }
        logger.debug(PROCESSING_METHOD_END_DEBUG, command.getType().getCommandShortDescr());
    }

    private void processCreateQueue(Command command) {
        logger.debug(PROCESSING_METHOD_START_DEBUG, command.getType().getCommandShortDescr());
        String newQueueName = command.getArgAtPos(0);
        if (queues.containsKey(newQueueName)) {
            logger.warn("Queue list already has \"{}\" queue. Try deleting it first. Aborting.", newQueueName);
            System.out.println("Queue list already has \"" + newQueueName + "\" queue. Try deleting it first. Aborting.");
        } else {
            Queue<String> newQueue = new QueueImpl<>(String.class, newQueueName);
            queues.put(newQueueName, newQueue);
            logger.debug("Queue with name \"{}\" added to queue list.", newQueueName);
        }
        logger.debug(PROCESSING_METHOD_END_DEBUG, command.getType().getCommandShortDescr());
    }

    private void processDeleteQueue(Command command) {
        logger.debug(PROCESSING_METHOD_START_DEBUG, command.getType().getCommandShortDescr());
        String deleteQueueName = command.getArgAtPos(0);
        Queue<String> removedQueue = queues.remove(deleteQueueName);
        if (removedQueue != null) {
            logger.debug("Queue with name \"{}\" deleted from queue list.", deleteQueueName);
            System.out.println("Queue with name \"" + deleteQueueName + "\" deleted from queue list.");
        } else {
            logger.debug("Queue with name \"{}\" hasn't been found in queue list.", deleteQueueName);
            System.out.println("Queue with name \"" + deleteQueueName + "\" hasn't been found in queue list.");
        }
        logger.debug(PROCESSING_METHOD_END_DEBUG, command.getType().getCommandShortDescr());
    }

    private void processShowQueueList(Command command) {
        logger.debug(PROCESSING_METHOD_START_DEBUG, command.getType().getCommandShortDescr());
        System.out.println(PROCESSING_METHOD_OUTPUT_SEPARATOR);
        System.out.println("Queue list:");
        System.out.println(PROCESSING_METHOD_OUTPUT_SEPARATOR);
        queues.forEach((queueName, queue) -> System.out.println(queueName));
        System.out.println(PROCESSING_METHOD_OUTPUT_SEPARATOR);
        logger.debug(PROCESSING_METHOD_END_DEBUG, command.getType().getCommandShortDescr());
    }

    private void processWriteIntoQueue(Command command) {
        logger.debug(PROCESSING_METHOD_START_DEBUG, command.getType().getCommandShortDescr());
        String queueName = command.getArgAtPos(0);
        String valueToPush = command.getArgAtPos(1);
        Queue<String> queue = queues.get(queueName);
        if (queue != null) {
            queue.write(valueToPush);
            System.out.println("A value \"" + valueToPush + "\" has been pushed to queue \"" + queueName + "\".");
        } else {
            logger.warn(PROCESSIN_METHOD_NO_QUEUE_WARNING, queueName);
            System.out.println("There is no queue with name \"" + queueName + "\".");
        }
        logger.debug(PROCESSING_METHOD_END_DEBUG, command.getType().getCommandShortDescr());
    }

    private void processReadFromQueue(Command command) {
        logger.debug(PROCESSING_METHOD_START_DEBUG, command.getType().getCommandShortDescr());
        String queueName = command.getArgAtPos(0);
        Queue<String> queue = queues.get(queueName);
        if (queue != null) {
            if (queue.isEmpty()) {
                System.out.println("Queue \"" + queueName + "\" is empty.");
                logger.debug("Queue \"" + queueName + "\" is empty.");
            } else {
                String resultValue = queue.read();
                System.out.println("Read a value from the queue \"" + queueName + "\": \"" + resultValue + "\".");
                logger.debug("Read a value from the queue \"" + queueName + "\": \"" + resultValue + "\".");
            }
        } else {
            logger.warn(PROCESSIN_METHOD_NO_QUEUE_WARNING, queueName);
            System.out.println("There is no queue with name \"" + queueName + "\".");
        }
        logger.debug(PROCESSING_METHOD_END_DEBUG, command.getType().getCommandShortDescr());
    }

    private void processBrowseQueue(Command command) {
        logger.debug(PROCESSING_METHOD_START_DEBUG, command.getType().getCommandShortDescr());
        String queueName = command.getArgAtPos(0);
        Queue<String> queue = queues.get(queueName);
        if (queue != null) {
            if (queue.isEmpty()) {
                System.out.println("Queue \"" + queueName + "\" is empty.");
                logger.debug("Queue \"" + queueName + "\" is empty.");
            } else {
                String resultValue = queue.browse();
                System.out.println("Read a value from the queue \"" + queueName + "\": \"" + resultValue + "\".");
                logger.debug("Read a value from the queue \"" + queueName + "\": \"" + resultValue + "\".");
            }
        } else {
            logger.warn(PROCESSIN_METHOD_NO_QUEUE_WARNING, queueName);
            System.out.println("There is no queue with name \"" + queueName + "\".");
        }
        logger.debug(PROCESSING_METHOD_END_DEBUG, command.getType().getCommandShortDescr());
    }

    private void processPrintQueue(Command command) {
        logger.debug(PROCESSING_METHOD_START_DEBUG, command.getType().getCommandShortDescr());
        String queueName = command.getArgAtPos(0);
        Queue<String> queue = queues.get(queueName);
        if (queue != null) {
            if (!queue.isEmpty()) {
                List<String> queueValues = queue.getValues();
                System.out.println(PROCESSING_METHOD_OUTPUT_SEPARATOR);
                System.out.println("Queue \"" + queueName + "\" values:");
                System.out.println(PROCESSING_METHOD_OUTPUT_SEPARATOR);
                for (String value : queueValues) {
                    System.out.print(value + " ");
                }
                System.out.println("\r\n-----------------------");
            } else {
                System.out.println("Queue \"" + queueName + "\" is empty.");
            }
        } else {
            logger.warn(PROCESSIN_METHOD_NO_QUEUE_WARNING, queueName);
            System.out.println("There is no queue with name \"" + queueName + "\".");
        }
        logger.debug(PROCESSING_METHOD_END_DEBUG, command.getType().getCommandShortDescr());
    }

    private void processShowQueueSize(Command command) {
        logger.debug(PROCESSING_METHOD_START_DEBUG, command.getType().getCommandShortDescr());
        String queueName = command.getArgAtPos(0);
        Queue<String> queue = queues.get(queueName);
        if (queue != null) {
            int queueSize = queue.getSize();
            System.out.println("Queue \"" + queueName + "\" has size: " + queueSize + ".");
        } else {
            logger.warn(PROCESSIN_METHOD_NO_QUEUE_WARNING, queueName);
            System.out.println("There is no queue with name \"" + queueName + "\".");
        }
        logger.debug(PROCESSING_METHOD_END_DEBUG, command.getType().getCommandShortDescr());
    }

    @Override
    public Command parse(String line) {
        logger.debug("Parsing line: \"{}\"", line);
        for (CommandType commandType : CommandType.values()) {
            if (commandType.equals(CommandType.NONE)) {
                continue;
            }
            boolean lineStartsWithCurrentCommand = line.startsWith(commandType.getCommand());
            boolean commandHasArgs = line.length() > commandType.getCommand().length();
            boolean commandSeparatedFromArgsWithSpace = line.startsWith(commandType.getCommand() + " ");
            if (lineStartsWithCurrentCommand) {
                if (!commandHasArgs || (commandHasArgs && commandSeparatedFromArgsWithSpace)) {
                    List<String> args = getArgs(line, commandType);
                    logger.debug("Command type: \"{}\"", commandType);
                    logger.debug("Arguments: \"{}\"", args);
                    return new Command(commandType, args);
                } else {
                    break;
                }
            }
        }
        return new Command(CommandType.NONE, new ArrayList<>());
    }

    private List<String> getArgs(String line, CommandType commandType) {
        List<String> args = new ArrayList<>();
        int commandLength = commandType.getCommand().length();
        String lineWithoutCommand;
        if (commandLength < line.length()) {
            lineWithoutCommand = line.substring(commandLength);
        } else {
            return args;
        }
        int leadingIndexOfWhiteSpaceForAPreviousCommand = 0;
        int leadingIndexOfWhiteSpace = 0;
        int trailingIndexOfWhiteSpace = 0;
        int spacesAmountInTheLine = (int) line.chars().filter(ch -> ch == ' ').count();
        for (int i = 0; i < spacesAmountInTheLine; i++) {
            leadingIndexOfWhiteSpace = lineWithoutCommand.indexOf(' ', leadingIndexOfWhiteSpaceForAPreviousCommand);
            trailingIndexOfWhiteSpace = lineWithoutCommand.indexOf(' ', leadingIndexOfWhiteSpace + 1);
            String arg;
            if (leadingIndexOfWhiteSpace >= trailingIndexOfWhiteSpace) {
                arg = lineWithoutCommand.substring(leadingIndexOfWhiteSpace).trim();
            } else {
                arg = lineWithoutCommand.substring(leadingIndexOfWhiteSpace, trailingIndexOfWhiteSpace).trim();
            }
            if ("".equals(arg)) {
                arg = null;
            }
            args.add(arg);
            if (trailingIndexOfWhiteSpace < 0) {
                break;
            }
            leadingIndexOfWhiteSpaceForAPreviousCommand = trailingIndexOfWhiteSpace;
        }
        return args;
    }

    private void processHelp() {
        showHelpMessage();
    }

    private boolean processWrongCommand(int tryCount) {
        boolean isExit = false;
        if (tryCount >= maxTryCount) {
            showExaustedTriesMessage();
            showGoodBuyMessage();
            isExit = true;
        } else {
            showWrongCommandMessage();
        }
        return isExit;
    }

    private void processExit() {
        showGoodBuyMessage();
    }
}
