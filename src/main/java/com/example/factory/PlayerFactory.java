package com.example.factory;

import com.example.model.Player;

public interface PlayerFactory {
    Player createPlayer(String name);
}
