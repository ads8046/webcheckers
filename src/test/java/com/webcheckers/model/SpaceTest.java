package com.webcheckers.model;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Tag ("Model-tier")

public class SpaceTest {

    @Test
    public void ctor_nullPiece() {
        final Space CuT = new Space(0, 0, true);

        assertTrue(CuT.isEmpty());
    }


}
