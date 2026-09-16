import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Extract {

    public ArrayList<Task> Extract(ArrayList<Task> list) {

        String STARTING_ICONS = "[T][ ] ";
        try {
            File file = new File("./data/duke.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.startsWith("[T]")) {
                String description = line.substring(STARTING_ICONS.length());
                ToDo todo = new   ToDo(description);
                list.add(todo);
            } else if (line.startsWith("[D]")) {
                String description = line.substring(STARTING_ICONS.length(), line.indexOf("(by:"));
                String by = line.substring(line.indexOf("(by:") + 5, line.indexOf(")"));
                Deadline deadline = new Deadline(description, by);
                list.add(deadline);
                // Add the deadline to your list or perform any other necessary actions
            } else if (line.startsWith("[E]")) {
                String description = line.substring(STARTING_ICONS.length(), line.indexOf("(from:"));
                String from = line.substring(line.indexOf("(from:") + 7, line.indexOf("to:"));
                String to = line.substring(line.indexOf("to:") + 4, line.indexOf(")"));
                Event event = new Event(description, from, to);
                list.add(event);
                // Add the event to your list or perform any other necessary actions
            
            
            }

            
        }
        scanner.close();
    }
        catch (FileNotFoundException e) {
            System.out.println("Error reading file.");
        }

        
        

        return list;
    
    }
}
