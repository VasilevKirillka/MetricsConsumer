package com.example.demo.metrics.consumer.repository;

import com.example.demo.metrics.consumer.entity.ErrorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Репозиторий для сущности ErrorEntity.
 */
public interface ErrorRepository extends JpaRepository<ErrorEntity, Long> {
}
