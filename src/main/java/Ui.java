import java.util.Scanner;

public class Ui {
    private static final String LINE = "____________________________________________________________";
    private static final String BANNER = " _____             _          \n"
            + "|  ___|   _ _ __  | | ___   _ \n"
            + "| |_ | | | | '_ \\ | |/ / | | |\n"
            + "|  _|| |_| | | | ||   <| |_| |\n"
            + "|_|   \\__,_|_| |_||_|\\_\\\\__, |\n"
            + "                         |___/ \n";

    private final Scanner in = new Scanner(System.in);


    public void showWelcome() {
        System.out.println(BANNER);
        showLine();
        System.out.println("Hello! I'm Funky");
        System.out.println("What can I do for you? ");
        showLine();
    }


    public void showGoodbye() {
        System.out.println("Bye. Hope to see you again soon!");
        showLine();
    }


    public void showLine() {
        System.out.println(LINE);
    }


    public String readCommand() {
        return in.nextLine();
    }

    
    public void showMessage(String message) {
        System.out.println(message);
    }

    
    public void showError(String message) {
        System.out.println(message);
    }
}