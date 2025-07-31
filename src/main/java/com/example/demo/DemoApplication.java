package com.example.demo;

import com.example.demo.otc.ApplicationService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements ApplicationRunner {

	private final ApplicationService applicationService;

	public DemoApplication(ApplicationService applicationService) {
		this.applicationService = applicationService;
	}

	public static void main(String[] args){
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		//test vcf calculator
		applicationService.calculateTonnage(2,800.0, 15);

	}
}
