import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Represents a class for storage that deals with interactions with the user.
 */
public class Ui {
    private final Scanner in;
    private final PrintStream out;
    private static final String LINE =  "_______________________________________________\n";

    private static final String GREETING= "Hello! I'm Duke from the chat bot universe ~ \n" +
            "Nice to meet you! \n" +
            "I'll be your task manager from now onwards.\n";

    private static final String BYE = "Awwww, I guess you are gonna leave... \n" +
            "I'll keep track of your tasks nicely. \n" +
            "Text me if you wanna talk again! Have a nice day!\n";


    public Ui() {
        this(System.in, System.out);
    }

    public Ui(InputStream in, PrintStream out) {
        this.in = new Scanner(in);
        this.out = out;
    }

    public Scanner getIn() {
        return in;
    }

    public PrintStream getOut() {
        return out;
    }

    /**
     * This method is used to greet the user.
     */
    public String greet() {
        return LINE + GREETING + LINE;
    }

    /**
     * This method is used to say good bye to the user.
     */
    public String bye() {
        return LINE + BYE + LINE;
    }

    /**
     * This method is used to get command from the user.
     */
    public String getUserCommand() {
        String fullInputLine = in.nextLine();
        return fullInputLine;
    }

    /**
     * This method is used to print all the tasks in the task list.
     * @param taskList The task list used for printing.
     */
    public void printAll(TaskList taskList) {
        System.out.println(returnAll(taskList));
    }

    public String returnAll(TaskList taskList) {
        String stringToReturn = LINE + "Here are the tasks in your list: \n";
        for (int i = 1; i < taskList.getNoOfTasks() + 1; i++) {
            Task cur = taskList.list.get(i - 1);
            stringToReturn += ("" + i + "." + cur + "\n");
        }
        stringToReturn += LINE;
        return stringToReturn;
    }


    public void printRelevant(TaskList taskList, String keyWord) {
        System.out.println(returnRelevant(taskList,keyWord));
    }

    public String returnRelevant(TaskList taskList, String keyWord) {
        String stringToReturn = LINE + "Here are the matching tasks in your list: \n";
        int n = taskList.getNoOfTasks();
        for (int i = 1; i < n + 1; i++) {
            Task cur = taskList.list.get(i - 1);
            if (!cur.toString().contains(keyWord)) {
                continue;
            }
            stringToReturn += ("" + i + "." + cur + "/n");
        }
        stringToReturn += LINE;
        return stringToReturn;
    }


    /**
     * This method is used to warn the user that the list is empty.
     */
    public String emptyList() {
        Exception ex = new InvalidInputException("Oops, your list is currently empty. Add some tasks first!");
        String stringToReturn = LINE + ex.getMessage() + "\n" + LINE;
        return stringToReturn;
    }

    // ADD RELATED
    public String addSuccessful(Task added, TaskList list) {
        String stringToReturn = LINE + "Got it. I've added this task: \n"
                                + added + "\n" + "Now you have " + list.getNoOfTasks() +
                                 " tasks in the list.\n " + LINE ;
        return stringToReturn;
    }

    /**
     * This method is used to warn the user that the command is undefined.
     */
    public String unknownCommand() {
        Exception ex = new InvalidInputException("Ah oh! I didn't know what that means >n<, sorry! ");
        String stringToReturn = LINE + ex.getMessage() + "\n" + LINE;
        return stringToReturn;
    }

    // DELETE RELATED
    public String deleteSuccessful(Task deleted, TaskList list) {
        String stringToReturn = LINE + "Got it. I've removed this task: \n" + deleted +
                                "\n" + "Now you have " + list.getNoOfTasks() +
                                " tasks in the list. " + "\n" + LINE;
        return  stringToReturn;
    }

    /**
     * This method is used to warn the user that task to be deleted is not specified.
     */
    public String incompleteDeleteCommand() {
        Exception ex = new InvalidInputException("Hey, you forgot to tell me which task to delete");
        String stringToReturn = LINE + ex.getMessage() + "\n" + LINE;
        return stringToReturn;
    }


    // MODIFY
    public String markDoneSuccessful(Task done) {
        String stringToReturn = LINE + "Nice! I've marked this task as done: \n" +
                                done + "\n" + LINE;
        return stringToReturn;
    }

    // PRINT RELATED
    public String markDoneFailure() {
        Exception ex = new InvalidInputException("Hey, you forgot to tell me which task is done!");
        String stringToReturn = LINE + ex.getMessage() + "\n" + LINE;
        return stringToReturn;
    }

    /**
     * This method is used to warn the user that the task referred to has not been created.
     */
    public String uncreatedTask() {
        Exception ex = new InvalidInputException("Oops, this task has not been created yet!");
        String stringToReturn = LINE + ex.getMessage() + "\n" + LINE;
        return stringToReturn;
    }

    /**
     * This method is used to warn the user that there is not prior data from Duke.
     */
    public String showLoadingError() {
        return "Creating the storage file...";
    }

    public String  missingDescription(String type) {
        Exception ex = new InvalidInputException("Hey, you forget the description for your " + type +"!");
        String stringToReturn = LINE + ex.getMessage() + "\n" + LINE;
        return stringToReturn;
    }

    /**
     * This method is used to warn the user that the deadline information is missing.
     */
    public String missingDeadline() {
        Exception ex = new InvalidInputException("Sorry, but I can't help if you don't tell me the exact deadline!");
        String stringToReturn = LINE + ex.getMessage() + "\n" + LINE;
        return stringToReturn;
    }

    /**
     * This method is used to warn the user that the event time is missing.
     */
    public String missingEventTime() {
        Exception ex = new InvalidInputException("I see...But what time is this event at?");
        String stringToReturn = LINE + ex.getMessage() + "\n" + LINE;
        return stringToReturn;
    }
}
