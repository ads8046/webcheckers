package com.webcheckers.ui;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.TemplateEngine;

public class PostChallengeRoute implements Route {

    private TemplateEngine templateEngine;

    public Object handle(Request request, Response response) {
        return true;
    }

    public PostChallengeRoute(TemplateEngine templateEngine){
        this.templateEngine = templateEngine;
    }
}
