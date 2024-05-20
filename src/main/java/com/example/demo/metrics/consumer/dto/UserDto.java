package com.example.demo.metrics.consumer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Класс с данными пользователя
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    /**
     * Идентификатор пользователя
     */
    private Long id;
    /**
     * Имя пользователя
     */
    private String firstName;
    /**
     * Фамилия пользователя
     */
    private String lastName;
    /**
     * Возраст пользователя
     */
    private Integer age;
}
