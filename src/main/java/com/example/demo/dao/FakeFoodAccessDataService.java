package com.example.demo.dao;

import com.example.demo.model.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.ArrayList;
import java.util.UUID;

@Repository("FakeDao")
public class FakeFoodAccessDataService implements FoodDao {
    
    private static List<Food> DB = new ArrayList<>();

    @Override
    public int insertFood(UUID id, Food food) {
        DB.add(new Food(id, food.getName(), food.getPrice()));
        return 1;
    }
}
