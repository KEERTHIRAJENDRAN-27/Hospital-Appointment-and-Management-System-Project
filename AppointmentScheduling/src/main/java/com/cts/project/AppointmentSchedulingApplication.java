package com.cts.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
//@EnableFeignClients(basePackages = "com.cts.project.feignclient")
@EnableFeignClients
public class AppointmentSchedulingApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppointmentSchedulingApplication.class, args);
	}

}
