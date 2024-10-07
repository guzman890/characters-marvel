package com.openpay.marvel.api.rest.service.impl;

import com.openpay.marvel.api.client.model.MarvelResponse;
import com.openpay.marvel.api.client.service.MarvelApiClient;
import com.openpay.marvel.api.rest.config.MarvelApiConfig;
import com.openpay.marvel.api.rest.service.MarvelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MarvelServiceImpl implements MarvelService {

    private final MarvelApiClient marvelApiClient;
    private final MarvelApiConfig marvelApiConfig;


    @Autowired
    public MarvelServiceImpl(
            MarvelApiClient marvelApiClient,
            MarvelApiConfig marvelApiConfig) {
        this.marvelApiClient = marvelApiClient;
        this.marvelApiConfig = marvelApiConfig;
    }

    @Override
    public MarvelResponse getCharacters( Integer limit, Integer offset) {
        return marvelApiClient.getCharacters(
                marvelApiConfig.getPrivateKey(),
                marvelApiConfig.getPublicKey(),
                limit,
                offset
        );
    }

    @Override
    public MarvelResponse getCharacterById(Integer characterId) {
        return marvelApiClient.getCharacterById(
                characterId,
                marvelApiConfig.getPrivateKey(),
                marvelApiConfig.getPublicKey()
        );
    }
}