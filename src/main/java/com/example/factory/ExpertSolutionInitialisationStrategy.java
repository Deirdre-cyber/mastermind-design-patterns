package com.example.factory;

import com.example.model.GameDifficulty;

public class ExpertSolutionInitialisationStrategy implements SolutionInitialisationStrategy {

    @Override
    public char[] initialiseSolution() {
        return new char[] { 'w', 'y', 'o', 'r', 'p', 'b', 'g', 'v', 'c', 'm' };
    }

    @Override
    public GameDifficulty chooseGameDifficulty() {
        return GameDifficulty.EXPERT;
    }

}
