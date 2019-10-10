package com.webcheckers.application;

import com.webcheckers.model.Player;
import com.webcheckers.ui.PostSignInRoute;
import spark.Session;

import java.util.ArrayList;
import java.util.List;
import java.lang.StringBuilder;

public class PlayerLobby {

    private List<Player> players;
    private Player user;

    public PlayerLobby() {
        players = new ArrayList<Player>();
    }

    public boolean isUserTaken(String username){
        boolean result =  false;
        for (Player p: players) {
            if (p.getName().equals(username)) {
                result = true;
                break;
            }
        }
        return result;
    }

    public void addPlayer(String playerName, Session httpSession) {
        Player newPlayer = new Player(playerName);
        players.add(newPlayer);
        httpSession.attribute(PostSignInRoute.PLAYER_KEY, newPlayer);
    }

    public String listPlayers(Player ignoredPlayer) {
        StringBuilder playersList = new StringBuilder();
        for (Player p: players) {
            if (p.equals(ignoredPlayer)) { }
            else {
                playersList.append(p);
                playersList.append('\n');
            }
        }
        return playersList.toString();
    }

    public int totalPlayers() {
        return players.size();
    }

}
