package com.example.demo.dao;

import com.example.demo.model.Food;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.ArrayList;
import java.util.UUID;
import java.util.Optional;
import java.util.Map;

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

    @Override
    public Optional<Food> selectFood(UUID id) {
        return DB.stream().filter(food -> food.getId().equals(id)).findFirst();
    }
    
    @Override
    public int deleteFood(UUID id) {
        Optional<Food> foodMaybe = selectFood(id);
        if (foodMaybe.isEmpty()) return 0;
        DB.remove(foodMaybe.get());
        return 1;
    }

    @Override
    public int updateFood(UUID id, Food update) {
        return selectFood(id)
            .map(food -> {
                int indexOfFoodToUpdate = DB.indexOf(food);
                if (indexOfFoodToUpdate >= 0) {
                    DB.set(indexOfFoodToUpdate, new Food(id, update.getName(), update.getPrice()));
                    return 1;
                }
                return 0;
            })
            .orElse(0);
    }

}
