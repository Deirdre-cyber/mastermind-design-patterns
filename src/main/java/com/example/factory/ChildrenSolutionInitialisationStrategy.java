package com.example.factory;

import com.example.model.GameDifficulty;

public class ChildrenSolutionInitialisationStrategy implements SolutionInitialisationStrategy {

    @Override
    public char[] initialiseSolution() {
        return new char[] { 'r', 'g', 'b', 'y' };
    }

    @Override
    public GameDifficulty chooseGameDifficulty() {
        return GameDifficulty.CHILDREN;
    }

}
