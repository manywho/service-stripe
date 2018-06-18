package com.manywho.services.stripe.charge;

import com.manywho.sdk.api.ContentType;
import com.manywho.sdk.services.types.Type;

@Type.Element(name = Token.NAME)
public class Token implements Type {
    public final static String NAME = "Token";

    public Token() {}

    @Type.Identifier
    @Type.Property(name = "Public Token", contentType = ContentType.String)
    private String publicToken;

    @Type.Property(name = "User Token", contentType = ContentType.String)
    private String userToken;

    public String getPublicToken() {
        return publicToken;
    }

    public String getUserToken() {
        return userToken;
    }
}
