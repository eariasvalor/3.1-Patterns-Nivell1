package undo_command_history;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UndoTest {
    @Test
    void testSingleInstance() {
        Undo undo1 = Undo.getInstance();
        Undo undo2 = Undo.getInstance();
        assertSame(undo1, undo2, "Both references should point to the same instance");
    }

    @Test
    void testAddCommandEntries(){
        Undo undo = Undo.getInstance();
        undo.clear();
        undo.addCommandEntry("Open file");
        List<String> commands = undo.getCommandEntries();

        assertEquals(1, commands.size());
        assertEquals("Open file", commands.get(0));

    }


    @Test
    void testRemoveCommandEntries(){
        Undo undo = Undo.getInstance();
        undo.clear();
        undo.addCommandEntry("Open file");
        undo.addCommandEntry("Close file");
        undo.removeCommandEntry();

        List<String> commands = undo.getCommandEntries();

        assertEquals(1, commands.size());
        assertEquals("Open file", commands.get(0));
        undo.clear();
    }

    @Test
    void testListCommandEntriesPrintsCommands() {
        Undo undo = Undo.getInstance();
        undo.clear();
        undo.addCommandEntry("cmd1");
        undo.addCommandEntry("cmd2");

        PrintStream originalOut = System.out;
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        try {
            undo.listCommandEntries();
        } finally {
            System.setOut(originalOut);
        }

        String printed = output.toString();
        assertTrue(printed.contains("These are the existing commands:"));
        assertTrue(printed.contains("cmd1"));
        assertTrue(printed.contains("cmd2"));
    }


}