package com.example.model;

public class PlayerScore implements Comparable<PlayerScore> {
    private String playerName;
    private int score;

    public PlayerScore(String playerName, int score) {
        this.playerName = playerName;
        this.score = score;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getScore() {
        return score;
    }

    @Override
    public int compareTo(PlayerScore other) {
        return Integer.compare(this.score, other.score);
    }

    //6.3.2.3.3 Override equals and hashCode when implementing Comparable - have decided to not override as it is not needed for this class and would be redundant code
}
