package com.openpay.marvel.api.client.service;

import com.openpay.marvel.api.client.model.MarvelResponse;

public interface MarvelApiClient {
    MarvelResponse getCharacters(String privateKey, String publicKey, Integer limit, Integer offset);
    MarvelResponse getCharacterById(Integer characterId, String privateKey, String publicKey );
}
