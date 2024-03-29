package com.example.demo.service;

import com.example.demo.model.Food;
import com.example.demo.dao.FoodDao;    

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.Optional;

@Service
public class FoodService {

    private final FoodDao foodDao;

    @Autowired
    public FoodService(@Qualifier("postgres") FoodDao foodDao) {
        this.foodDao = foodDao;
    }

    public int addFood(Food food) {
        return foodDao.insertFood(food);
    }

    public List<Food> getAllFood() {
        return foodDao.selectAllFood();
    }

    public Optional<Food> getFood(UUID id) {
        return foodDao.selectFood(id);
    }

    public int deleteFood(UUID id) {
        return foodDao.deleteFood(id);
    }

    public int updateFood(UUID id, Food food) {
        return foodDao.updateFood(id, food);
    }
}
