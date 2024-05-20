package com.example.demo.metrics.consumer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

/**
 * Класс с данными об ошибке
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDto {
    /**
     * Идентификатор ошибки
     */
    public Long id;
    /**
     * Ошибка
     */
    private Exception exception;
    /**
     * Время возникновения ошибки
     */
    private LocalDateTime errorTime;
}
