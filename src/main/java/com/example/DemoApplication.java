package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.model.ToDo;
import com.example.repository.ToDoRepository;

@SpringBootApplication
public class DemoApplication {
	
	private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner setup(ToDoRepository toDoRepository) {
		return (args) -> {
			toDoRepository.save(new ToDo("Remove unused imports", true));
			toDoRepository.save(new ToDo("Clean the code", true));
			toDoRepository.save(new ToDo("Build the artifacts", false));
			toDoRepository.save(new ToDo("Deploy the jar file", true));
			logger.info("The sample data has been generated");
		};
	}
}
