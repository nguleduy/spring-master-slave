package com.example.assignment.dto;

import lombok.Data;

/**
 * Meal dto.
 */
@Data
public class MealDto {
    private Long id;
    private String date;
    private String image;
    private String type;
}
