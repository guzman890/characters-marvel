package com.openpay.marvel.api.client.model;

import java.util.List;

@lombok.Data
public class Data {
    private int offset;
    private int limit;
    private int total;
    private int count;
    private List<Result> results;
}
