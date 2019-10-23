package com.webcheckers.ui;

import com.webcheckers.application.PlayerLobby;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import spark.ModelAndView;
import spark.TemplateEngine;

import static org.junit.jupiter.api.Assertions.*;

@Tag("UI-tier")

public class PostSignInRouteTest {

    @Test
    public void testIsValid() {
        final PlayerLobby playerLobby = new PlayerLobby();
        final TemplateEngine templateEngine = new TemplateEngine() {
            @Override
            public String render(ModelAndView modelAndView) {
                return null;
            }
        };
        final PostSignInRoute CuT = new PostSignInRoute(playerLobby, templateEngine);

        assertTrue(CuT.isValid("Player"), "Username not valid");
        assertFalse(CuT.isValid(""), "Username cannot be empty");
        assertFalse(CuT.isValid("!"), "Username cannot have only one non-alphanumeric character");
    }
}
