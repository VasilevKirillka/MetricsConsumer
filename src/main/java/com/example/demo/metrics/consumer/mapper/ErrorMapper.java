package com.example.demo.metrics.consumer.mapper;

import com.example.demo.metrics.consumer.dto.ErrorDto;
import com.example.demo.metrics.consumer.dto.UserDto;
import com.example.demo.metrics.consumer.entity.ErrorEntity;
import com.example.demo.metrics.consumer.entity.UserEntity;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Интерфейс для автоматического маппинга данных об ошибках
 */
@Mapper(componentModel = "spring")
@Component
public interface ErrorMapper {
    /**
     *
     * @param entity Принимает ErrorEntity
     * @return Возвращает ErrorDto
     */
    ErrorDto entityToDto(ErrorEntity entity);
    /**
     *
     * @param dto Принимает ErrorDto
     * @return Возвращает ErrorEntity
     */
    ErrorEntity dtoToEntity(ErrorDto dto);
    /**
     *
     * @param entityList Принимает список ErrorEntity
     * @return Возвращает список ErrorDto
     */
    List<ErrorDto> entityToDtoList(List<ErrorEntity> entityList);
    /**
     *
     * @param dtoList Принимает список ErrorDto
     * @return Возвращает список ErrorEntity
     */
    List<ErrorEntity> dtoToEntityList(List<ErrorDto> dtoList);


}
