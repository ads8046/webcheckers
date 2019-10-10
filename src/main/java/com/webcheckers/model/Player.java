package com.webcheckers.model;

/**
 * simple class tier entity, holds the player's name
 *
 * @author Cameron Perdue clp3344@rit.edu
 */
public class Player {

    private String playerName;

    public Player(String playerName) {
        this.playerName = playerName;
    }

    public String getName() {
        return playerName;
    }

    @Override
    public String toString() {
        return playerName;
    }
}
