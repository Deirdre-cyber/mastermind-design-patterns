package com.example.view;

import java.util.List;

import com.example.model.PlayerScore;

public class LeaderboardView {


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

    public void getLeaderBoardError(Exception e){
        System.err.println("Error loading leaderboard: " + e.getMessage());
    }

    public void storeLeaderboardError(Exception e){
        System.err.println("Error saving leaderboard: " + e.getMessage());
    }

    public void createLeaderboardError(Exception e){
        System.err.println("Error creating leaderboard file: " + e.getMessage());
    }
}
