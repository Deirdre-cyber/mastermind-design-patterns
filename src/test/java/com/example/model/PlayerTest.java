package com.example.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class PlayerTest {

    @Test
    public void testGetName() {
        Player player = new Player("John", PlayerType.HUMAN);
        assertEquals("John", player.getName());
    }

    @Test
    public void testGetPlayerType() {
        Player player = new Player("John", PlayerType.HUMAN);
        assertEquals(PlayerType.HUMAN, player.getPlayerType());
    }

    @Test
    public void testSetGameMode() {
        Player player = new Player("John", PlayerType.HUMAN);
        GameMode gameMode = new GameMode(GameDifficulty.CLASSIC, player, new Player("AI", PlayerType.COMPUTER), null, null);
        player.setGameMode(gameMode);
        assertEquals(gameMode, player.getGameMode());
    }

    @Test
    public void testSetWins() {
        Player player = new Player("John", PlayerType.HUMAN);
        player.setWins(3);
        assertEquals(3, player.getWins());
    }

    @Test
    public void testGenerateRandomMoveComputer() {
        Player player = new Player("AI", PlayerType.COMPUTER);
        GameMode gameMode = new GameMode(GameDifficulty.CLASSIC, player, new Player("Human", PlayerType.HUMAN), null, null);
        player.setGameMode(gameMode);

        char[] randomMove = player.generateRandomMove();

        assertNotNull(randomMove);
        assertEquals(4, randomMove.length);
    }
}
