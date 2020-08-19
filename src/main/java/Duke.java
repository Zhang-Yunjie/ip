import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {

        /*String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        */

        String line = "____________________________________________________________\n";
        String greeting = "Hello! I'm Duke from the chat bot universe ~ Nice to meet you (●´∀｀●) \n" +
                           "You are the first human I've ever met. Say something to me!\n";
        String bye = "Awwww, I guess you are gonna leave... \n" +
                "Human language is so fun! " +
                "But it's time for me to sleep again (yesss I'm just a little sleepy chat bot xD )\n" +
                "Nudge me if you wanna talk again! Have a nice day ❤️\n ";

        System.out.println(line + greeting + line);
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String temp = sc.nextLine();
            if (temp.equals("bye")) {
                System.out.println(line + bye + line);
                return;
            } else {
                System.out.println(line + temp + "\n" + line);
            }

        }
    }
}
