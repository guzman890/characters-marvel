package com.openpay.marvel.api.rest.service;

import com.openpay.marvel.api.client.model.MarvelResponse;

public interface MarvelService {
    MarvelResponse getCharacters(Integer limit, Integer offset);
    MarvelResponse getCharacterById(Integer characterId);
}
