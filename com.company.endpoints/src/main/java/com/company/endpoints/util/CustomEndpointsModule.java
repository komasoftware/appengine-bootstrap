package com.company.endpoints.util;

import com.company.cache.CacheService;
import com.company.cache.memcache.MemCacheServiceImpl;
import com.company.database.ExampleService;
import com.company.database.clouddatastore.ExampleServiceImpl;
import com.company.emails.EmailExample;
import com.company.emails.impl.EmailExampleImpl;
import com.company.endpoints.impl.ExampleEndpoint;
import com.company.endpoints.impl.ExampleWithAuthEndpoint;
import com.google.api.server.spi.guice.EndpointsModule;
import com.google.common.collect.ImmutableList;

import javax.cache.CacheException;
import java.util.logging.Logger;

/**
 * Binds the services interfaces to their implementation
 */
public class CustomEndpointsModule extends EndpointsModule {
    private static final Logger LOG = Logger.getLogger(CustomEndpointsModule.class.getName());

    @Override
    public void configureServlets() {
        bind(ExampleService.class).toInstance(new ExampleServiceImpl());
        bind(EmailExample.class).toInstance(new EmailExampleImpl());
        try {
            bind(CacheService.class).toInstance(new MemCacheServiceImpl());
        } catch (CacheException e) {
            LOG.severe(e.getMessage());
        }

        /* List all your endpoints here */
        ImmutableList endpointsList = ImmutableList.of(
                ExampleEndpoint.class,
                ExampleWithAuthEndpoint.class);

        configureEndpoints("/_ah/api/*", endpointsList);
    }
}
