package com.openpay.marvel.api.client.service.impl;

import com.openpay.marvel.api.client.model.MarvelResponse;
import com.openpay.marvel.api.client.service.MarvelApiClient;
import com.openpay.marvel.api.client.web.MarvelApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class MarvelApiClientImpl implements MarvelApiClient {

    private final MarvelApi marvelApi;

    @Autowired
    public MarvelApiClientImpl(MarvelApi marvelApi) {
        this.marvelApi = marvelApi;
    }

    @Override
    public MarvelResponse getCharacters(String privateKey, String publicKey, Integer limit, Integer offset) {
        long timestamp = System.currentTimeMillis();
        String hash = generateHash(timestamp, privateKey, publicKey);
        return marvelApi.getCharacters(timestamp, publicKey, hash, limit, offset);
    }

    @Override
    public MarvelResponse getCharacterById(Integer characterId, String privateKey, String publicKey ) {
        long timestamp = System.currentTimeMillis();
        String hash = generateHash(timestamp, privateKey, publicKey);
        return marvelApi.getCharacterById(characterId, timestamp, publicKey, hash);
    }

    private String generateHash(long timestamp, String privateKey, String publicKey) {
        try {
            String toHash = timestamp + privateKey + publicKey;
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(toHash.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte aMessageDigest : messageDigest) {
                String hex = Integer.toHexString(0xff & aMessageDigest);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error generating MD5 hash", e);
        }
    }

}