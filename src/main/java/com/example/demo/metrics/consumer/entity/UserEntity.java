package com.example.demo.metrics.consumer.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/**
 * Сущьность с данными пользователя
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
    /**
     * Идентификатор пользователя
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * Имя пользователя
     */
    @Column(name = "first_name")
    private String firstName;
    /**
     * Фамилия пользователя
     */
    @Column(name = "last_name")
    private String lastName;
    /**
     * Возраст пользователя
     */
    private Integer age;
}
