package com.example.assignment.dto;

import com.example.assignment.model.Meal;

/**
 * Meal request dto.
 */
public record MealRequestDto(String date, String image, String type) {

    /**
     * Build meal.
     */
    public Meal buildMeal() {
        Meal meal = new Meal();
        meal.setDate(this.date);
        meal.setImage(this.image);
        meal.setType(this.type);
        return meal;
    }
}
