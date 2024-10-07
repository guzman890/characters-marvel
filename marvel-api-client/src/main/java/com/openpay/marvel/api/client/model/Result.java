package com.openpay.marvel.api.client.model;

import lombok.Data;

import java.util.List;

@Data
public class Result {
    private int id;
    private String name;
    private String description;
    private String modified;
    private Thumbnail thumbnail;

    private String resourceURI;
    private Comics comics;
    private Series series;
    private Stories stories;
    private Events events;
    private List<Url> urls;
}
