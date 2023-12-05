package com.example.controller;

import java.util.Scanner;

//responsible for managing the game settings
public class GameController {

    private int numGames;
    private int numGuesses;
    private Scanner scanner = new Scanner(System.in);

    public GameController() {
    }

    public int getNumGuesses() {
        return numGuesses;
    }

    public int getNumGames() {
        return numGames;
    }

    public int promptForNumberOfGames() {
        System.out.println("Enter the number of games (1 - 10):");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number between 1 and 10.");
            scanner.next();
        }
        return scanner.nextInt();
    }

    public int promptForNumberOfGuesses() {
        System.out.println("Enter the number of guesses (1 - 10):");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number between 1 and 10.");
            scanner.next();
        }
        return scanner.nextInt();
    }

    public void setNumberOfGames() {
        do {
            numGames = this.promptForNumberOfGames();
        } while (numGames < 1 || numGames > 10);
    }

    public void setNumberOfGuesses() {
        do {
            numGuesses = this.promptForNumberOfGuesses();
        } while (this.numGuesses < 1 || this.numGuesses > 10);
    }  
}
