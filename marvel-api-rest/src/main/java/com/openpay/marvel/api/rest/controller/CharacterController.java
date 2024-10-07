package com.openpay.marvel.api.rest.controller;

import com.openpay.marvel.api.client.model.MarvelResponse;
import com.openpay.marvel.api.rest.service.MarvelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/characters")
public class CharacterController {

    private final MarvelService marvelService;

    @Autowired
    public CharacterController(MarvelService marvelService) {
        this.marvelService = marvelService;
    }

    @GetMapping
    public ResponseEntity<MarvelResponse> getCharacters(
            @RequestParam(defaultValue = "20") Integer limit,
            @RequestParam(defaultValue = "0") Integer offset) {

        MarvelResponse characters = marvelService.getCharacters(limit, offset);
        return ResponseEntity.ok(characters);
    }
    @GetMapping("/{characterId}")
    public ResponseEntity<MarvelResponse> getCharacterById(
            @PathVariable Integer characterId) {

        MarvelResponse character = marvelService.getCharacterById(characterId);
        return ResponseEntity.ok(character);
    }
}