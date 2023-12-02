package com.example.strategy;

public class ChildrenSolutionInitialisationStrategy implements SolutionInitialisationStrategy {

    @Override
    public char[] initialiseSolution() {
        return new char[] { 'r', 'g', 'b', 'y' };
    }

}
