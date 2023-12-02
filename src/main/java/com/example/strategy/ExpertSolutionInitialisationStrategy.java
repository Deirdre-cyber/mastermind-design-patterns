package com.example.strategy;

public class ExpertSolutionInitialisationStrategy implements SolutionInitialisationStrategy {

    @Override
    public char[] initialiseSolution() {
        return new char[] { 'w', 'y', 'o', 'r', 'p', 'b', 'g', 'v', 'c', 'm' };
    }
}
