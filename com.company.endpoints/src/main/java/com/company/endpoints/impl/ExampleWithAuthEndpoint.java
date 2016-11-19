package com.company.endpoints.impl;

import com.company.database.ExampleService;
import com.company.endpoints.util.CustomAuthenticator;
import com.company.endpoints.wrapper.Examples;
import com.google.api.server.spi.auth.common.User;
import com.google.api.server.spi.config.*;
import com.google.inject.Inject;

import java.util.logging.Logger;

/**
 * This ExampleEndpoint APIs
 */
@Api(name = "exampleWithAuth",
        version = "v1",
        namespace = @ApiNamespace(ownerDomain = ApiKeysAndIds.API_OWNER,
                ownerName = ApiKeysAndIds.API_OWNER,
                packagePath = ApiKeysAndIds.API_PACKAGE_PATH),
        clientIds = {ApiKeysAndIds.ANDROID_CLIENT_ID, ApiKeysAndIds.IOS_CLIENT_ID, ApiKeysAndIds.WEB_CLIENT_ID},
        audiences = {ApiKeysAndIds.AUDIENCE_ID},
        auth = @ApiAuth(allowCookieAuth = AnnotationBoolean.TRUE),
        authenticators = {CustomAuthenticator.class}
)
public class ExampleWithAuthEndpoint {
    private static final Logger LOG = Logger.getLogger(ExampleWithAuthEndpoint.class.getName());
    private final ExampleService exampleService;

    @Inject
    public ExampleWithAuthEndpoint(ExampleService exampleService) {
        this.exampleService = exampleService;
    }

    /**
     * Gets all example
     *
     * @return the list of example
     */
    @ApiMethod(httpMethod = "GET", path = "examples")
    public Examples getAllExamples(User user) {
        if (user != null) {
            Examples examples = new Examples();
            examples.setExamples(exampleService.getAllExamples());
            return examples;
        }
        return null;
    }
}
