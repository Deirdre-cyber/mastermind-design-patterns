package com.example;

public class ComputerPlayerFactory implements PlayerFactory{

    @Override
    public Player createPlayer(String name) {
        return new Player(name, PlayerType.COMPUTER);
        
    }
    
}
