package com.example.assignment.service;

import com.example.assignment.dto.MealDto;
import com.example.assignment.dto.MealRequestDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Meal service.
 */
public interface MealService {

    @Transactional(readOnly = true)
    MealDto fetchMeal(Long id);

    @Transactional(readOnly = true)
    List<MealDto> fetchMeals();

    MealDto insertMeal(MealRequestDto dto);
}
