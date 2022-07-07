package com.example.demo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Food;
import com.example.demo.service.FoodService;

import java.util.UUID;
import java.util.List;
import javax.validation.Valid;

@RequestMapping("api/v1/food")
@RestController
public class FoodController {
    
    private final FoodService foodService;

    @Autowired
    public FoodController (FoodService foodService) {
        this.foodService = foodService;
    }
    
    @PostMapping
    public void addFood(@Valid @NonNull @RequestBody Food food) {
        foodService.addFood(food);
    }

    @GetMapping
    public List<Food> getAllFood() {
        return foodService.getAllFood();
    }

    @GetMapping(path = "{id}")
    public Food getFood(@PathVariable("id") UUID id) {
        return foodService.getFood(id).orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deleteFood(@PathVariable("id") UUID id) {
        foodService.deleteFood(id);
    }

    @PutMapping(path = "{id}")
    public void updateFood(@PathVariable("id") UUID id, @Valid @NonNull @RequestBody Food foodToUpdate) {
        foodService.updateFood(id, foodToUpdate);
    }
}
