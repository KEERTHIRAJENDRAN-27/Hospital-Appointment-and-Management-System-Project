package com.cts.project.feignclient;

import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cts.project.dto.PatientProfile;

@FeignClient(name = "PATIENTREGISTRATIONANDPROFILEMANAGEMENTMODULE", url = "http://localhost:8001/patients")
public interface PatientClient {
	@PostMapping("/save")
	public String createPatient(@RequestBody PatientProfile dto);

	@GetMapping("/fetchByid/{id}")
	PatientProfile getPatientById(@PathVariable("id") Long patientId);
}
