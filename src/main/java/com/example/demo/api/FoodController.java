package com.example.demo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Food;
import com.example.demo.service.FoodService;

import java.util.List;

@RequestMapping("api/v1/food")
@RestController
public class FoodController {
    
    private final FoodService foodService;

    @Autowired
    public FoodController (FoodService foodService) {
        this.foodService = foodService;
    }
    
    @PostMapping
    public void addFood(@RequestBody Food food) {
        foodService.addFood(food);
    }

    @GetMapping
    public List<Food> getAllFood() {
        return foodService.getAllFood();
    }
}
