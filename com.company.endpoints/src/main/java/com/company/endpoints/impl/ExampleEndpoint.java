package com.company.endpoints.impl;

import com.company.core.Example;
import com.company.database.ExampleService;
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

    @Inject
    public ExampleEndpoint(ExampleService exampleService) {
        this.exampleService = exampleService;
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
}
