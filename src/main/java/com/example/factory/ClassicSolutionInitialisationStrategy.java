package com.example.factory;

import com.example.model.GameDifficulty;

public class ClassicSolutionInitialisationStrategy implements SolutionInitialisationStrategy{
    
        @Override
        public char[] initialiseSolution() {
            return new char[] { 'w', 'y', 'o', 'r', 'p', 'b', 'g', 'v' };
        }

        @Override
        public GameDifficulty chooseGameDifficulty() {
            return GameDifficulty.CLASSIC;
        }
}
