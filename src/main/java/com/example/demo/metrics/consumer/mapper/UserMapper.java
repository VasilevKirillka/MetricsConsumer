package com.example.demo.metrics.consumer.mapper;

import com.example.demo.metrics.consumer.dto.UserDto;
import com.example.demo.metrics.consumer.entity.UserEntity;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Интерфейс для автоматического маппинга данных о пользователях
 */
@Mapper(componentModel = "spring")
@Component
public interface UserMapper {
    /**
     *
     * @param entity Принимает UserEntity
     * @return Возвращает UserDto
     */
    UserDto entityToDto(UserEntity entity);

    /**
     *
     * @param dto Принимает UserDto
     * @return Возвращает UserEntity
     */
    UserEntity dtoToEntity(UserDto dto);

    /**
     *
     * @param entityList Принимает список UserEntity
     * @return Возвращает список UserEntity
     */
    List<UserDto> entityToDtoList(List<UserEntity> entityList);

    /**
     *
     * @param dtoList Принимает список UserDto
     * @return Возвращает список UserEntity
     */
    List<UserEntity> dtoToEntityList(List<UserDto> dtoList);
}
