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

    public Piece(PieceColors color) {
        this.pieceColor = color;
        this.pieceType = PieceTypes.SINGLE;
    }

    public PieceTypes getType() {
        return this.pieceType;
    }

    public PieceColors getColor() {
        return this.pieceColor;
    }


}
