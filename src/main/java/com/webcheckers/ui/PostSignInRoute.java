package com.webcheckers.ui;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import com.webcheckers.application.PlayerLobby;
import com.webcheckers.util.Message;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Session;
import spark.TemplateEngine;
import static spark.Spark.halt;

/**
 * UI Controller class to redirect the user to the home page or sign-in page based on the validity of their username
 */
public class PostSignInRoute implements Route {

    private final PlayerLobby playerLobby;
    private final TemplateEngine templateEngine;
    private static final String USER_PARA = "myUsername";
    private static final String INVALID_USERNAME = "invalidUsername";
    public static final String PLAYER_KEY = "playerKey";

    /**
     * Creates route for redirecting the user from the sign-in page
     * @param playerLobby player lobby for the list of players
     * @param templateEngine The html template rendering engine
     */
    public PostSignInRoute(PlayerLobby playerLobby, TemplateEngine templateEngine) {
        // validation
        Objects.requireNonNull(playerLobby, "gameCenter must not be null");
        Objects.requireNonNull(templateEngine, "templateEngine must not be null");
        //
        this.playerLobby = playerLobby;
        this.templateEngine = templateEngine;
    }

    /**
     * Returns message to display that username input was invalid
     * @param badUsername invalid username from player
     * @return message to display that username was invalid
     */
    private static String invalidUsernameMessage(final String badUsername) {
        return String.format("You entered %s; Please enter a valid username.", badUsername);
    }

    /**
     * Returns message to display that the username input is taken already
     * @param badUsername invalid username from player
     * @return message to display that the username is taken already
     */
    private static String takenUsernameMessage(final String badUsername) {
        return "The username you have chosen is already taken";
    }

    /**
     * Checks if username is a valid username
     * @param s username input
     * @return true if its valid, false otherwise
     */
    private boolean isValid(String s) {
        if (s.length() == 0) {
            return false;
        }
        else if (s.length() > 1) {
            return true;
        }
        else {
            return s.matches("[A-Za-z0-9]+");
        }
    }

    /**
     *
     * @param request the HTTP request
     * @param response the HTTP response
     * @return rendered HTML for displaying if username is invalid or redirecting player to home page
     * @throws Exception
     */
    @Override
    public String handle(Request request, Response response) throws Exception {
        // start building the View-Model
        final Map<String, Object> vm = new HashMap<>();

        // retrieve the game object
        final Session session = request.session();

        // retrieve username validation request
        // retrieve request parameter
        final String usernameStr = request.queryParams(USER_PARA);

        final boolean nameIsValid = isValid(usernameStr);

        vm.put("title", "Sign in page");

        if (!nameIsValid) {
            vm.put(Message.MESSAGE, Message.error(invalidUsernameMessage(usernameStr)));
            return templateEngine.render(new ModelAndView(vm, "sign-in.ftl"));
        } else if (playerLobby.isUserTaken(usernameStr)) {
            vm.put(Message.MESSAGE, Message.error(takenUsernameMessage(usernameStr)));
            return templateEngine.render(new ModelAndView(vm, "sign-in.ftl"));
        } else {
            playerLobby.addPlayer(usernameStr, session);
            response.redirect(WebServer.HOME_URL);
            return templateEngine.render(new ModelAndView(vm, "home.ftl"));
        }
    }


}
