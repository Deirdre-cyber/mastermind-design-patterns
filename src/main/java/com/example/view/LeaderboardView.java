package com.example.view;

import java.util.List;
import java.util.logging.Logger;

import com.example.model.PlayerScore;

public class LeaderboardView {

    Logger logger = Logger.getLogger(LeaderboardView.class.getName());

    public void displayLeaderboard(List<PlayerScore> scores) {
        int boxWidth = 30;
    
        printBorder(boxWidth);
    
        System.out.println("| Leaderboard:");
        System.out.println("| Player\t\tScore");
    
        for (PlayerScore score : scores) {
            printRow("| " + score.getPlayerName(), "\t\t" + score.getScore(), boxWidth);
        }
    
        printBorder(boxWidth);
        
    }
    
    public void printRow(String label, String value, int boxWidth) {
        System.out.print(label);
    
        for (int i = label.length(); i < boxWidth - value.length() - 1; i++) {
            System.out.print(" ");
        }
    
        System.out.println(value + "|");
    }
    
    private void printBorder(int boxWidth) {
        for (int i = 0; i < boxWidth; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public void getErrorMessage() {
        System.out.println("GameMode is null for one or both players. Unable to update leaderboard.");
    }

    //6.3.3.2 Medium Code Smell - Replace this use of System.err by a logger.
    public void getLeaderBoardError(Exception e){
        logger.severe("Error getting leaderboard: " + e.getMessage());
    }

    public void storeLeaderboardError(Exception e){
        logger.severe("Error saving leaderboard: " + e.getMessage());
    }

    public void createLeaderboardError(Exception e){
        logger.severe("Error creating leaderboard file: " + e.getMessage());
    }
}
