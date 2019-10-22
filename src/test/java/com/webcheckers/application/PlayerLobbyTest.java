package com.webcheckers.application;

import com.webcheckers.model.BoardView;
import com.webcheckers.model.Player;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import spark.Session;

import static org.junit.jupiter.api.Assertions.*;

@Tag ("Application-tier")
public class PlayerLobbyTest {
    @Test
    public void testIsUserTaken() {
        final PlayerLobby CuT = new PlayerLobby();

         CuT.addPlayerList("Cam");
         assertTrue(CuT.isUserTaken("Cam"));
    }

    @Test
    public void testIsUserTakenTwoPlayers() {
        final PlayerLobby CuT = new PlayerLobby();

        CuT.addPlayerList("Cam");
        assertFalse(CuT.isUserTaken("Mason"));
        CuT.addPlayerList("Mason");
        assertTrue(CuT.isUserTaken("Mason"));
    }

    @Test
    public void testGetPlayer() {
        final PlayerLobby CuT = new PlayerLobby();
        CuT.addPlayerList("Cam");
        assertEquals(CuT.getPlayer("Cam"), new Player("Cam"));
    }

    @Test
    public void testTotalPlayers() {
        final PlayerLobby CuT = new PlayerLobby();
        assertEquals(CuT.totalPlayers(), 0);
        CuT.addPlayerList("Cam");
        assertEquals(CuT.totalPlayers(), 1);
        CuT.addPlayerList("Arrow");
        assertEquals(CuT.totalPlayers(), 2);
    }

    @Test
    public void testPutInGame() {
        final PlayerLobby CuT = new PlayerLobby();

        CuT.addPlayerList("Cam");
        CuT.addPlayerList("Mason");
        assertFalse(CuT.getPlayer("Cam").getInGame());
        assertFalse(CuT.getPlayer("Mason").getInGame());

        CuT.putInGame("Mason", CuT.getPlayer("Cam"), new BoardView());

        assertTrue(CuT.getPlayer("Cam").getInGame());
        assertTrue(CuT.getPlayer("Mason").getInGame());
    }
}
