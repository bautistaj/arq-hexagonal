package com.btaj.app;

import com.btaj.app.adapters.out.dbs.nosql.mongo.mondodb.GenericMongoRepository;
import com.btaj.app.adapters.out.dbs.nosql.mongo.mondodb.SpecialtyMongoRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@ComponentScan("com.btaj.app")
@EnableMongoRepositories(basePackageClasses = SpecialtyMongoRepository.class)
public class AppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

}
