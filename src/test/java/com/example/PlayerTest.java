package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class PlayerTest {

    @Test
    void testGetName() {
        Player player = new Player("John", PlayerType.HUMAN);
        assertEquals("John", player.getName());
    }

    @Test
    void testGetPlayerType() {
        Player player = new Player("John", PlayerType.HUMAN);
        assertEquals(PlayerType.HUMAN, player.getPlayerType());
    }

    @Test
    void testSetGameMode() {
        Player player = new Player("John", PlayerType.HUMAN);
        GameMode gameMode = new GameMode(GameDifficulty.CLASSIC, player, new Player("AI", PlayerType.COMPUTER));
        player.setGameMode(gameMode);
        assertEquals(gameMode, player.getGameMode());
    }

    @Test
    void testSetWins() {
        Player player = new Player("John", PlayerType.HUMAN);
        player.setWins(3);
        assertEquals(3, player.getWins());
    }

    @Test
    void testGenerateRandomMoveComputer() {
        Player player = new Player("AI", PlayerType.COMPUTER);
        GameMode gameMode = new GameMode(GameDifficulty.CLASSIC, player, new Player("Human", PlayerType.HUMAN));
        player.setGameMode(gameMode);

        char[] randomMove = player.generateRandomMove();

        assertNotNull(randomMove);
        assertEquals(4, randomMove.length);
    }
}
