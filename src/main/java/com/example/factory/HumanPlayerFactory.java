package com.example.factory;

import com.example.model.Player;
import com.example.model.PlayerType;

public class HumanPlayerFactory implements PlayerFactory{

    @Override
    public Player createPlayer(String name) {
        return new Player(name, PlayerType.HUMAN);
    }
}
