package com.example.controller;

import java.security.SecureRandom;
import java.util.Scanner;

import com.example.factory.SolutionInitialisationStrategyFactory;
import com.example.model.GameMode;
import com.example.model.Player;
import com.example.model.PlayerType;
import com.example.strategy.SolutionInitialisationStrategy;

public class PlayerController {
    
    private GameMode gameMode;

    public PlayerController(GameMode gameMode) {
        this.gameMode = gameMode;
    }

    public void makeMove(Player player) {
        char[] guess;

        if (player.getPlayerType() == PlayerType.HUMAN) {
            guess = getUserInputGuess(player);
        } else {
            guess = generateRandomMove();
        }

        gameMode.placeMove(player, guess);
        player.setLastMove(guess);
        player.setLastHints(gameMode.compareCode(guess, gameMode.getSolution()));
    }

    public char[] getUserInputGuess(Player player) {
        Scanner scanner = new Scanner(System.in);
        char[] guess = new char[4];
    
        System.out.println("Enter your guess (4 characters) " + player.getName() + ":");
        for (int i = 0; i < 4; i++) {
            guess[i] = scanner.next().charAt(0);
        }
    
        return guess;
    }

    public char[] generateRandomMove() {
        SolutionInitialisationStrategyFactory strategyFactory = new SolutionInitialisationStrategyFactory();
        SolutionInitialisationStrategy strategy = strategyFactory.getStrategy(gameMode.getDifficulty());
        char[] colours = strategy.initialiseSolution();
    
        char[] code = new char[4];
    
        for (int i = 0; i < code.length; i++) {
            //6.3.4 Security hotspots addresses - Weak Cryptography
            SecureRandom random = new SecureRandom();
            int randomIndex = random.nextInt(colours.length);
            code[i] = colours[randomIndex];
        }
        return code;
    }
    
}
