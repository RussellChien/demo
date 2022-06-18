package com.example.demo.dao;

import com.example.demo.model.*;

import java.util.UUID;

public interface FoodDao {
    int insertFood(UUID id, Food food);

    default int insertFood(Food food) {
        UUID id = UUID.randomUUID();
        return insertFood(id, food);
    }  
}