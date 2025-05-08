package com.cts.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PatientRegistrationandProfileManagementModuleApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatientRegistrationandProfileManagementModuleApplication.class, args);
	}

}
