package com.example.exoBootOnKubernetes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@Import({springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration.class})
public class ExoBootOnKubernetesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExoBootOnKubernetesApplication.class, args);
	}
}//il faut creer un chemin d'environnement pour java JAVA_HOME
