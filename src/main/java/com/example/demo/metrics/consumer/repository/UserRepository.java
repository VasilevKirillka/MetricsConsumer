package com.example.demo.metrics.consumer.repository;

import com.example.demo.metrics.consumer.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Репозиторий для сущности UserEntity.
 */
public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
