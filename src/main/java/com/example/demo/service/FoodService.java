package com.example.demo.service;

import com.example.demo.model.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.example.demo.dao.*;

@Service
public class FoodService {

    private final FoodDao foodDao;

    @Autowired
    public FoodService(@Qualifier("fakeDao") FoodDao foodDao) {
        this.foodDao = foodDao;
    }

    public int addFood(Food food) {
        return foodDao.insertFood(food);
    }
}
