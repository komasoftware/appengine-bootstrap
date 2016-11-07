package com.company.endpoints;

import com.company.core.Example;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

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

    /**
     * Gets an example
     *
     * @return the example
     */
    @ApiMethod(httpMethod = "GET", path = "example")
    public Example example() {
        return new Example("toto");
    }
}
