package com.example;

import org.junit.jupiter.api.Test;

import com.example.model.GameDifficulty;
import com.example.model.GameMode;
import com.example.model.Player;
import com.example.model.PlayerType;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;

public class GameModeTest {

    @Test
    public void testInitializeSolution() {
        GameMode gameMode = new GameMode(GameDifficulty.CLASSIC, new Player("Player1", PlayerType.HUMAN), new Player("Player2", PlayerType.COMPUTER));
        gameMode.initializeSolution(GameDifficulty.CLASSIC);
        assertNotNull(gameMode.getSolution());
        assertEquals(4, gameMode.getSolution().length);
    }

        @Test
    public void testCompareCode() {
        
        Player player = mock(Player.class);
        GameMode gameMode = new GameMode(GameDifficulty.CLASSIC, player, player);
        gameMode.initializeSolution(GameDifficulty.CLASSIC);

        when(player.getLastMove()).thenReturn(new char[]{'a', 'b', 'c', 'd'});
        char[] solution = new char[]{'e','f','g','h'};
        String[] hints = gameMode.compareCode(player.getLastMove(), solution);

        assertArrayEquals(new String[]{"_", "_", "_", "_"}, hints);
    }


    @Test
    public void testCheckWin() {
        GameMode gameMode = new GameMode(GameDifficulty.CLASSIC, new Player("Player1", PlayerType.HUMAN), new Player("Player2", PlayerType.COMPUTER));
        gameMode.initializeSolution(GameDifficulty.CLASSIC);

        assertFalse(gameMode.checkWin(new String[]{"X", "_", "O", "X"}));
        assertTrue(gameMode.checkWin(new String[]{"O", "O", "O", "O"}));
    }

}
