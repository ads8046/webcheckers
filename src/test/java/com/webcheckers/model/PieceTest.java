package com.webcheckers.model;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag ("Model-tier")
public class PieceTest {
    @Test
    public void ctor_white() {
        final Piece CuT = new Piece(Piece.PieceColors.WHITE);

        assertEquals(CuT.getColor(), Piece.PieceColors.WHITE);
        assertEquals(CuT.getType(), Piece.PieceTypes.SINGLE);
    }
    @Test
    public void ctor_red() {
        final Piece CuT = new Piece(Piece.PieceColors.RED);

        assertEquals(CuT.getColor(), Piece.PieceColors.RED);
        assertEquals(CuT.getType(), Piece.PieceTypes.SINGLE);
    }
}
