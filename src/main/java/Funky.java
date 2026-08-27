import java.util.Scanner;

public class Funky {



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

        String[] list  = new String[100];
        int index = 0;

        while (true) {
    String echo = in.nextLine();

    if (echo.equals("bye")) {
        break;
    }

    if (echo.equals("list")) {
        for (int i = 0; i < index; i++) {
            System.out.println((i + 1) + ". " + list[i]);
        }
        continue;
    }

    list[index] = echo;
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
