package com.student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Repository;

@SpringBootApplication
@EnableJpaAuditing
@Configuration
@EnableAutoConfiguration
@EnableScheduling
@ComponentScan ({"com.server", "com.server.config"})
@Repository
public class StudentEnrollApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(StudentEnrollApplication.class, args);

	}

}
