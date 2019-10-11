package com.webcheckers.model;

/**
 * simple piece class
 * represents one piece on the board
 *
 * @author Cameron Perdue clp3344@rit.edu
 */
public class Piece {

    public enum PieceTypes {SINGLE, KING}
    public enum PieceColors {RED, WHITE}

    private PieceTypes pieceType;
    private PieceColors pieceColor;

    /**
     * Creates piece with type and color
     * @param color red or white
     */
    public Piece(PieceColors color) {
        this.pieceColor = color;
        this.pieceType = PieceTypes.SINGLE;
    }

    /**
     * Gets piece's type
     * @return piece's type, king or single
     */
    public PieceTypes getType() {
        return this.pieceType;
    }

    /**
     * Get piece's color
     * @return piece's color, red or white
     */
    public PieceColors getColor() {
        return this.pieceColor;
    }


}
