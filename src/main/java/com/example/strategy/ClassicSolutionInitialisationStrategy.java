package com.example.strategy;

public class ClassicSolutionInitialisationStrategy implements SolutionInitialisationStrategy {

    @Override
    public char[] initialiseSolution() {
        return new char[] { 'w', 'y', 'o', 'r', 'p', 'b', 'g', 'v' };
    }
}
