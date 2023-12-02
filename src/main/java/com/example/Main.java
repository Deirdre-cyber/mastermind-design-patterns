
package com.example;

import com.example.controller.GameController;
import com.example.mediator.GameMediator;
import com.example.model.Game;
import com.example.view.GameView;

public class Main {

    public static void main(String[] args) {

        GameView gameView = new GameView();
        GameController gameController = new GameController();
        GameMediator gameMediator = new GameMediator(gameController, gameView);
        Game game = gameMediator.initializeGame();

        game.start();
    }
}
