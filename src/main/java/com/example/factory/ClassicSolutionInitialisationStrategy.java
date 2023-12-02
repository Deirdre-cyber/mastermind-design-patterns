package com.example.factory;

public class ClassicSolutionInitialisationStrategy implements SolutionInitialisationStrategy{
    
        @Override
        public char[] initialiseSolution() {
            return new char[] { 'w', 'y', 'o', 'r', 'p', 'b', 'g', 'v' };
        }

}
