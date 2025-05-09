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
import org.springframework.web.bind.annotation.RestController;

import com.cts.project.dto.PatientProfileDTO;
import com.cts.project.service.PatientProfileService;

@RestController
@RequestMapping("/patients")
public class PatientController {
	@Autowired
	private PatientProfileService service;

	@PostMapping("/save")
//	@ResponseStatus(code = org.springframework.http.HttpStatus.CREATED)
	public String createPatient(@RequestBody PatientProfileDTO dto) {
		service.registerPatient(dto);
		return "Patient registered successfully";
	}

	@PutMapping("/update/{id}")
	public String updatePatient(@PathVariable Long id, @RequestBody PatientProfileDTO dto) {
		service.updatePatient(id, dto);
		return "Patient updated successfully";
	}

	@GetMapping("/fetchByid/{id}")
	public PatientProfileDTO getPatientById(@PathVariable Long id) {
		return service.getPatientById(id);
	}

	@GetMapping("/fetchAll")
	public List<PatientProfileDTO> getAllPatients() {
		return service.getAllPatients();
	}

	@DeleteMapping("/delete/{id}")
	public String deletePatient(@PathVariable Long id) {
		service.deletePatient(id);
		return "Patient deleted successfully";
	}
}
