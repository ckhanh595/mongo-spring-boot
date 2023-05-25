package com.spring.mongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
//@EnableMongoRepositories("com.spring.mongo.repository")
//@ComponentScan("com.spring.mongo.*")
public class MongoSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongoSpringBootApplication.class, args);
	}

}
