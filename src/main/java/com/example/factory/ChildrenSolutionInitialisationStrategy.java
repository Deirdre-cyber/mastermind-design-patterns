package com.example.factory;

public class ChildrenSolutionInitialisationStrategy implements SolutionInitialisationStrategy {

    @Override
    public char[] initialiseSolution() {
        return new char[] { 'r', 'g', 'b', 'y' };
    }

}
