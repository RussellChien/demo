package com.example.demo.dao;

import com.example.demo.model.Food;

import java.util.UUID;
import java.util.List;

public interface FoodDao {

    int insertFood(UUID id, Food food);

    default int insertFood(Food food) {
        UUID id = UUID.randomUUID();
        return insertFood(id, food);
    }  

    List<Food> selectAllFood();
}