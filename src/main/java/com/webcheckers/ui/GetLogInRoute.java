package com.webcheckers.ui;

import java.util.Objects;

import com.webcheckers.util.Message;
import spark.*;


public class GetLogInRoute implements Route {

    private static final Message SIGN_IN_CREDENTIALS = Message.info("Please use credentials to sign in.");

    private final TemplateEngine templateEngine;


    public GetLogInRoute(final TemplateEngine templateEngine) {
        // validation
        Objects.requireNonNull(templateEngine, "templateEngine must not be null");
        //
        this.templateEngine = templateEngine;
    }

    @Override
    public Object handle(Request request, Response response){
        //todo



        final Session httpSession = request.session();



        return 6;
    }
}
