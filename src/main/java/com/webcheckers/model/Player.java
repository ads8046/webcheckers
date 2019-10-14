package com.webcheckers.model;

/**
 * Class for a Player
 */
public class Player {

    private String playerName;
    private Player opponent;
    private boolean inGame;
    private BoardView myBoard;

    /**
     * Creates a player with the username input
     * @param playerName player's username
     */
    public Player(String playerName) {
        this.playerName = playerName;
        this.inGame = false;
    }

    /**
     * Gets the player's username
     * @return the player's username
     */
    public String getName() {
        return playerName;
    }

    /**
     * Returns true whether the user
     * @return true if user is currently in a game, false otherwise.
     */
    public boolean getInGame() {
        return inGame;
    }

    /**
     * Called when player gets into a game to set that the player is currently in a game
     */
    public void putInGame(Player challenger, BoardView myBoard) {
        this.opponent = challenger;
        this.inGame = true;
        this.myBoard = myBoard;
    }

    /**
     * Returns the opposing the player this player is playing against
     * @return opponent this player is playing against
     */
    public Player getOpponent() {
        return opponent;
    }

    /**
     * Getter for player's board
     * @return player's board
     */
    public BoardView getBoard() {
        return myBoard;
    }

    /**
     * Returns player's username
     * @return player's username
     */
    @Override
    public String toString() {
        return playerName;
    }

    /**
     * Equals method to check if this object and other object is equal
     * @param obj invoked
     * @return whether this object and the object invoked are equal or not
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Player)) {
            return false;
        }
        Player player = (Player)obj;
        return player.playerName.equals(this.playerName);
    }
}
