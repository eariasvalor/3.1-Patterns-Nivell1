package undo_command_history;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Undo {
    private static Undo instance;
    private List<String> commandEntries;

    private Undo() {
        commandEntries = new ArrayList<>();
    }

    public static Undo getInstance() {
        if (instance == null) {
            instance = new Undo();
        }
        return instance;
    }

    public List<String> getCommandEntries() {
        return Collections.unmodifiableList(commandEntries);
    }

    public void addCommandEntry(String commandEntry) {
        commandEntries.add(commandEntry);
        System.out.println("Command successfully added.");
    }


    public void removeCommandEntry() {
        if (!commandEntries.isEmpty()) {
            commandEntries.remove(commandEntries.size() - 1);
            System.out.println("Command successfully removed.");
        } else {
            System.out.println("There are no entries to remove.");
        }
    }

    public void listCommandEntries() {
        if (commandEntries.isEmpty()) {
            System.out.println("There are no commands to show.");
        } else {
            System.out.println("These are the existing commands:");
            for (String command : commandEntries) {
                System.out.println(command);
            }
        }
    }

    void clear() {
        commandEntries.clear();
    }
}




