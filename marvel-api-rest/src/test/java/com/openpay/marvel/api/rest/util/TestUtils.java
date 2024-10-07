package com.openpay.marvel.api.rest.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.openpay.marvel.api.rest.model.AuthenticationRequest;
import com.openpay.marvel.api.rest.model.AuthenticationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@Component
public class TestUtils {

    public static Integer currentUser = 0;
    @Autowired
    public MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    public String registerAndLogin() throws Exception {
        // Register
        mockMvc.perform(MockMvcRequestBuilders.post("/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"username\": \"testuser"+currentUser+"\", \"password\": \"testpass\"}"))
                .andExpect(MockMvcResultMatchers.status().isOk());

        // Login and get token
        // Login and get token
        AuthenticationRequest authRequest = new AuthenticationRequest();
        authRequest.setUsername("testuser"+currentUser);
        authRequest.setPassword("testpass");
        String response = mockMvc.perform(MockMvcRequestBuilders.post("/authenticate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(authRequest)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        AuthenticationResponse authResponse = objectMapper.readValue(response, AuthenticationResponse.class);
        currentUser++;
        return authResponse.getJwt();
    }
}
