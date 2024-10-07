package com.openpay.marvel.api.client.model;

@lombok.Data
public class MarvelResponse {
    private int code;
    private String status;
    private String copyright;
    private String attributionText;
    private String attributionHTML;
    private String etag;
    private Data data;
}
