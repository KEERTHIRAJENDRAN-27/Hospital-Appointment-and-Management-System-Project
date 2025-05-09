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

import com.cts.project.dto.DoctorScheduleDTO;
import com.cts.project.model.DoctorSchedule;
import com.cts.project.service.DoctorScheduleService;

@RestController
@RequestMapping("/doctor")
public class DoctorScheduleController {

	@Autowired
	private DoctorScheduleService service;

	@PostMapping("/save")
	public String createSchedule(@RequestBody DoctorScheduleDTO dto) {
		return service.createSchedule(dto);
	}

	@GetMapping("/fetchByid/{doctorId}")
	public DoctorScheduleDTO getScheduleById(@PathVariable Long doctorId) {
		return service.getScheduleById(doctorId);
	}

	@GetMapping("/fetchAll")
	public List<DoctorScheduleDTO> getAllSchedules() {
		return service.getAllSchedules();
	}

	@PutMapping("/update/{doctorId}")
	public String updateSchedule(@PathVariable Long doctorId, @RequestBody DoctorScheduleDTO dto) {
		return service.updateSchedule(doctorId, dto);
	}

	@DeleteMapping("/delete/{doctorId}")
	public String deleteSchedule(@PathVariable Long doctorId) {
		return service.deleteSchedule(doctorId);
	}
}
