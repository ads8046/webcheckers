package com.webcheckers.ui;

import com.webcheckers.application.PlayerLobby;
import com.webcheckers.model.Player;
import spark.*;

import java.util.HashMap;
import java.util.Map;

public class PostChallengeRoute implements Route {

    private TemplateEngine templateEngine;
    private final PlayerLobby playerLobby;

    public PostChallengeRoute(PlayerLobby playerLobby, TemplateEngine templateEngine){
        this.templateEngine = templateEngine;
        this.playerLobby = playerLobby;
    }

    public Object handle(Request request, Response response) {
        Session httpSession = request.session();
        Player currentPlayer = httpSession.attribute(PostSignInRoute.PLAYER_KEY);

        final String opponentName = request.queryParams("challengedPlayer");
        final Player opponentPlayer = playerLobby.getPlayer(opponentName);

        final Map<String, Object> vm = new HashMap<>();

        playerLobby.putInGame(opponentName);

        vm.put("currentUser", currentPlayer);
        vm.put("viewMode", GetGameRoute.VIEW_MODE.PLAY);
        vm.put("redPlayer", currentPlayer);
        vm.put("whitePlayer", opponentPlayer);


        return opponentName;
    }
}
