package com.openpay.marvel.api.client.service.impl;

import com.openpay.marvel.api.client.model.MarvelResponse;
import com.openpay.marvel.api.client.web.MarvelApi;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

public class MarvelApiClientImplTest {

    @Mock
    private MarvelApi marvelApi;

    @InjectMocks
    private MarvelApiClientImpl marvelApiClient;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetCharacters() {
        MarvelResponse mockResponse = new MarvelResponse();
        when(marvelApi.getCharacters(anyLong(), anyString(), anyString(), anyInt(), anyInt())).thenReturn(mockResponse);

        MarvelResponse response = marvelApiClient.getCharacters("privateKey", "publicKey", 10, 0);

        assertNotNull(response);
    }

    @Test
    public void testGetCharacterById() {
        MarvelResponse mockResponse = new MarvelResponse();
        when(marvelApi.getCharacterById(anyInt(), anyLong(), anyString(), anyString())).thenReturn(mockResponse);

        MarvelResponse response = marvelApiClient.getCharacterById(1, "privateKey", "publicKey");

        assertNotNull(response);
    }
}