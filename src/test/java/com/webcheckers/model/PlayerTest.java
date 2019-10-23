package com.webcheckers.model;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Tag ("Model-tier")

public class PlayerTest {

    @Test
    public void ctor_newPlayer() {
        final Player CuT = new Player("Mason");

        assertEquals(CuT.getName(), "Mason");
        assertFalse(CuT.getInGame());
    }

    @Test
    public void testEqualPlayer() {
        final Player CuT = new Player("Player1");

        assertEquals(new Player("Player1"), CuT);
    }
}
