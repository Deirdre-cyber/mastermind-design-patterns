package com.example.model;

import com.example.mediator.GameMediator;

public class Game {
    private GameMediator gameMediator;

    public Game(GameMediator gameMediator) {
        this.gameMediator = gameMediator;
        this.gameMediator.setGame(this);
    }

    public void start() {
        gameMediator.startGame();
    }

}
