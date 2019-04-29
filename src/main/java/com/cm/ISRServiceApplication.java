package com.cm;

import com.cm.service.ISRServiceImpl;
import com.google.inject.Inject;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ISRServiceApplication implements CommandLineRunner {

	ISRServiceImpl sueldoService;
	@Inject
	public ISRServiceApplication(ISRServiceImpl sueldoService) {
		this.sueldoService = sueldoService;
	}

	public static void main(String[] args) {
		SpringApplication.run(ISRServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {



	}
}
