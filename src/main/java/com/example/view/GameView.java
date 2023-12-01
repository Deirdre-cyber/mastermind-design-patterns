package com.example.view;

import java.util.Arrays;

import com.example.model.GameMode;

public class GameView {

    private static final String LINE_SEPERATOR = "-----------------------------------";


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

    public void displayGuessesAndHints(char[] guess, String[] hints) {
        int boxWidth = 30;

        printBorder(boxWidth);

        printRow("Guess:", guess, boxWidth);

        printRow("Hints:", hints, boxWidth);

        printBorder(boxWidth);

        System.out.println("O = correct colour, correct position");
        System.out.println("X = correct colour, wrong position");
        System.out.println("_ = wrong colour");
        System.out.println();
    }

    private void printRow(String label, char[] data, int boxWidth) {
        System.out.print("| " + label + " ");
        for (char c : data) {
            System.out.print(c + " ");
        }

        for (int i = label.length() + data.length * 2 + 2; i < boxWidth - 1; i++) {
            System.out.print(" ");
        }

        System.out.println("|");
    }

    private void printRow(String label, String[] data, int boxWidth) {
        System.out.print("| " + label + " ");
        for (String value : data) {
            System.out.print(value + " ");
        }

        for (int i = label.length() + data.length * 2 + 2; i < boxWidth - 1; i++) {
            System.out.print(" ");
        }

        System.out.println("|");
    }

    private void printBorder(int boxWidth) {
        for (int i = 0; i < boxWidth; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public void displayResult(GameMode gameMode, char[] solution) {
        if (gameMode.isGameFinished()) {
            if (gameMode.getGameIsWon()) {
                System.out.println("Congratulations! You won!");
            } else {
                System.out.println("Game over. You lost!");
                if (!gameMode.getGameIsWon()) {
                    System.out.println("Correct answer was: ");
                    displayInBox(Arrays.toString(solution));
                }
            }
        } else {
            System.out.println("Game is not finished yet!");
        }
    }

}
