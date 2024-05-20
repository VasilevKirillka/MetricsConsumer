package com.example.demo.metrics.consumer.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * Сущность с данными об ошибке.
 */
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorEntity {
    /**
     * Идентификатор
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * Ошибка
     */
    private Exception exception;
    @Column(name = "error_time")
    /**
     * Время возникновения ошибки
     */
    private LocalDateTime errorTime;
}
