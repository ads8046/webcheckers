package com.webcheckers.application;

import com.webcheckers.model.Player;

import java.util.ArrayList;

public class PlayerLobby {

    private ArrayList<Player> players;
    private Player user;

    public PlayerLobby() {
        players = new ArrayList<Player>();
    }

    public boolean isUserTaken(String username){
        boolean result = true;
        for(int i = 0; i < players.size(); i++) {
            if (players.get(i).getPlayerName().equals(username)){
                result = true;
            }
            else {
                result = false;
            }
        }
        return result;
    }

    public void addPlayer(String playerName) {
        players.add(new Player(playerName));
    }
}
