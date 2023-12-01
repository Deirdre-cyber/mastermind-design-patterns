package com.example.model;

public class Player {
    private String name;
    private PlayerType playerType;
    private GameMode gameMode;
    private int wins;
    private char[] lastMove;
    private String[] lastHints;

    public Player(String name, PlayerType playerType){
        this.name = name;
        this.playerType = playerType;
        this.wins = 0;
        this.lastMove = new char[4];
    }
    

    public String getName() {
        return name;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public void setGameMode(GameMode gameMode) {
        this.gameMode = gameMode;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public GameMode getGameMode() {
        return gameMode;
    }

    public int getWins() {
        return wins;
    }

    public char[] getLastMove() {
        return lastMove;
    }
    
    public void setLastMove(char[] lastMove) {
        this.lastMove = lastMove;
    }

    public String[] getLastHints() {
        return lastHints;
    }

    public void setLastHints(String[] strings) {
        this.lastHints = strings;
    }

}
