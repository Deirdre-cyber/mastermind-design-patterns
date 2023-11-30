package com.example;

public class HumanPlayerFactory implements PlayerFactory{

    @Override
    public Player createPlayer(String name) {
        return new Player(name, PlayerType.HUMAN);
    }
    
}
