package com.example.model;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.example.controller.LeaderboardController;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class LeaderboardTest {
    
    Leaderboard leaderboard = Mockito.spy(Leaderboard.getInstance());

    @Test
    public void testUpdateLeaderboard() {
        

        Player playerOne = Mockito.mock(Player.class);
        Player playerTwo = Mockito.mock(Player.class);
        GameMode gameModeOne = Mockito.mock(GameMode.class);
        GameMode gameModeTwo = Mockito.mock(GameMode.class);

        when(playerOne.getGameMode()).thenReturn(gameModeOne);
        when(playerTwo.getGameMode()).thenReturn(gameModeTwo);
        when(gameModeOne.getMovesLeft()).thenReturn(5);
        when(gameModeTwo.getMovesLeft()).thenReturn(8);
        when(gameModeOne.getDifficulty()).thenReturn(GameDifficulty.CLASSIC);
        when(gameModeTwo.getDifficulty()).thenReturn(GameDifficulty.EXPERT);

        gameModeOne.updateTurn();
        gameModeTwo.updateTurn();

        leaderboard.updateLeaderboard(playerOne, playerTwo);

        verify(leaderboard, times(1)).updateLeaderboard(playerOne, playerTwo);
    }

    @Test
    public void testCalculateScore() {

        Player player = new Player("Bob", PlayerType.HUMAN);
        GameMode gameMode = new GameMode(GameDifficulty.CHILDREN, player, null, null);
        player.setGameMode(gameMode);
        gameMode.updateTurn();
        LeaderboardController leaderboardController = new LeaderboardController();
        int score = leaderboardController.calculateScore(gameMode.getMovesLeft(), gameMode.getDifficulty());

        assertEquals(5, score);
    }


}
