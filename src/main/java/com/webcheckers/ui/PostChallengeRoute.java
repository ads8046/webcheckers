package com.webcheckers.ui;

import com.webcheckers.application.PlayerLobby;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.TemplateEngine;

public class PostChallengeRoute implements Route {

    private TemplateEngine templateEngine;
    private final PlayerLobby playerLobby;

    public PostChallengeRoute(PlayerLobby playerLobby, TemplateEngine templateEngine){
        this.templateEngine = templateEngine;
        this.playerLobby = playerLobby;
    }

    public Object handle(Request request, Response response) {
        final String opponent = request.queryParams("challengedPlayer");

        playerLobby.putInGame(opponent);



        return opponent;
    }
}
