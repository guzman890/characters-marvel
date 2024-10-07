package com.openpay.marvel.api.client.model;

import lombok.Data;

import java.util.List;

@Data
public class Stories {
    private int available;
    private String collectionURI;
    private List<Item> items;
    private int returned;
}
