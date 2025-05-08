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

import com.cts.project.dto.AppointmentPatientRequestDTO;
import com.cts.project.dto.AppointmentPatientResponseDTO;
import com.cts.project.service.AppointmentService;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

	@Autowired
	private AppointmentService service;

	@PostMapping("/save")
	public AppointmentPatientResponseDTO create(@RequestBody AppointmentPatientRequestDTO dto) {
		return service.create(dto);
	}

	@PutMapping("/update/{id}")
	public AppointmentPatientResponseDTO update(@PathVariable Long id, @RequestBody AppointmentPatientRequestDTO dto) {
		return service.update(id, dto);
	}

	@GetMapping("/fetchByid/{id}")
	public AppointmentPatientResponseDTO get(@PathVariable Long id) {
		return service.getById(id);
	}

	@GetMapping("/fetchAll")
	public List<AppointmentPatientResponseDTO> all() {
		return service.getAll();
	}

	@DeleteMapping("/Delete/{id}")
	public String delete(@PathVariable Long id) {
		return service.delete(id);
	}
}
