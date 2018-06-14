package com.manywho.services.stripe;

import com.manywho.sdk.api.ContentType;
import com.manywho.sdk.services.configuration.Configuration;

public class ServiceConfiguration implements Configuration {
    @Configuration.Setting(name="Secret Key", contentType= ContentType.String)
    private String secretKey;

    public String getSecretKey() {
        return secretKey;
    }
}
