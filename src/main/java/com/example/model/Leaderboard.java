package com.example.model;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.example.controller.LeaderboardController;
import com.example.view.LeaderboardView;

public class Leaderboard {
    private static Leaderboard instance;
    private LeaderboardView leaderboardView = new LeaderboardView();
    private LeaderboardController leaderboardController = new LeaderboardController();

    private List<PlayerScore> scores;

    private static final String CSV_HEADER = "Player,Score";
    private static final String CSV_FILE_PATH = "leaderboard.csv";


    private Leaderboard() {
        this.scores = new ArrayList<>();
        loadLeaderboard();
    }

    public static Leaderboard getInstance(){
        if (instance == null) {
            instance = new Leaderboard();
        }
        return instance;
    }

    public void updateLeaderboard(Player playerOne, Player playerTwo) {
        GameMode gameModeOne = playerOne.getGameMode();
        GameMode gameModeTwo = playerTwo.getGameMode();
    
        if (gameModeOne != null && gameModeTwo != null) {
            int movesLeftOne = gameModeOne.getMovesLeft();
            int movesLeftTwo = gameModeTwo.getMovesLeft();
    
            if (playerOne.getPlayerType() == PlayerType.HUMAN && playerTwo.getPlayerType() == PlayerType.COMPUTER) {
                int scoreOne = leaderboardController.calculateScore(movesLeftOne, gameModeOne.getDifficulty());
                int scoreTwo = leaderboardController.calculateScore(movesLeftTwo, gameModeTwo.getDifficulty());
    
                scores.add(new PlayerScore(playerOne.getName(), scoreOne));
                scores.add(new PlayerScore(playerTwo.getName(), scoreTwo));
    
                Collections.sort(scores);
                leaderboardView.displayLeaderboard(scores);
                saveLeaderboard();
            }
        } else {
            leaderboardView.getErrorMessage();
        }
    }

    private void loadLeaderboard() {
        boolean skipFirstLine = true;
        try (BufferedReader reader = new BufferedReader(new FileReader(CSV_FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (skipFirstLine) {
                    skipFirstLine = false;
                    continue;
                }

                String[] parts = line.split(",");
                String playerName = parts[0].trim();
                int score = Integer.parseInt(parts[1].trim());
                scores.add(new PlayerScore(playerName, score));
            }
        } catch (FileNotFoundException e) {
            createLeaderboardFile();
        } catch (IOException | NumberFormatException e) {
            leaderboardView.getLeaderBoardError(e);
        }
    }
    
    private void createLeaderboardFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CSV_FILE_PATH))) {
            writer.write(CSV_HEADER);
            writer.newLine();
        } catch (IOException e) {
            leaderboardView.createLeaderboardError(e);
        }
    }

    private void saveLeaderboard() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CSV_FILE_PATH))) {
            writer.write(CSV_HEADER);
            writer.newLine();
            for (PlayerScore score : scores) {
                writer.write(score.getPlayerName() + "," + score.getScore());
                writer.newLine();
            }
        } catch (IOException e) {
            leaderboardView.storeLeaderboardError(e);
        }
    }
}
