package com.example.assignment.controller;

import com.example.assignment.dto.MealDto;
import com.example.assignment.dto.MealRequestDto;
import com.example.assignment.service.MealService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Meal Controller.
 */
@RestController
@RequestMapping("/api/v1/meals")
public class MealController {

    private final MealService mealService;

    public MealController(final MealService mealService) {
        this.mealService = mealService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<MealDto> findMeal(@PathVariable Long id) {
        MealDto meal;
        try {
            meal = this.mealService.fetchMeal(id);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(meal);
    }

    @GetMapping()
    public ResponseEntity<List<MealDto>> findMeals() {
        return ResponseEntity.ok(this.mealService.fetchMeals());
    }

    @PostMapping()
    public ResponseEntity<MealDto> insertMeal(@RequestBody MealRequestDto dto) {
        return ResponseEntity.ok(this.mealService.insertMeal(dto));
    }
}
