package com.company.endpoints.impl;

import com.company.cache.CacheService;
import com.company.core.Example;
import com.company.database.ExampleService;
import com.company.emails.EmailExample;
import com.company.endpoints.wrapper.Examples;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.config.Named;
import com.google.inject.Inject;

import java.util.logging.Logger;

/**
 * This ExampleEndpoint APIs
 */
@Api(name = "example",
        version = "v1",
        namespace = @ApiNamespace(ownerDomain = ApiKeysAndIds.API_OWNER,
                ownerName = ApiKeysAndIds.API_OWNER,
                packagePath = ApiKeysAndIds.API_PACKAGE_PATH),
        clientIds = {ApiKeysAndIds.ANDROID_CLIENT_ID, ApiKeysAndIds.IOS_CLIENT_ID, ApiKeysAndIds.WEB_CLIENT_ID},
        audiences = {ApiKeysAndIds.AUDIENCE_ID}
)
public class ExampleEndpoint {
    private static final Logger LOG = Logger.getLogger(ExampleEndpoint.class.getName());
    private final ExampleService exampleService;
    private final EmailExample emailExample;
    private final CacheService cacheService;

    @Inject
    public ExampleEndpoint(ExampleService exampleService, EmailExample emailExample,
                           CacheService cacheService) {
        this.exampleService = exampleService;
        this.emailExample = emailExample;
        this.cacheService = cacheService;
    }

    /**
     * Gets an example
     *
     * @return the example
     */
    @ApiMethod(httpMethod = "GET", path = "example")
    public Example example(@Named("name") String name) {
        Example example = new Example(name);
        exampleService.saveExample(example);
        return example;
    }

    /**
     * Gets all example
     *
     * @return the list of example
     */
    @ApiMethod(httpMethod = "GET", path = "examples")
    public Examples getAllExamples() {
        Examples examples = new Examples();
        examples.setExamples(exampleService.getAllExamples());
        return examples;
    }

    /**
     * Sends a test email
     *
     * @param email the email address
     */
    @ApiMethod(httpMethod = "POST", path = "emails")
    public void sendTestEmail(@Named("email") String email) {
        emailExample.sendTestEmail(email);
    }

    /**
     * Sets value to the cache
     *
     * @param id    the id of the value
     * @param value the value to cache
     */
    @ApiMethod(httpMethod = "POST", path = "cache")
    public void putCache(@Named("id") String id, @Named("value") String value) {
        cacheService.putCache(id, value);
    }

    /**
     * Gets value from the cache
     *
     * @return the example
     */
    @ApiMethod(httpMethod = "GET", path = "cache")
    public Example getCache(@Named("id") String id) {
        Example example = new Example(cacheService.getCache(id));
        return example;
    }
}
