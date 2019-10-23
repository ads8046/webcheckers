package com.webcheckers.application;

import com.webcheckers.model.BoardView;
import com.webcheckers.model.Player;
import com.webcheckers.ui.PostSignInRoute;
import spark.Session;

import java.util.ArrayList;
import java.util.List;
import java.lang.StringBuilder;

/**
 * Class for the player lobby that holds all the players signed in
 */
public class PlayerLobby {

    private List<Player> players;
    private Player user;

    /**
     * Constructor for Player Lobby
     */
    public PlayerLobby() {
        players = new ArrayList<Player>();
    }

    /**
     * Checks if username is taken already by another player
     * @param username from player
     * @return true is username is taken already, false otherwise
     */
    public boolean isUserTaken(String username) {
        boolean result =  false;
        for (Player p: players) {
            if (p.getName().equals(username)) {
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Adds the player to the lobby list
     * @param playerName player's username
     * @param httpSession Session player will be redirected to after signing in
     */
    public void addPlayer(String playerName, Session httpSession) {
        httpSession.attribute(PostSignInRoute.PLAYER_KEY, addPlayerList(playerName));
    }

    public Player addPlayerList(String playerName) {
        Player newPlayer = new Player(playerName);
        players.add(newPlayer);
        return newPlayer;
    }

    /**
     * Returns a string representation of the players in the lobby
     * @param ignoredPlayer
     * @return List of players signed in
     */
    public String listPlayers(Player ignoredPlayer) {
        StringBuilder playersList = new StringBuilder();
        for (Player p: players) {
            if (p.equals(ignoredPlayer)) { }
            else if(p.getInGame()) { }
            else {
                playersList.append("<li>");

//                playersList.append("<a href=\"/game\">");
//                playersList.append(p);
//                playersList.append("</a>");
//                playersList.append("<br>");

//                playersList.append("<button onclick=\"loadOpponent()\">");
//                playersList.append(p);
//                playersList.append("</button>");

                  playersList.append("<input name=\"challengedPlayer\" type=\"submit\" value=\"");
                  playersList.append(p);
                  playersList.append("\" />");
                playersList.append("</li>");
            }
        }
        return playersList.toString();
    }

    /**
     * Returns number of currently signed in players
     * @return number of players in the lobby
     */
    public int totalPlayers() {
        return players.size();
    }

    /**
     * Puts player and the player being challenged into a checkers game
     * @param playerName player being challenged
     * @param challenger player that begins the challenge
     * @param board checkers board in which both players will play in
     */
    public void putInGame(String playerName, Player challenger, BoardView board) {
        for (Player p: players) {
            if (p.getName().equals(playerName)) {
                p.putInGame(challenger, board);
                challenger.putInGame(p, board);
            }
        }
    }

    /**
     * Gets player from the lobby list
     * @param playerName target player username
     * @return player with the player name being passed as a parameter
     */
    public Player getPlayer(String playerName) {
        for (Player p: players) {
            if (p.getName().equals(playerName)) {
                return p;
            }
        }
        return null;
    }

}
