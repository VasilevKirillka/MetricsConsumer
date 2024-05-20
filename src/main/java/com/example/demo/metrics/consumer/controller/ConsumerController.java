package com.example.demo.metrics.consumer.controller;

import com.example.demo.metrics.consumer.service.ConsumerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Класс контроллера, который выводит данные, полученные из Producer
 */
@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class ConsumerController {
    private final ConsumerService service;

    /**
     * Получение метрики пользователя по его идентификатору.
     *
     * @param id Идентификатор пользователя
     * @return Ответ с данными метрики пользователя
     */
    @GetMapping("/metrics/{id}")
    public ResponseEntity getMetricById(@PathVariable("id") Long id){
        return ResponseEntity.ok(service.getUserMetricById(id));
    }
    /**
     * Получение всех метрик пользователей.
     *
     * @return Ответ со всеми метриками
     */
    @GetMapping("/metrics")
    public ResponseEntity getAllMetrics(){
        return ResponseEntity.ok(service.getAllMetrics());
    }
    /**
     * Получение всех метрик ошибок.
     *
     * @return Ответ со всеми метриками ошибок
     */
    @GetMapping("/errorMetrics")
    public ResponseEntity getAllErrorMetrics(){
        return ResponseEntity.ok(service.getAllErrorMetrics());
    }
}
