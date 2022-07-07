package com.example.demo.dao;

import com.example.demo.model.Food;

import java.util.List;
import java.util.UUID;
import java.util.Optional;

import org.springframework.stereotype.Repository;

@Repository("postgres")
public class FoodDataAccessService implements FoodDao {
    @Override
    public int insertFood(UUID id, Food food) {
        return 0;
    }

    @Override
    public List<Food> selectAllFood() {
        return List.of(new Food(UUID.randomUUID(), "from postgres", 0.0));
    }

    @Override
    public Optional<Food> selectFood(UUID id) {
        return Optional.empty();
    }
    
    @Override
    public int deleteFood(UUID id) {
        return 0;
    }

    @Override
    public int updateFood(UUID id, Food update) {
        return 0;
    }
}
