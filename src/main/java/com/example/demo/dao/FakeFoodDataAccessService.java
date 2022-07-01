package com.example.demo.dao;

import com.example.demo.model.Food;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.ArrayList;
import java.util.UUID;

@Repository("fakeDao")
public class FakeFoodDataAccessService implements FoodDao {
    
    private static List<Food> DB = new ArrayList<>();

    @Override
    public int insertFood(UUID id, Food food) {
        DB.add(new Food(id, food.getName(), food.getPrice()));
        return 1;
    }

    @Override
    public List<Food> selectAllFood() {
        return DB;
    }

}
