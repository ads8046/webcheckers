package com.webcheckers.ui;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import com.webcheckers.application.PlayerLobby;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Session;
import spark.TemplateEngine;
import static spark.Spark.halt;


public class PostSignInRoute implements Route {

    private final PlayerLobby playerLobby;
    private final TemplateEngine templateEngine;
    private static final String USER_PARA = "myUsername";
    private static final String INVALID_USERNAME = "invalidUsername";
    public static final String PLAYER_KEY = "playerKey";


    public PostSignInRoute(PlayerLobby playerLobby, TemplateEngine templateEngine) {
        // validation
        Objects.requireNonNull(playerLobby, "gameCenter must not be null");
        Objects.requireNonNull(templateEngine, "templateEngine must not be null");
        //
        this.playerLobby = playerLobby;
        this.templateEngine = templateEngine;

    }

    private static String invalidUsernameMessage(final String badUsername) {
        return String.format("You entered %s; Please enter a valid username.", badUsername);
    }

    private static String takenUsernameMessage(final String badUsername) {
        return "The username you have chosen is already taken";
    }

    private boolean isValid(String s) {
        if (s.length() > 1) {
            return true;
        } else if (s.length() == 0) {
            return false;
        } else return s.matches(("^.*[^a-zA-Z0-9 ].*$"));
    }

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
            vm.put(INVALID_USERNAME, invalidUsernameMessage(usernameStr));
            return templateEngine.render(new ModelAndView(vm, "sign-in.ftl"));
        } else if (playerLobby.isUserTaken(usernameStr)) {
            vm.put(INVALID_USERNAME, takenUsernameMessage(usernameStr));
            return templateEngine.render(new ModelAndView(vm, "sign-in.ftl"));
        } else {
            playerLobby.addPlayer(usernameStr, session);
            response.redirect(WebServer.HOME_URL);
            return templateEngine.render(new ModelAndView(vm, "home.ftl"));
        }
    }


}
