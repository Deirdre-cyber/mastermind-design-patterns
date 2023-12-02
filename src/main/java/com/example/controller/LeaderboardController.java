package com.example.controller;

import com.example.model.GameDifficulty;
import com.example.model.Player;

public class LeaderboardController {
    

        public int calculateScore(Player player, int movesLeft, GameDifficulty difficulty) {

        int difficultyBonus = 0;
        int score = movesLeft * 1000;

         //use map with strategy pattern
        switch (difficulty) {
            case CHILDREN:
                difficultyBonus = 5;
                break;
            case CLASSIC:
                difficultyBonus = 10;
                break;
            case EXPERT:
                difficultyBonus = 15;
                break;
            default:
                break;
        }

        return score + difficultyBonus;
    }
}
