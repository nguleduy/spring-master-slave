package com.example.assignment.mapper;

import com.example.assignment.dto.MealDto;
import com.example.assignment.model.Meal;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Meal Mapper.
 */
@Mapper
public interface MealMapper {
    MealMapper INSTANCE = Mappers.getMapper(MealMapper.class);

    MealDto toDto(Meal entity);

    List<MealDto> toDtos(List<Meal> entities);

}
