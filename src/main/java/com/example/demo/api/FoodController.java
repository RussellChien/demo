package com.example.demo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.*;
import com.example.demo.service.*;

@RestController
public class FoodController {
    
    private final FoodService foodService;

    @Autowired
    public FoodController (FoodService foodService) {
        this.foodService = foodService;
    }
    
    @PostMapping
    public void addFood(Food food) {
        foodService.addFood(food);
    }
}
