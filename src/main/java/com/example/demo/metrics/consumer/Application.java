package com.example.demo.metrics.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Metrics Consumer
 * Программа Metrics Consumer принимает из Metrics Producer данные (метрики, DTO и т.д.),
 * обработывает и выводит статистику с помощью Api
 *
 * @author Кирилл
 */

@SpringBootApplication
public class Application {
	/**
	 *Этот метод запускает приложение Metrics Consumer.
	 *
	 * @param args Аргументы командной строки
	 */
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
