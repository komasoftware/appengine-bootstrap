package com.company.endpoints.util;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;

/**
 * Creates the injector with the desired modules
 */
public class CustomServletContextListener extends GuiceServletContextListener {

    @Override
    protected Injector getInjector() {
        return Guice.createInjector(
                new CustomEndpointsModule());
    }
}