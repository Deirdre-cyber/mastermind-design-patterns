package com.example.model;

import com.example.view.GameView;

public class Game {
    private Player playerOne;
    private Player playerTwo;
    private GameMode gameMode;
    private GameView gameView;
    private Leaderboard leaderboard;

    public Game(Player playerOne, Player playerTwo, GameMode gameMode, Leaderboard leaderboard, GameView gameView) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.gameMode = gameMode;
        this.leaderboard = leaderboard;
        this.gameView = gameView;
    }

    public void start() {
        gameMode.startGame();
        gameView.displayResult(gameMode, gameMode.getSolution());
        leaderboard.update(playerOne, playerTwo);
    }

}
