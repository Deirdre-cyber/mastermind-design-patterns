package com.example.model;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.example.view.GameView;

import static org.mockito.Mockito.*;

public class GameTest {

    @Test
    public void testGameStart() {
        Player playerOne = Mockito.mock(Player.class);
        Player playerTwo = Mockito.mock(Player.class);
        GameMode gameMode = Mockito.mock(GameMode.class);
        GameView gameView = Mockito.mock(GameView.class);
        Leaderboard leaderboard = Mockito.mock(Leaderboard.class);

        Game game = new Game(playerOne, playerTwo, gameMode, leaderboard, gameView);

        when(gameMode.isGameFinished()).thenReturn(true);

        game.start();

        verify(gameMode, times(1)).startGame();
        //verify(gameView, times(1)).displayResult(gameMode, new char[]{});
        verify(leaderboard, times(1)).update(playerOne, playerTwo);
    }
}
