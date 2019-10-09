package com.webcheckers.application;

import com.webcheckers.model.Player;

import java.util.ArrayList;

public class PlayerLobby {

    private ArrayList<Player> players;

    public PlayerLobby() {
        players = new ArrayList<Player>();
    }

    public void addPlayer(String playerName) {
        players.add(new Player(playerName));
    }
}
