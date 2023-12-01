
package com.example;

import java.util.Scanner;

import com.example.controller.GameController;
import com.example.model.ComputerPlayerFactory;
import com.example.model.Game;
import com.example.model.GameDifficulty;
import com.example.model.GameMode;
import com.example.model.HumanPlayerFactory;
import com.example.model.Leaderboard;
import com.example.model.Player;
import com.example.model.PlayerFactory;
import com.example.view.GameView;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Game game = null;
        GameView gameView = new GameView();
        GameController gameController = new GameController(gameView);
        

        while (game == null) {
            try {
                gameView.displayWelcomeMessage();

                GameDifficulty gameDifficulty = gameController.chooseGameDifficulty(scanner);

                PlayerFactory humanPlayerFactory = new HumanPlayerFactory();
                String playerOneName = gameController.choosePlayerName(scanner);
                Player playerOne = humanPlayerFactory.createPlayer(playerOneName);

                gameView.getLineSeperator();

                PlayerFactory computerPlayerFactory = new ComputerPlayerFactory();
                String playerTwoName = gameView.generatePlayerName();
                Player playerTwo = computerPlayerFactory.createPlayer(playerTwoName);

                GameMode gameMode = new GameMode(gameDifficulty, playerOne, playerTwo, gameView, gameController);
                
                playerOne.setGameMode(gameMode);
                playerTwo.setGameMode(gameMode);

                System.out.println("Let's play " + playerOne.getName() + " and " + playerTwo.getName() + "!");

                gameView.getLineSeperator();

                Leaderboard leaderboard = Leaderboard.getInstance();
                game = new Game(playerOne, playerTwo, gameMode, leaderboard, gameView);

            } catch (IllegalArgumentException e) {
                System.out.println("Invalid input. Please enter a valid game difficulty.");
            }
        }

        game.start();
    }

}
