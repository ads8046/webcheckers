package com.webcheckers.ui;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import spark.*;

@Tag("UI-tier")

public class GetLogInRouteTest {

    private Request request;
    private Response response;
    private Session session;
    private TemplateEngine engine;
    private  GetLogInRoute CuT;

    public void setup() {
        request = mock(Request.class);
        response = mock(Response.class);
        session = mock(Session.class);
        when(request.session()).thenReturn(session);
        engine = mock(TemplateEngine.class);
        CuT = new GetLogInRoute(engine);

    }

    @Test
    public void testHandle() {

        setup();
        final TemplateEngineTester testHelper = new TemplateEngineTester();
        when(engine.render(any(ModelAndView.class))).thenAnswer(testHelper.makeAnswer());

        CuT.handle(request, response);

        testHelper.assertViewModelExists();
        testHelper.assertViewModelIsaMap();

        testHelper.assertViewModelAttribute("title", "Sign in page");


    }

}
