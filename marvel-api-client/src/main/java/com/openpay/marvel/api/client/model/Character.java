package com.openpay.marvel.api.client.model;

import lombok.Data;

@Data
public class Character {
    private int id;
    private String name;
    private String description;
    private String thumbnailPath; // Ruta a la imagen del personaje
}
