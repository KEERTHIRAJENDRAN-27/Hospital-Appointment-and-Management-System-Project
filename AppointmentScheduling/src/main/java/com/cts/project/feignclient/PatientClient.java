package com.cts.project.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.cts.project.dto.PatientProfile;

@FeignClient(name = "PATIENT-SERVICE", url = "http://localhost:8001")

public interface PatientClient {
	@GetMapping("/patients/{id}")
	PatientProfile getPatient(Long id);
}