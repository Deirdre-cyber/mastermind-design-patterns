package com.example.model;

public class HumanPlayerFactory implements PlayerFactory{

    @Override
    public Player createPlayer(String name) {
        return new Player(name, PlayerType.HUMAN);
    }
    
}
