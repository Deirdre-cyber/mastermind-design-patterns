package com.example.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.example.controller.PlayerController;
import com.example.factory.SolutionInitialisationStrategy;
import com.example.factory.SolutionInitialisationStrategyFactory;
import com.example.mediator.GameMediator;

//class for managing game logic
public class GameMode {
    private String name;
    private boolean gameIsWon;
    private int movesLeft;
    private char[] solution;
    private char[] colours;
    private int currentTurn;
    private GameDifficulty difficulty;
    private Player playerOne;
    private Player playerTwo;
    private GameMediator gameMediator;

    public GameMode(GameDifficulty difficulty, Player playerOne, Player playerTwo, GameMediator gameMediator) {
        this.difficulty = difficulty;
        this.name = difficulty.toString();
        this.gameIsWon = false;
        this.currentTurn = 1;
        this.movesLeft = 0;
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.gameMediator = gameMediator;

    }

    public GameDifficulty getDifficulty() {
        return difficulty;
    }

    public int getCurrentTurn() {
        return currentTurn;
    }

        public void updateTurn() {
        currentTurn++;
    }

    public boolean isGameFinished() {
        return gameIsWon || movesLeft == 0;
    }

    public int getMovesLeft() {
        return movesLeft;
    }

    public boolean isGameWon() {
        return gameIsWon;
    }

    public char[] getSolution() {
        return solution;
    }

    public void startGameMode() {
        gameMediator.displayStartGameModeMessage(name);
        gameMediator.initializeGameSettings();

        movesLeft = gameMediator.getNumGuesses();

        for (int i = 0; i < movesLeft && !isGameFinished(); i++) {
            int gameCount = i + 1;

            System.out.println("Starting game: " + gameCount);
            initialiseSolution(difficulty);
            System.out.println("Available colours: " + Arrays.toString(colours));

            gameMediator.getLineSeperator();

            for (int j = 0; j < movesLeft && !isGameFinished(); j++) {
                System.out.println("Turn: " + (j + 1));
                makeMove(playerOne);
                if (gameIsWon) {
                    break;
                }
            }
        }
    }

    private void makeMove(Player player) {

        if (player.getPlayerType() == PlayerType.HUMAN) {
            handleHumanPlayerMove(player);
        } else {
            handleComputerPlayerMove(player);
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

    private void handleHumanPlayerMove(Player player) {
        PlayerController playerController = new PlayerController(this);
        playerController.makeMove(player);
        char[] guess = player.getLastMove();
        String[] hints = compareCode(guess, solution);
        gameMediator.displayGuessesAndHints(guess, hints);
    }

    private void handleComputerPlayerMove(Player player) {
        gameMediator.getLineSeperator();
        System.out.println("Computer " + player.getName() + " is making a move...");

        PlayerController playerController = new PlayerController(this);
        char[] guess = playerController.generateRandomMove();
        String[] hints = compareCode(guess, solution);
        gameMediator.displayGuessesAndHints(guess, hints);
    }

    public void initialiseSolution(GameDifficulty difficulty) {
        SolutionInitialisationStrategyFactory strategyFactory = new SolutionInitialisationStrategyFactory();
        SolutionInitialisationStrategy strategy = strategyFactory.getStrategy(difficulty);
        colours = strategy.initialiseSolution();
        solution = generateRandomSolution(colours);
    }

    private char[] generateRandomSolution(char[] colours) {
        final int SOLUTION_LENGTH = 4;
        char[] code = new char[SOLUTION_LENGTH];

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

    private boolean checkWin(String[] hints) {
        for (String hint : hints) {
            if (!hint.equals("O")) {
                return false;
            }
        }
        return true;
    }

}