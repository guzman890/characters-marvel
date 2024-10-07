package com.openpay.marvel.api.rest.controller;

import com.openpay.marvel.api.client.model.MarvelResponse;
import com.openpay.marvel.api.rest.service.MarvelService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.openpay.marvel.api.rest.util.TestUtils;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CharacterControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MarvelService marvelService;

    @Autowired
    private TestUtils testUtils;

    private String token;

    @BeforeEach
    public void setUp() throws Exception {
        this.token = testUtils.registerAndLogin();
    }

    @Test
    public void testGetCharacters() throws Exception {
        MarvelResponse mockResponse = new MarvelResponse();
        when(marvelService.getCharacters(anyInt(), anyInt())).thenReturn(mockResponse);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/characters")
                        .param("limit", "10")
                        .param("offset", "0")
                        .header("Authorization", "Bearer " + token)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("{}"));
    }

    @Test
    public void testGetCharacterById() throws Exception {
        MarvelResponse mockResponse = new MarvelResponse();
        when(marvelService.getCharacterById(anyInt())).thenReturn(mockResponse);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/characters/1")
                        .header("Authorization", "Bearer " + token)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("{}"));
    }
}