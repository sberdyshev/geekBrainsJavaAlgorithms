package ru.sberdyshev.learn.geebrains.java.algorithms.homework.structures.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.sberdyshev.learn.geebrains.java.algorithms.homework.structures.controller.command.Command;
import ru.sberdyshev.learn.geebrains.java.algorithms.homework.structures.controller.command.CommandType;
import ru.sberdyshev.learn.geebrains.java.algorithms.homework.structures.queue.Queue;
import ru.sberdyshev.learn.geebrains.java.algorithms.homework.structures.stack.Stack;
import ru.sberdyshev.learn.geebrains.java.algorithms.homework.structures.stack.StackImpl;

import java.util.*;

/**
 * @author sberdyshev
 */
public class StructuresAppCliController implements CLIController {
    private final static Logger logger = LoggerFactory.getLogger(StructuresAppCliController.class);
    private final int maxTryCount;
    private final Map<String, Stack<String>> stacks;
    private final Map<String, Queue<String>> queues;

    public StructuresAppCliController(int maxTryCount) {
        this.maxTryCount = maxTryCount;
        this.stacks = new HashMap();
        this.queues = new HashMap();
    }

    @Override
    public void start() throws IllegalStateException {
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
                logger.debug("Choosed {}", command.getType().getCommandShortDescr());
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
                        logger.debug("Wrong command, tryCount = {}", tryCount);
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
        logger.debug("Processing {}", command.getType().getCommandShortDescr());
        String newStackName = command.getArgAtPos(0);
        if (stacks.containsKey(newStackName)) {
            logger.warn("Stack list already has {} stack. Try deleting it first. Aborting.", newStackName);
            System.out.println("Stack list already has " + newStackName + " stack. Try deleting it first. Aborting.");
        } else {
            Stack<String> newStack = new StackImpl<>(String.class, newStackName);
            stacks.put(newStackName, newStack);
            logger.debug("Stack with name {} added to stack list.", newStackName);
        }
        logger.debug("Processed {}", command.getType().getCommandShortDescr());
    }

    private void processDeleteStack(Command command) {
        logger.debug("Processing {}", command.getType().getCommandShortDescr());
        String deleteStackName = command.getArgAtPos(0);
        Stack<String> removedStack = stacks.remove(deleteStackName);
        if (removedStack != null) {
            logger.debug("Stack with name {} deleted from stack list.", deleteStackName);
        } else {
            logger.debug("Stack with name {} hasn't been found in stack list.");
        }
        logger.debug("Processed {}", command.getType().getCommandShortDescr());
    }

    private void processShowStackList(Command command) {
        logger.debug("Processing {}", command.getType().getCommandShortDescr());
        System.out.println("-----------------------");
        System.out.println("Stack list:");
        stacks.forEach((stackName, stack) -> System.out.println(stackName));
        System.out.println("-----------------------");
        logger.debug("Processed {}", command.getType().getCommandShortDescr());
    }

    private void processPushIntoStack(Command command) {
        logger.debug("Processing {}", command.getType().getCommandShortDescr());
        String stackName = command.getArgAtPos(0);
        String valueToPush = command.getArgAtPos(1);
        Stack<String> stack = stacks.get(stackName);
        if (stack != null) {
            stack.push(valueToPush);
        } else {
            logger.warn("There is no stack with name {}.", stackName);
            System.out.println("There is no stack with name " + stackName + ".");
        }
        logger.debug("Processed {}", command.getType().getCommandShortDescr());
    }

    private void processPopFromStack(Command command) {
        logger.debug("Processing {}", command.getType().getCommandShortDescr());
        String stackName = command.getArgAtPos(0);
        Stack<String> stack = stacks.get(stackName);
        if (stack != null) {
            String resultValue = stack.pop();
            System.out.println("Read a value from the stack " + stackName + ": " + resultValue + "");
            logger.debug("Read a value from the stack " + stackName + ": " + resultValue + "");
        } else {
            logger.warn("There is no stack with name {}.", stackName);
            System.out.println("There is no stack with name " + stackName + ".");
        }
        logger.debug("Processed {}", command.getType().getCommandShortDescr());
    }

    private void processPeekInStack(Command command) {
        logger.debug("Processing {}", command.getType().getCommandShortDescr());
        String stackName = command.getArgAtPos(0);
        Stack<String> stack = stacks.get(stackName);
        if (stack != null) {
            String resultValue = stack.peek();
            System.out.println("Read a value from the stack " + stackName + ": " + resultValue + "");
            logger.debug("Read a value from the stack " + stackName + ": " + resultValue + "");
        } else {
            logger.warn("There is no stack with name {}.", stackName);
            System.out.println("There is no stack with name " + stackName + ".");
        }
        logger.debug("Processed {}", command.getType().getCommandShortDescr());
    }

    private void processPrintStack(Command command) {
        logger.debug("Processing {}", command.getType().getCommandShortDescr());
        String stackName = command.getArgAtPos(0);
        Stack<String> stack = stacks.get(stackName);
        if (stack != null) {
            if (!stack.isEmpty()) {
                List<String> stackValues = stack.getValues();
                System.out.println("Stack \"" + stackName + "\" values:");
                System.out.println("-----------------------");
                for (String value : stackValues) {
                    System.out.println(value);
                }
                System.out.println("-----------------------");
            } else {
                System.out.println("Stack \"" + stackName + "\" is empty.");
            }
        } else {
            logger.warn("There is no stack with name {}.", stackName);
            System.out.println("There is no stack with name " + stackName + ".");
        }
        logger.debug("Processed {}", command.getType().getCommandShortDescr());
    }

    private void processShowStackSize(Command command) {
        logger.debug("Processing {}", command.getType().getCommandShortDescr());
        String stackName = command.getArgAtPos(0);
        Stack<String> stack = stacks.get(stackName);
        if (stack != null) {
            int stackSize = stack.getSize();
            System.out.println("Stack \"" + stackName + "\" has size: " + stackSize + ".");
        } else {
            logger.warn("There is no stack with name {}.", stackName);
            System.out.println("There is no stack with name " + stackName + ".");
        }
        logger.debug("Processed {}", command.getType().getCommandShortDescr());
    }

    private void processDeleteQueue(Command command) {
    }

    private void processCreateQueue(Command command) {
    }

    private void processShowQueueList(Command command) {
    }

    private void processWriteIntoQueue(Command command) {
    }

    private void processReadFromQueue(Command command) {
    }

    private void processBrowseQueue(Command command) {
    }

    private void processPrintQueue(Command command) {
    }

    private void processShowQueueSize(Command command) {
    }

    @Override
    public Command parse(String line) {
        logger.debug("Parsing line: {}", line);
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
                    logger.debug("Command type: {}", commandType);
                    logger.debug("Arguments: {}", args);
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
//    private boolean processGetStudent(Command command) {
//        Integer id = new Integer(command.getArgAtPos(0));
//        try {
//            Student student = studentDao.getEntity(id);
//            System.out.println("Student with id \"" + student.getId() + "\", name \"" + student.getName() + "\", score \"" + student.getScore() + "\" found");
//            logger.info("Got student with id \"{}\", name \"{}\", score \"{}\" found", student.getId(), student.getName(), student.getScore());
//        } catch (SQLException e) {
//            logger.error("Couldn't get student: " + e.getLocalizedMessage(), e);
//            return false;
//        } catch (IllegalArgumentException e) {
//            logger.error("Couldn't get student: " + e.getLocalizedMessage(), e);
//            return false;
//        }
//        return true;
//    }
//
//    private boolean processGetAllStudents() {
//        try {
//            List<Student> students = studentDao.getEntities();
//            System.out.println("Got all students!");
//            logger.info("Got all students!");
//            for (Student student : students) {
//                System.out.println("Student with id \"" + student.getId() + "\", name \"" + student.getName() + "\", score \"" + student.getScore() + "\" found");
//                logger.info("Got student with id \"{}\", name \"{}\", score \"{}\" found", student.getId(), student.getName(), student.getScore());
//            }
//        } catch (SQLException e) {
//            logger.error("Couldn't get students: " + e.getLocalizedMessage(), e);
//            return false;
//        }
//        return true;
//    }
//
//    private boolean processAddStudent(Command command) {
//        Integer id = new Integer(command.getArgAtPos(0));
//        String name = command.getArgAtPos(1);
//        Integer score = new Integer(command.getArgAtPos(2));
//        Student student = new Student(id, name, score);
//        try {
//            studentDao.addEntity(student);
//            logger.info("Student with id \"{}\", name \"{}\", score \"{}\" added", student.getId(), student.getName(), student.getScore());
//        } catch (SQLException e) {
//            logger.error("Couldn't add student: " + e.getLocalizedMessage(), e);
//            return false;
//        }
//        return true;
//    }
//
//    private boolean processUpdateStudent(Command command) {
//        Integer id = new Integer(command.getArgAtPos(0));
//        String name = command.getArgAtPos(1);
//        Integer score = new Integer(command.getArgAtPos(2));
//        Student student = new Student(id, name, score);
//        try {
//            studentDao.updateEntity(student);
//            logger.info("Student with id \"{}\" updated. New name - \"{}\", new score - \"{}\"", student.getId(), student.getName(), student.getScore());
//        } catch (SQLException e) {
//            logger.error("Couldn't update student: " + e.getLocalizedMessage(), e);
//            return false;
//        } catch (IllegalArgumentException e) {
//            logger.error("Couldn't update student: " + e.getLocalizedMessage(), e);
//            return false;
//        }
//        return true;
//    }

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
