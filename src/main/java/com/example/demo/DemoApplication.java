package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.example.repository.HotelRepository;

@SpringBootApplication(scanBasePackages="com.example")
@EnableMongoRepositories(basePackageClasses = HotelRepository.class)
public class DemoApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
