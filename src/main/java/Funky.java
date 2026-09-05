import java.util.Scanner;

public class Funky {
    private static final String DEADLINE_PREFIX = "deadline ";
    private static final String TODO_PREFIX = "todo ";
    private static final String EVENT_PREFIX = "event ";
    private static final String BY_KEYWORD = "/by ";
    private static final String FROM_KEYWORD = " /from";




        public static void main(String[] args) {
            String banner = " _____             _          \n"
                    + "|  ___|   _ _ __  | | ___   _ \n"
                    + "| |_ | | | | '_ \\ | |/ / | | |\n"
                    + "|  _|| |_| | | | ||   <| |_| |\n"
                    + "|_|   \\__,_|_| |_||_|\\_\\\\__, |\n"
                    + "                         |___/ \n";


            // BANNER LEVEL 0
            System.out.println(banner);

            // INTRODUCTION //LEVEL 0
            System.out.println("____________________________________________________________");
            System.out.println("Hello! I'm Funky");
            System.out.println("What can I do for you? ");
            System.out.println("____________________________________________________________");

            // ECHO LEVEL 1
            Scanner in = new Scanner(System.in);

            Task[] list = new Task[100];
            int index = 0;
            int idx;

            while (true) {
                String echo = in.nextLine();

                if (echo.equals("bye")) {
                    break;
                }

                if (echo.equals("list")) {
                    for (int i = 0; i < index; i++) {
                        System.out.println((i + 1) + ". " + list[i].toString());
                    }
                    continue;
                }

                if (echo.startsWith("mark")) {
                    idx = Integer.parseInt(echo.split(" ")[1]) - 1;
                    list[idx].markAsDone();
                    System.out.println("Nice! I've marked this task as done:");
                    System.out.println("[" + list[idx].getStatusIcon() + "] " + list[idx].description);
                    
                    continue;
                }

                if (echo.startsWith("unmark")) {
                    idx = Integer.parseInt(echo.split(" ")[1]) - 1;
                    list[idx].markAsNotDone();
                    System.out.println("OK, I've marked this task as not done yet:");
                    System.out.println("[" + list[idx].getStatusIcon() + "] " + list[idx].description);
                    continue;
                }
                if (echo.startsWith(DEADLINE_PREFIX)) {
                    int byIndex = echo.indexOf(BY_KEYWORD);
                    String description = echo.substring(DEADLINE_PREFIX.length(), byIndex - 1);
                    String by = echo.substring(byIndex + BY_KEYWORD.length());

                    list[index] = new Deadline(description, by);
                    System.out.println(list[index]);
                    index++;
                    continue;
}

                if (echo.startsWith(TODO_PREFIX)) {
                    list[index] = new ToDo(echo.substring(TODO_PREFIX.length()));
                    System.out.println("____________________________________________________________");
                    System.out.println(list[index]);
                    System.out.println("____________________________________________________________");
                    index++;
                    continue;
                }

                 if (echo.startsWith(EVENT_PREFIX)) {
                    String[] parts = echo.split("/");
                    String from = parts[1].replace("from ", "from: ");
                    String to = parts[2].replace("to ", "to: ");
                    list[index] = new Event(echo.substring(EVENT_PREFIX.length(), echo.indexOf(FROM_KEYWORD)), from, to);
             
                    System.out.println(list[index]);
                    index++;
                    continue;
                    
                    
                 }


                // list[index] = new Task(echo);
                // index++;

                
            }


            //GOODBYE LEVEL 0
            System.out.println("Bye. Hope to see you again soon!");
            System.out.println("____________________________________________________________");

        }
    
}