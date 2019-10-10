package com.webcheckers.ui;

import com.webcheckers.model.Player;
import com.webcheckers.util.Message;
import spark.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Logger;

/**
 *
 * Author: Cam Perdue, Mason Zhong, Atharva 'Arrow' Shivankar
 */

public class GetGameRoute implements Route {

    static final Message PLAYING_GAME = Message.info("You are playing a game with");
    static final String VIEW_GAME = "game.ftl";
    static final String CURRENT_USER = "currentUser";
    static final String VIEW_MODE_ATTR = "viewMode";
    static final String ACTIVE_COLOR_ATTR = "activeColor";

    public enum VIEW_MODE {PLAY, SPECTATOR, REPLAY}
    public enum ACTIVE_COLOR {RED, WHITE}

    private final TemplateEngine templateEngine;

    /**
     * The constructor for the {@code GET /game} route handler.
     *
     * @param templateEngine
     *    The {@link TemplateEngine} used for rendering page HTML.
     */
    GetGameRoute(final TemplateEngine templateEngine) {
        // validation
        Objects.requireNonNull(templateEngine, "templateEngine must not be null");
        //
        this.templateEngine = templateEngine;
    }



    public Object handle(Request request, Response response) {
        // retrieve the game object and start one if no game is in progress
        final Session httpSession = request.session();
        final Player sessionsPlayer = httpSession.attribute(PostSignInRoute.PLAYER_KEY);

        final Map<String, Object> vm = new HashMap<>();

        vm.put("currentUser", sessionsPlayer);

        vm.put("viewMode", VIEW_MODE.PLAY); //to be changed when other game modes are added

        //vm.put("modeOptionsAsJSON", "todo"); //todo sprint 2(?)

        vm.put("redPlayer", "todo"); //todo

        vm.put("whitePlayer", "todo"); //todo

        vm.put("activeColor", "todo"); //todo

        vm.put("board", "todo"); //todo

        //return templateEngine.render(new ModelAndView(vm , "game.ftl"));
        return true;
    }

}
