package com.example.model;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;

public class GameModeTest {

    @Test
    public void testInitializeSolution() {
        GameMode gameMode = new GameMode(GameDifficulty.CLASSIC, new Player("Player1", PlayerType.HUMAN), new Player("Player2", PlayerType.COMPUTER), null);
        gameMode.initializeSolution(GameDifficulty.CLASSIC);
        assertNotNull(gameMode.getSolution());
        assertEquals(4, gameMode.getSolution().length);
    }

    @Test
    public void testCompareCode() {

        Player player = mock(Player.class);
        GameMode gameMode = new GameMode(GameDifficulty.CLASSIC, player, player, null);
        gameMode.initializeSolution(GameDifficulty.CLASSIC);

    }
}
