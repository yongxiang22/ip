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
        String echo = in.nextLine();
        System.out.println("____________________________________________________________");
        System.out.println(echo);
        System.out.println("____________________________________________________________");


        //GOODBYE LEVEL 0
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println("____________________________________________________________");

    }
}
