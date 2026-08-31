import java.util.Scanner;

public class Funky {
    public static class Task {
        protected String description;
        protected boolean isDone;

        public Task(String description) {
            this.description = description;
            this.isDone = false;
        }

        public String getStatusIcon() {
            return (isDone ? "X" : " "); // mark done task with X
        }

        public void markAsDone() {
            this.isDone = true;
        }

        public void markAsNotDone() {
            this.isDone = false;
        }

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
                        System.out.println((i + 1) + ".[" + list[i].getStatusIcon() + "] " + list[i].description);
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


                list[index] = new Task(echo);
                index++;

                System.out.println("____________________________________________________________");
                System.out.println("added: " + echo);
                System.out.println("____________________________________________________________");
            }


            //GOODBYE LEVEL 0
            System.out.println("Bye. Hope to see you again soon!");
            System.out.println("____________________________________________________________");

        }
    }
}