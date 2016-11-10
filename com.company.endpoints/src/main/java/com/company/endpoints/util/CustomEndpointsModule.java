package com.company.endpoints.util;

import com.company.database.ExampleService;
import com.company.database.clouddatastore.ExampleServiceImpl;
import com.company.endpoints.impl.ExampleEndpoint;
import com.google.api.server.spi.guice.EndpointsModule;
import com.google.common.collect.ImmutableList;

/**
 * Binds the services interfaces to their implementation
 */
public class CustomEndpointsModule extends EndpointsModule {

    @Override
    public void configureServlets() {
        bind(ExampleService.class).toInstance(new ExampleServiceImpl());

        /* List all your endpoints here */
        ImmutableList endpointsList = ImmutableList.of(
                ExampleEndpoint.class);

        configureEndpoints("/_ah/api/*", endpointsList);
    }
}
