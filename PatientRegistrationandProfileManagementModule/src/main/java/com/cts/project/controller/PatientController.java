package com.cts.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cts.project.dto.PatientProfileDTO;
import com.cts.project.model.PatientProfile;
import com.cts.project.service.PatientProfileService;

@RestController
@RequestMapping("/patients")
public class PatientController {
	@Autowired
	private PatientProfileService service;

	@PostMapping("/save")
	@ResponseStatus(code = org.springframework.http.HttpStatus.CREATED)
	public String createPatient(@RequestBody PatientProfileDTO dto) {
		return service.createPatient(dto);
	}

	@PutMapping("/update/{id}")
	public String updatePatient(@PathVariable Long id, @RequestBody PatientProfileDTO dto) {
		return service.updatePatient(id, dto);
	}

	@GetMapping("/fetchByid/{id}")
	public PatientProfile getPatientById(@PathVariable Long id) {
		return service.getPatientById(id);
	}

	@GetMapping("/fetchAll")
	public List<PatientProfile> getAllPatients() {
		return service.getAllPatients();
	}

	@DeleteMapping("/Delete/{id}")
	@ResponseStatus(code = org.springframework.http.HttpStatus.NO_CONTENT)
	public String deletePatient(@PathVariable Long id) {
		return service.deletePatient(id);
	}
}
