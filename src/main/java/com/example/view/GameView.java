package com.example.view;

import java.util.Scanner;

import com.example.model.GameDifficulty;

public class GameView {

    private static final String LINE_SEPERATOR = "-----------------------------------";

    // set as singleton

    public void displayWelcomeMessage() {
        System.out.println("Welcome to");
        System.out.println("   _____                   __                       .__            .___");
        System.out.println("  /     \\ _____    _______/  |_  ___________  _____ |__| ____    __| _/");
        System.out.println(" /  \\ /  \\__  \\  /  ___/\\   __\\/ __ \\_  __ \\/     \\|  |/    \\  / __ | ");
        System.out.println("/    Y    \\/ __ \\_\\___ \\  |  | \\  ___/|  | \\/  Y Y  \\  |   |  \\/ /_/ | ");
        System.out.println("\\____|__  (____  /____  > |__|  \\___  >__|  |__|_|  /__|___|  /\\____ | ");
        System.out.println("        \\/     \\/     \\/            \\/            \\/        \\/      \\/");
    }

    public String getLineSeperator() {
        return LINE_SEPERATOR;
    }

    public GameDifficulty chooseGameDifficulty(Scanner scanner) {
        System.out.println("Enter game difficulty ((CH)ILDREN, (CL)ASSIC, (E)XPERT):");
        String input = scanner.nextLine().toUpperCase();
        System.out.println(LINE_SEPERATOR);
        
        GameDifficulty gameDifficulty;

        switch (input) {
            case "CH":
                gameDifficulty = GameDifficulty.CHILDREN;
                break;
            case "CL":
                gameDifficulty = GameDifficulty.CLASSIC;
                break;
            case "E":
                gameDifficulty = GameDifficulty.EXPERT;
                break;
            default:
                System.out.println("Invalid input. Defaulting to CLASSIC.");
                gameDifficulty = GameDifficulty.CLASSIC;
                break;
        }
        return gameDifficulty;
    }

    public String choosePlayerName(Scanner scanner) {
        System.out.println("Enter player one name:");
        return scanner.nextLine();
    }

    public String generatePlayerName() {
        String[] names = { "John", "Jane", "Bob", "Alice", "Jack", "Jill", "Bill", "Ben", "Sam", "Sally" };
        int randomIndex = (int) (Math.random() * names.length);
        return names[randomIndex].toUpperCase();
    }

    public void displayInBox(String content) {
        int length = content.length();
        printLine(length);
        System.out.println("| " + content + " |");
        printLine(length);
    }

    public void printLine(int length) {
        System.out.print("+");
        for (int i = 0; i < length + 2; i++) {
            System.out.print("-");
        }
        System.out.println("+");
    }
}
