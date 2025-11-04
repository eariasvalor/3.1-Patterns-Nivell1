package undo_command_history;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Undo undo = Undo.getInstance();
        int option = 0;
        boolean exit = false;

        do{
            System.out.println("MENU");
            System.out.println("1. Add command");
            System.out.println("2. Remove last command");
            System.out.println("3. List commands");
            System.out.println("0. Exit");
            option = sc.nextInt();
            sc.nextLine();

            switch(option){
                case 1:
                    System.out.println("Please input your command:");
                    String commandEntry = sc.nextLine();
                    undo.addCommandEntry(commandEntry);
                    break;
                case 2:
                    undo.removeCommandEntry();
                    break;
                case 3:
                    undo.listCommandEntries();
                    break;
                case 0:
                    exit = true;
                    break;

            }

        } while(!exit);

        System.out.println("Exiting...");

    }
}
