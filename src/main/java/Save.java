import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

// public class Save {
//     public static void main(ArrayList<Task> list) {
//         try {
//             File folder = new File("./data");
//             folder.mkdirs();

//             FileWriter writer = new FileWriter("./data/duke.txt");
//             writer.close();

//         } catch (IOException e) {
//             System.out.println("Error creating file.");
//         }
//     }
// }

public class Save {

    public void save(ArrayList<Task> list) {
        // write list to file
        try {
            File folder = new File("./data");
            folder.mkdirs();

            FileWriter writer = new FileWriter("./data/duke.txt");
            for (Task task : list) {
                writer.write(task.toString() + System.lineSeparator());
            }
            writer.close();

        } catch (IOException e) {
            System.out.println("Error creating file.");
        }
    }
}