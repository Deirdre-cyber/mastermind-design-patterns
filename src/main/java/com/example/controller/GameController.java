package com.example.controller;

import java.util.Scanner;

import com.example.model.GameDifficulty;
import com.example.view.GameView;

public class GameController {

    private GameView gameView;
    private Scanner scanner = new Scanner(System.in);

    public GameController(GameView gameView) {
        this.gameView = gameView;
    }

    public GameDifficulty chooseGameDifficulty() {
        System.out.println("Enter game difficulty ((CH)ILDREN, (CL)ASSIC, (E)XPERT):");
        String input = scanner.nextLine().toUpperCase();

        System.out.println(gameView.getLineSeperator());

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

    public String choosePlayerName() {
        System.out.println("Enter player one name:");
        return scanner.nextLine();
    }

    public int promptForNumberOfGames() {
        System.out.println("Enter the number of games (1 - 10):");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number between 1 and 10.");
            scanner.next();
        }
        gameView.getLineSeperator();
        return scanner.nextInt();
    }

    public int promptForNumberOfGuesses() {
        System.out.println("Enter the number of guesses (1 - 10):");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number between 1 and 10.");
            scanner.next();
        }
        gameView.getLineSeperator();
        return scanner.nextInt();
    }
}
