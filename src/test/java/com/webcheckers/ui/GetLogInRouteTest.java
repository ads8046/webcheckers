package com.webcheckers.ui;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import spark.ModelAndView;
import spark.TemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@Tag("UI-tier")

public class GetLogInRouteTest {

    private TemplateEngine engine;
    private ModelAndView vm;

    @Test
    public void testHandle() {

        final TemplateEngineTester testHelper = new TemplateEngineTester();
        //when(engine.render(any(ModelAndView.class))).thenAnswer(testHelper.makeAnswer());

        //final GetLogInRoute CuT = new GetLogInRoute(testHelper);



    }

}
