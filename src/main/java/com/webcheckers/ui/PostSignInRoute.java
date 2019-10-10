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


public class PostSignInRoute implements Route{

    private final PlayerLobby playerLobby;
    private final TemplateEngine templateEngine;
    private static final String USER_PARA = "myUsername";


    public PostSignInRoute(PlayerLobby playerLobby, TemplateEngine templateEngine) {
        // validation
        Objects.requireNonNull(playerLobby, "gameCenter must not be null");
        Objects.requireNonNull(templateEngine, "templateEngine must not be null");
        //
        this.playerLobby = playerLobby;
        this.templateEngine = templateEngine;

    }

    @Override
    public String handle(Request request, Response response) throws Exception {
        // start building the View-Model
        final Map<String, Object> vm = new HashMap<>();




        // retrieve the game object
        final Session session = request.session();


        //retrieve username validation request
        // retrieve request parameter
        final String usernameStr = request.queryParams(USER_PARA);

        vm.put("title", "Sign in page");


        if ( playerLobby.isUserTaken(usernameStr) ) {
            vm.put("ERROR", "Username invalid - choose another one");
        }

        if (!playerLobby.isUserTaken(usernameStr)){
            vm.put("PLAYERS IN THE LOBBY: ", playerLobby.);
        }

        return templateEngine.render(new ModelAndView(vm, "home.ftl"));
    }
}
