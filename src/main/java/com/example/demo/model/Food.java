package com.example.demo.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class Food {

    private final UUID id;

    @NotBlank
    private final String name;
    
    private final double price;

    public Food (@JsonProperty("id") UUID id, 
                @JsonProperty("name") String name, 
                @JsonProperty("price") double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public UUID getId() { return id; }

    public String getName() { return name; }

    public double getPrice() { return price; }
}