package com.webcheckers.ui;

import spark.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Logger;

/**
 * UI controller to get the log-in page
 *
 * @author Cam Perdue clp3344@rit.edu
 */
public class GetLogInRoute implements Route {

    private static final Logger LOG = Logger.getLogger(GetHomeRoute.class.getName());
    private final TemplateEngine templateEngine;

    /**
     * create the spark route (UI Controller) to handle all {@code GET LogIn} HTTP requests
     * @param templateEngine The html template rendering engine
     */
    public GetLogInRoute(final TemplateEngine templateEngine) {
        this.templateEngine = Objects.requireNonNull(templateEngine, "Template engine is required");
        LOG.config("GetLogInRoute is initialized");
    }


    /**
     * render the webcheckers sign-in page
     * @param request the HTTP request
     * @param response the HTTP response
     * @return the rendered HTML for the sign-in page
     */
    @Override
    public Object handle(Request request, Response response) {
        LOG.finer("GetLogInRoute is invoked");
        Map<String, Object> vm = new HashMap<>();

        vm.put("title", "Sign in page");

        return templateEngine.render(new ModelAndView(vm, "sign-in.ftl"));
    }
}
