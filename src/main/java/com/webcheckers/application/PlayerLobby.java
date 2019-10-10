package com.webcheckers.application;

import com.webcheckers.model.Player;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PlayerLobby {

    private List<Player> players;
    private Player user;

    public PlayerLobby() {
        players = new ArrayList<Player>();
    }

    public boolean isUserTaken(String username){
        boolean result =  false;
        for (Player p: players) {
            if (p.getPlayerName().equals(username)) {
                result = true;
                break;
            }
        }
        return result;
    }

    public void addPlayer(String playerName) {
        players.add(new Player(playerName));
    }
}
