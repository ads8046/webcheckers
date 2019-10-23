package com.webcheckers.ui;

import com.webcheckers.application.PlayerLobby;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import spark.*;

import java.util.PrimitiveIterator;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@Tag("UI-tier")

public class PostSignInRouteTest {

    private Request request;
    private Response response;
    private Session session;
    private TemplateEngine engine;
    private PostSignInRoute CuT;
    private PlayerLobby playerLobby;

    public void setup() {
        request = mock(Request.class);
        response = mock(Response.class);
        session = mock(Session.class);
        when(request.session()).thenReturn(session);
        engine = mock(TemplateEngine.class);
        playerLobby = new PlayerLobby();
        CuT = new PostSignInRoute(playerLobby, engine);
    }

    @Test
    public void testInvalidUsernameMessage() {

        assertEquals("You entered @; Please enter a valid username.",
                CuT.invalidUsernameMessage("@"));
    }

    @Test
    public void testIsValid() {

        setup();

        assertTrue(CuT.isValid("Player"), "Username not valid");
        assertFalse(CuT.isValid(""), "Username cannot be empty");
        assertFalse(CuT.isValid("!"), "Username cannot have only one non-alphanumeric character");

    }


    @Test
    public void testHandle() {

        setup();
        final TemplateEngineTester testHelper = new TemplateEngineTester();
        when(engine.render(any(ModelAndView.class))).thenAnswer(testHelper.makeAnswer());

        //CuT.handle(request, response);

        //testHelper.assertViewModelExists();
        //testHelper.assertViewModelIsaMap();

        //testHelper.assertViewModelAttribute("title", "Sign in page");
    }
}
