package com.example.demo.metrics.consumer.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.listener.CommonErrorHandler;
import org.springframework.kafka.listener.DeadLetterPublishingRecoverer;
import org.springframework.kafka.listener.DefaultErrorHandler;
import org.springframework.kafka.support.converter.RecordMessageConverter;
import org.springframework.kafka.support.converter.StringJsonMessageConverter;
import org.springframework.util.backoff.FixedBackOff;

/**
 * Конфигурация Kafka.
 */
@Configuration
public class KafkaConfig {
    /**
     * Создание нового топика Kafka.
     * @return Новый топик "topic1".
     */
    @Bean
    public NewTopic topic(){
        return new NewTopic("topic1", 1, (short) 1);
    }
    /**
     * Создание новой темы Kafka для DLT.
     * @return Новый топик "topic1.DLT".
     */
    @Bean
    public NewTopic dlt(){
        return new NewTopic("topic1.DLT", 1, (short) 1);
    }
    /**
     * Создание новой темы Kafka.
     * @return Новый топик "error.topic".
     */
    @Bean
    public NewTopic err(){
        return new NewTopic("error.topic", 1, (short) 1);
    }
    /**
     * Конвертер сообщений записи.
     * @return Конвертер сообщений.
     */
    @Bean
    public RecordMessageConverter converter(){
        return new StringJsonMessageConverter();
    }

    /**
     * Обработчик общих ошибок Kafka.
     * @param operations KafkaTemplate для операций.
     * @return Обработчик ошибок по умолчанию, который с интервалом в 1 секунду делает 2 попытки
     */
    @Bean
    public CommonErrorHandler errorHandler(KafkaTemplate<Object, Object> operations){
        return new DefaultErrorHandler(new DeadLetterPublishingRecoverer(operations),
                new FixedBackOff(1000L, 2));
    }
}
