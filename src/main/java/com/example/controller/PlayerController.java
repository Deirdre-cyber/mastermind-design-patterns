package com.example.controller;

import java.util.Scanner;

import com.example.model.GameMode;
import com.example.model.Player;
import com.example.model.PlayerType;

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
        char[] colors;
        
        switch (gameMode.getDifficulty()) {
            case CHILDREN:
                colors = new char[]{'r', 'g', 'b', 'y'};
                break;
            case CLASSIC:
                colors = new char[]{'w', 'y', 'o', 'r', 'p', 'b', 'g', 'v'};
                break;
            case EXPERT:
                colors = new char[]{'w', 'y', 'o', 'r', 'p', 'b', 'g', 'v', 'c', 'm'};
                break;
            default:
                throw new IllegalArgumentException("Invalid difficulty level");
        }
    
        char[] code = new char[4];
    
        for (int i = 0; i < code.length; i++) {
            int randomIndex = (int) (Math.random() * colors.length);
            code[i] = colors[randomIndex];
        }
        return code;
    }
    
}
