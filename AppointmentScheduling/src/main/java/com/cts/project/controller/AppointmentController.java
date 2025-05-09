package com.cts.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.project.dto.AppointmentDTO;
import com.cts.project.model.Appointment;
import com.cts.project.service.AppointmentService;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

	@Autowired
	private AppointmentService appointmentService;

	@PostMapping("/save")
	public String createAppointment(@RequestBody AppointmentDTO dto) {
		return appointmentService.createAppointment(dto);
	}

	@PutMapping("/update/{id}")
	public String updateAppointment(@PathVariable Long id, @RequestBody AppointmentDTO dto) {
		return appointmentService.updateAppointment(id, dto);
	}

	@GetMapping("/fetchByid/{id}")
	public Appointment getAppointmentById(@PathVariable Long id) {
		return appointmentService.getAppointmentById(id);
	}

	@GetMapping("/all")
	public Iterable<Appointment> getAllAppointments() {
		return appointmentService.getAllAppointments();
	}

	@DeleteMapping("/delete/{id}")
	public String deleteAppointment(@PathVariable Long id) {
		return appointmentService.deleteAppointment(id);
	}
}
