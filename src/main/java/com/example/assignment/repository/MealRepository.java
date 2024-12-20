package com.example.assignment.repository;

import com.example.assignment.model.Meal;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Meal Repository.
 */
@Repository
public interface MealRepository extends JpaRepository<Meal, Long> {

    @NotNull
    Optional<Meal> findById(@NotNull Long id);
}
