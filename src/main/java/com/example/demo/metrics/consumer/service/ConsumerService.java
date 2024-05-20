package com.example.demo.metrics.consumer.service;

import com.example.demo.metrics.consumer.dto.ErrorDto;
import com.example.demo.metrics.consumer.dto.UserDto;
import com.example.demo.metrics.consumer.mapper.ErrorMapper;
import com.example.demo.metrics.consumer.mapper.UserMapper;
import com.example.demo.metrics.consumer.repository.ErrorRepository;
import com.example.demo.metrics.consumer.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Base64;
import java.util.List;


/**
 * Класс сервиса, который слушает сообщения из Kafka,
 * сохраняет данные в БД и возвращает эти данные
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class ConsumerService {

    private final UserRepository userRepository;
    private final UserMapper mapper;

    private final ErrorMapper errorMapper;
    private final ErrorRepository errorRepository;

    private final ObjectMapper objectMapper;

    /**
     * Метод, прослушивающий данные из topic1,
     * обрабатывающий их и сохраняющий в БД
     * @param user Объект с данными пользователя
     */
    @KafkaListener(id = "userGroup", topics = "topic1")
    public void listen(UserDto user){
        log.info("listen: {}", user);
        if(user.getFirstName()==null || user.getFirstName().isEmpty()){
            throw new RuntimeException("Неверные данные!!!");
        }
        userRepository.save(mapper.dtoToEntity(user));
    }

    /**
     * Метод для прослушивания сообщений из топика "topic1.DLT" и обработки сообщений об ошибках.
     * @param input Строка с ошибкой
     */
    @KafkaListener(id = "dltGroup", topics = "topic1.DLT")
    public void dlt(String input){
        try {
            String decodedJson = new String(Base64.getDecoder().decode(input));
            Object jsonObject = objectMapper.readValue(decodedJson, Object.class);
            log.info("DLT Топик: {}", jsonObject);
        } catch (IOException e) {
            log.error("Ошибка: {}", e.getMessage());
        }
    }
    /**
     * Получение данных о пользователе по его идентификатору.
     *
     * @param id Идентификатор пользователя
     * @return Объект с данными пользователя или null, если пользователя не найдено
     */
    public UserDto getUserMetricById(Long id){
        var user= userRepository.findById(id);
        return user.map(mapper::entityToDto).orElse(null);
    }
    /**
     * Получение списка всех пользователей.
     *
     * @return Список объектов с данными всех пользователей
     */
    public List<UserDto> getAllMetrics(){
        return mapper.entityToDtoList(userRepository.findAll());
    }

    /**
     * Метод для прослушивания сообщений об ошибках из топика "error.topic"
     * и сохранения их данных.
     *
     * @param exception Объект с данными об ошибке
     */
    @KafkaListener(id= "errGroup", topics = "error.topic")
    public void errorMsg(ErrorDto exception){
        log.info("errorMsg: {}", exception);
        errorRepository.save(errorMapper.dtoToEntity(exception));
    }
    /**
     * Получение списка всех ошибок.
     *
     * @return Список объектов с данными об ошибках
     */
    public List<ErrorDto> getAllErrorMetrics(){
        return errorMapper.entityToDtoList(errorRepository.findAll());
    }

}
