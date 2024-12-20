package com.example.assignment.service.impl;

import com.example.assignment.dto.MealDto;
import com.example.assignment.dto.MealRequestDto;
import com.example.assignment.mapper.MealMapper;
import com.example.assignment.model.Meal;
import com.example.assignment.repository.MealRepository;
import com.example.assignment.service.MealService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Meal Service Impl.
 */
@Service
public class MealServiceImpl implements MealService {
    private final MealRepository mealRepository;

    private final Logger LOGGER = LoggerFactory.getLogger(MealServiceImpl.class);

    public MealServiceImpl(final MealRepository mealRepository) {
        this.mealRepository = mealRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public MealDto fetchMeal(Long id) {
        LOGGER.info("Fetch meal - START");
        Meal meal = mealRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Meal not found"));
        LOGGER.info("Meal: {}", meal.toString());
        LOGGER.info("Fetch meal - END");
        return MealMapper.INSTANCE.toDto(meal);
    }

    @Override
    @Transactional(readOnly = true)
    public List<MealDto> fetchMeals() {
        LOGGER.info("Fetch meals - START");
        List<Meal> meals = mealRepository.findAll();
        LOGGER.info("Meals: {}", meals);
        LOGGER.info("Fetch meals - END");
        return MealMapper.INSTANCE.toDtos(meals);
    }

    @Override
    public MealDto insertMeal(MealRequestDto dto) {
        LOGGER.info("Insert meal - START");
        Meal meal = dto.buildMeal();
        LOGGER.info("Meal: {}", meal);
        LOGGER.info("Insert meal - END");
        return MealMapper.INSTANCE.toDto(
                mealRepository.save(meal)
        );
    }
}
