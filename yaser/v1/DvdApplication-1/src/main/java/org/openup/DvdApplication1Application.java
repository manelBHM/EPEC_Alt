package org.openup;

import org.openup.repo.DvdRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DvdApplication1Application {

	public static void main(String[] args) {
		ApplicationContext	ctx=SpringApplication.run(DvdApplication1Application.class, args);
		DvdRepository dvdRepository = ctx.getBean(DvdRepository.class);
	}

}
