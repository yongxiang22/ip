import java.util.Scanner;
import java.util.ArrayList;
public class Funky {
    private static final String DEADLINE_PREFIX = "deadline ";
    private static final String TODO_PREFIX = "todo ";
    private static final String EVENT_PREFIX = "event ";
    private static final String BY_KEYWORD = "/by ";
    private static final String FROM_KEYWORD = " /from";
    private static  final String DELETE_PREFIX = "delete ";




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
            ArrayList<Task> list = new ArrayList<>();
            Scanner in = new Scanner(System.in);
            Save save = new Save();
            Extract extract = new Extract();
            list = extract.Extract(list);

            
            int index = 0;
            int idx;

            while (true) {
                String echo = in.nextLine();
                // in.close(); 
                try {
                    if (echo.isEmpty()) {
                            throw new FunkyException("Please enter a valid command.");
                        
                        }
                    

                    
                    }catch (FunkyException e) {
                        System.out.println(e.getMessage());
                        continue;
                    }
                        
                        
                if (echo.equals("bye")) {
                    
                    save.save(list);
                    break;
                }

                else if (echo.equals("list")) {
                    for (int i = 0; i < list.size(); i++) {
                        System.out.println((i + 1) + ". " + list.get(i).toString());
                    }
                    continue;
                }

                if (echo.startsWith("mark")) {
                    idx = Integer.parseInt(echo.split(" ")[1]) - 1;
                    list.get(idx).markAsDone();
                    System.out.println("Nice! I've marked this task as done:");
                    System.out.println("[" + list.get(idx).getStatusIcon() + "] " + list.get(idx).description);
                    
                    continue;
                }

                if (echo.startsWith("unmark")) {
                    idx = Integer.parseInt(echo.split(" ")[1]) - 1;
                    list.get(idx).markAsNotDone();
                    System.out.println("OK, I've marked this task as not done yet:");
                    System.out.println("[" + list.get(idx).getStatusIcon() + "] " + list.get(idx).description);
                    continue;
                }//:)
                if (echo.startsWith(DEADLINE_PREFIX)) {
                    try {
                        if (!echo.contains(BY_KEYWORD)) {
                            throw new FunkyException("Please enter a valid deadline command with /by.");
                        }
                    } catch (FunkyException e) {
                        System.out.println(e.getMessage());
                        continue;
                    }
                    int byIndex = echo.indexOf(BY_KEYWORD);
                    String description = echo.substring(DEADLINE_PREFIX.length(), byIndex - 1);
                    String by = echo.substring(byIndex + BY_KEYWORD.length());

                    //list[index] = new Deadline(description, by);
                    list.add(new Deadline(description, by));
                    save.save(list);
                    System.out.println(list.get(list.size() - 1));
                    continue;
}

                if (echo.startsWith(TODO_PREFIX)) {
                    list.add(new ToDo(echo.substring(TODO_PREFIX.length())));
                    save.save(list);
                    System.out.println("____________________________________________________________");
                    System.out.println(list.get(list.size() - 1));
                    System.out.println("____________________________________________________________");
                    index++;
                    continue;
                }

                 if (echo.startsWith(EVENT_PREFIX)) {
                    try {
                        if (!echo.contains(FROM_KEYWORD) || !echo.contains("/to ")) {
                            throw new FunkyException("Please enter a valid event command with /from and /to.");
                        }
                    } catch (FunkyException e) {
                        System.out.println(e.getMessage());
                        continue;
                    }
                    String[] parts = echo.split("/");
                    String from = parts[1].trim().substring(4).trim(); // strip leading "from"
                    String to = parts[2].trim().substring(2).trim();    // strip leading "to"
                    list.add(new Event(echo.substring(EVENT_PREFIX.length(), echo.indexOf(FROM_KEYWORD)), from, to));
                    save.save(list);
                    System.out.println(list.get(list.size() - 1));
                    continue;
                    
                    
                 }
                 if (echo.startsWith(DELETE_PREFIX)) {
                    new Delete(list, Integer.parseInt(echo.split(" ")[1]) - 1);
                    save.save(list);
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