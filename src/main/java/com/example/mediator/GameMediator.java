package com.example.mediator;

import java.util.Map;
import java.util.Scanner;

import com.example.controller.GameController;
import com.example.factory.ComputerPlayerFactory;
import com.example.factory.HumanPlayerFactory;
import com.example.factory.PlayerFactory;
import com.example.model.*;
import com.example.view.GameView;

public class GameMediator {
    private GameController gameController;
    private GameView gameView;
    private GameMode gameMode;
    private Leaderboard leaderboard;
    private Player playerOne;
    private Player playerTwo;
    private Game game;
    private Scanner scanner;

    public GameMediator(GameController gameController, GameView gameView) {
        this.gameController = gameController;
        this.gameView = gameView;
        this.scanner = new Scanner(System.in);
    }

    public Game initializeGame() {
        game = null;

        while (game == null) {
            try {
                gameView.displayWelcomeMessage();
                GameDifficulty gameDifficulty = chooseGameDifficulty();
                initializePlayers();
                initialiseGameMode(gameDifficulty);

                gameView.displayStartGameMessage(playerOne.getName(), playerTwo.getName());

                leaderboard = Leaderboard.getInstance();
                game = new Game(playerOne, playerTwo, this);

            } catch (IllegalArgumentException e) {
                System.out.println("Invalid input. Please enter a valid game difficulty.");
            }
        }

        return game;
    }

    public void startGame() {

        gameMode.startGameMode();
        gameView.displayResult(gameMode, gameMode.getSolution());
        leaderboard.updateLeaderboard(playerOne, playerTwo);
    }

    public void setGame(Game game) {
        this.game = game;
    }

    private void initializePlayers() {
        PlayerFactory humanPlayerFactory = new HumanPlayerFactory();
        String playerOneName = this.choosePlayerName();
        playerOne = humanPlayerFactory.createPlayer(playerOneName);

        gameView.getLineSeperator();

        PlayerFactory computerPlayerFactory = new ComputerPlayerFactory();
        String playerTwoName = gameView.generateComputerPlayerName();
        playerTwo = computerPlayerFactory.createPlayer(playerTwoName);
    }

    private void initialiseGameMode(GameDifficulty gameDifficulty) {
        gameMode = new GameMode(gameDifficulty, playerOne, playerTwo, this);
        playerOne.setGameMode(gameMode);
        playerTwo.setGameMode(gameMode);
    }

    private GameDifficulty chooseGameDifficulty() {
        System.out.println("Enter game difficulty ((CH)ILDREN, (CL)ASSIC, (E)XPERT):");
    
        String input = scanner.nextLine().toUpperCase();
        gameView.getLineSeperator();
    
        Map<String, GameDifficulty> difficultyMap = Map.of(
                "CH", GameDifficulty.CHILDREN,
                "CL", GameDifficulty.CLASSIC,
                "E", GameDifficulty.EXPERT);
    
        try {
            return difficultyMap.getOrDefault(input, GameDifficulty.CLASSIC);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid input. Defaulting to CLASSIC.");
            return GameDifficulty.CLASSIC;
        }
    }
    
    public String choosePlayerName() {
        System.out.println("Enter player one name:");
        return scanner.nextLine();
    }

    public void initialiseGameSettings() {
        gameController.setNumberOfGames();
        gameController.setNumberOfGuesses();
    }

    public void displayStartGameModeMessage(String name) {
        gameView.displayStartGameModeMessage(name);
    }

    public void getLineSeperator() {
        gameView.getLineSeperator();
    }

    public void displayGuessesAndHints(char[] guess, String[] hints) {
        gameView.displayGuessesAndHints(guess, hints);
    }

    public int getNumGuesses() {
        return gameController.getNumGuesses();
    }
}
