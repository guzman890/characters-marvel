package com.openpay.marvel.api.rest.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MarvelApiConfig {

    @Value("${marvel.api.publicKey}")
    private String publicKey;

    @Value("${marvel.api.privateKey}")
    private String privateKey;

    public String getPublicKey() {
        return publicKey;
    }

    public String getPrivateKey() {
        return privateKey;
    }
}
