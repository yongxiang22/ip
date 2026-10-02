import java.util.ArrayList;

/**
 * Entry point of the Funky task manager. Reads commands from the user and
 * updates the task list accordingly.
 */
public class Funky {
    private static final String DEADLINE_PREFIX = "deadline ";
    private static final String TODO_PREFIX = "todo ";
    private static final String EVENT_PREFIX = "event ";
    private static final String BY_KEYWORD = "/by ";
    private static final String FROM_KEYWORD = " /from";
    private static final String DELETE_PREFIX = "delete ";

    /**
     * Runs the application until the user enters {@code bye}.
     *
     * @param args Command line arguments (unused).
     */
    public static void main(String[] args) {
        Ui ui = new Ui();
        ui.showWelcome();

        ArrayList<Task> list = new ArrayList<>();
        Save save = new Save();
        Extract extract = new Extract();
        list = extract.Extract(list);

        int idx;

        while (true) {
            String echo = ui.readCommand();
            try {
                if (echo.isEmpty()) {
                    throw new FunkyException("Please enter a valid command.");
                }
            } catch (FunkyException e) {
                ui.showError(e.getMessage());
                continue;
            }

            if (echo.equals("bye")) {
                save.save(list);
                break;
            } else if (echo.equals("list")) {
                for (int i = 0; i < list.size(); i++) {
                    ui.showMessage((i + 1) + ". " + list.get(i).toString());
                }
                continue;
            }

            if (echo.startsWith("mark")) {
                idx = Integer.parseInt(echo.split(" ")[1]) - 1;
                list.get(idx).markAsDone();
                ui.showMessage("Nice! I've marked this task as done:");
                ui.showMessage("[" + list.get(idx).getStatusIcon() + "] " + list.get(idx).description);
                continue;
            }

            if (echo.startsWith("unmark")) {
                idx = Integer.parseInt(echo.split(" ")[1]) - 1;
                list.get(idx).markAsNotDone();
                ui.showMessage("OK, I've marked this task as not done yet:");
                ui.showMessage("[" + list.get(idx).getStatusIcon() + "] " + list.get(idx).description);
                continue;
            }

            if (echo.startsWith(DEADLINE_PREFIX)) {
                try {
                    if (!echo.contains(BY_KEYWORD)) {
                        throw new FunkyException("Please enter a valid deadline command with /by.");
                    }
                } catch (FunkyException e) {
                    ui.showError(e.getMessage());
                    continue;
                }
                int byIndex = echo.indexOf(BY_KEYWORD);
                String description = echo.substring(DEADLINE_PREFIX.length(), byIndex - 1);
                String by = echo.substring(byIndex + BY_KEYWORD.length());

                list.add(new Deadline(description, by));
                save.save(list);
                ui.showMessage(list.get(list.size() - 1).toString());
                continue;
            }

            if (echo.startsWith(TODO_PREFIX)) {
                list.add(new ToDo(echo.substring(TODO_PREFIX.length())));
                save.save(list);
                ui.showLine();
                ui.showMessage(list.get(list.size() - 1).toString());
                ui.showLine();
                continue;
            }

            if (echo.startsWith(EVENT_PREFIX)) {
                try {
                    if (!echo.contains(FROM_KEYWORD) || !echo.contains("/to ")) {
                        throw new FunkyException("Please enter a valid event command with /from and /to.");
                    }
                } catch (FunkyException e) {
                    ui.showError(e.getMessage());
                    continue;
                }
                String[] parts = echo.split("/");
                String from = parts[1].trim().substring(4).trim(); // strip leading "from"
                String to = parts[2].trim().substring(2).trim(); // strip leading "to"
                String description = echo.substring(EVENT_PREFIX.length(), echo.indexOf(FROM_KEYWORD));
                list.add(new Event(description, from, to));
                save.save(list);
                ui.showMessage(list.get(list.size() - 1).toString());
                continue;
            }

            if (echo.startsWith(DELETE_PREFIX)) {
                new Delete(list, Integer.parseInt(echo.split(" ")[1]) - 1);
                save.save(list);
                continue;
            }
        }

        ui.showGoodbye();
    }
}