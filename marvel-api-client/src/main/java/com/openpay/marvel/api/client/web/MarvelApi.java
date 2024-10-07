package com.openpay.marvel.api.client.web;

import com.openpay.marvel.api.client.model.MarvelResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "marvel", url = "https://gateway.marvel.com/v1/public")
public interface MarvelApi {

    @GetMapping("/characters")
    MarvelResponse getCharacters(
            @RequestParam("ts") long timestamp,
            @RequestParam("apikey") String publicKey,
            @RequestParam("hash") String hash,
            @RequestParam("limit") Integer limit,
            @RequestParam("offset") Integer offset
    );

    @GetMapping("/characters/{characterId}")
    MarvelResponse getCharacterById(
            @PathVariable("characterId") Integer characterId,
            @RequestParam("ts") long timestamp,
            @RequestParam("apikey") String publicKey,
            @RequestParam("hash") String hash
    );

}