package com.example.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.example.controller.GameController;
import com.example.view.GameView;

public class GameMode {
    private String name;
    private boolean gameIsWon;
    private int movesLeft;
    private char[] solution;
    private char[] colours;
    private int numGames;
    private int numGuesses;
    private int currentTurn;
    private GameDifficulty difficulty;
    private Player playerOne;
    private Player playerTwo;
    private GameView gameView;
    private GameController gameController;

    public GameMode(GameDifficulty difficulty, Player playerOne, Player playerTwo, GameView gameView, GameController gameController) {
        this.difficulty = difficulty;
        this.name = difficulty.toString();
        this.gameIsWon = false;
        this.currentTurn = 1;
        this.movesLeft = 0;
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.gameView = gameView;
        this.gameController = gameController;

    }

    public GameDifficulty getDifficulty() {
        return difficulty;
    }

    public int getCurrentTurn() {
        return currentTurn;
    }

    public boolean isGameFinished() {
        return gameIsWon || movesLeft == 0;
    }

    public void updateTurn() {
        currentTurn++;
    }

    public int getMovesLeft() {
        return movesLeft;
    }

    public boolean getGameIsWon() {
        return gameIsWon;
    }

    public Player getPlayerOne() {
        return playerOne;
    }

    public char[] getSolution() {
        return solution;
    }

    public void startGame() {

        System.out.println("Starting game mode: " + name);

        gameView.getLineSeperator();

        setNumberOfGames();
        setNumberOfGuesses();

        gameView.getLineSeperator();

        movesLeft = numGuesses;

        for (int i = 0; i < numGames && !isGameFinished(); i++) {
            int gameCount = i + 1;
            System.out.println("Starting game: " + gameCount);

            initializeSolution(difficulty);
            System.out.println("Available colours: " + Arrays.toString(colours));

            for (int j = 0; j < numGuesses && !isGameFinished(); j++) {
                System.out.println("Turn: " + (j + 1));

                makeMove(playerOne);

                if (gameIsWon) {
                    break;
                }
            }
        }
    }

    private void setNumberOfGames() {
        do {
            numGames = gameController.promptForNumberOfGames();
        } while (numGames < 1 || numGames > 10);
    }

    private void setNumberOfGuesses() {
        do {
            numGuesses = gameController.promptForNumberOfGuesses();
        } while (this.numGuesses < 1 || this.numGuesses > 10);
    }

    public void makeMove(Player player) {
        char[] guess;
        String[] hints;

        if (player.getPlayerType() == PlayerType.HUMAN) {
            player.makeMove();
            guess = player.getLastMove();
            hints = compareCode(guess, solution);
            gameView.displayGuessesAndHints(guess, hints);
        } else {
            gameView.getLineSeperator();
            System.out.println("Computer " + player.getName() + " is making a move...");
            guess = player.generateRandomMove();
            hints = compareCode(guess, solution);
            gameView.displayGuessesAndHints(guess, hints);
        }

        if (!isGameFinished()) {
            if (player == playerOne) {
                makeMove(playerTwo);
            } else {
                movesLeft--;
                updateTurn();
            }
        }
    }

    public void initializeSolution(GameDifficulty difficulty) {
        switch (difficulty) {
            case CHILDREN:
                colours = new char[] { 'r', 'g', 'b', 'y' };
                break;
            case CLASSIC:
                colours = new char[] { 'w', 'y', 'o', 'r', 'p', 'b', 'g', 'v' };
                break;
            case EXPERT:
                colours = new char[] { 'w', 'y', 'o', 'r', 'p', 'b', 'g', 'v', 'c', 'm' };
                break;
            default:
                throw new IllegalArgumentException("Invalid difficulty level");
        }

        solution = generateRandomSolution(colours);
    }

    private char[] generateRandomSolution(char[] colours) {
        char[] code = new char[4];

        List<Character> colourList = new ArrayList<>();
        for (char colour : colours) {
            colourList.add(colour);
        }

        for (int i = 0; i < code.length; i++) {
            int randomIndex = (int) (Math.random() * colourList.size());
            code[i] = colourList.remove(randomIndex);
        }

        return code;
    }

    public void placeMove(Player player, char[] guess) {

        String[] hints = compareCode(guess, solution);

        if (checkWin(hints)) {
            gameIsWon = true;
        }
        updateTurn();
    }

    public String[] compareCode(char[] guess, char[] solution) {
        String[] hints = new String[guess.length];

        for (int i = 0; i < guess.length; i++) {
            if (guess[i] == solution[i]) {
                hints[i] = "O";
            }
        }

        for (int i = 0; i < guess.length; i++) {
            if (hints[i] == null) {
                for (int j = 0; j < solution.length; j++) {
                    if (hints[j] == null && guess[i] == solution[j]) {
                        hints[j] = "X";
                    }
                }
            }
        }

        for (int i = 0; i < hints.length; i++) {
            if (hints[i] == null) {
                hints[i] = "_";
            }
        }

        return hints;
    }

    public boolean checkWin(String[] hints) {
        for (String hint : hints) {
            if (!hint.equals("O")) {
                return false;
            }
        }
        return true;
    }

}