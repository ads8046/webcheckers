package com.webcheckers.model;

/**
 * simple class tier entity, holds the player's name
 *
 * @author Cameron Perdue clp3344@rit.edu
 */
public class Player {

    private String playerName;
    private Player opponent;
    private boolean inGame;
    private BoardView myBoard;

    public Player(String playerName) {
        this.playerName = playerName;
        this.inGame = false;
    }

    public String getName() {
        return playerName;
    }

    public boolean getInGame() {
        return inGame;
    }

    public void putInGame(Player challenger, BoardView myBoard) {
        this.opponent = challenger;
        this.inGame = true;
        this.myBoard = myBoard;
    }

    public Player getOpponent() {
        return opponent;
    }

    public BoardView getBoard() {
        return myBoard;
    }

    @Override
    public String toString() {
        return playerName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Player)) {
            return false;
        }
        Player player = (Player)o;
        return player.playerName.equals(this.playerName);
    }
}
