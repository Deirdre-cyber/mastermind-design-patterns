package com.example.model;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.example.mediator.GameMediator;

import static org.mockito.Mockito.*;

public class GameTest {

   @Test
    public void testGameStart() {
        GameMediator gameMediator = Mockito.mock(GameMediator.class);
        Game game = new Game(gameMediator);
        game.start();
        verify(gameMediator, times(1)).startGame();
    }
}
