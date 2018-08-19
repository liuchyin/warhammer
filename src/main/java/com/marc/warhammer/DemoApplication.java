package com.marc.warhammer;

//import org.apache.log4j.BasicConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DemoApplication {

	public static void main(String[] args) {
		//BasicConfigurator.configure();
		SpringApplication.run(DemoApplication.class, args);
	}
}
