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

import com.cts.project.dto.MedicalHistoryDTO;
import com.cts.project.model.MedicalHistory;
import com.cts.project.service.MedicalHistoryService;

@RestController
@RequestMapping("/medicalHistory")
public class MedicalHistoryController {
	@Autowired
	private MedicalHistoryService service;

	@PostMapping("/save")
	public String createHistory(@RequestBody MedicalHistoryDTO dto) {
		return service.createMedicalHistory(dto);
	}

	@PutMapping("/update/{id}")
	public String updateHistory(@PathVariable Long id, @RequestBody MedicalHistoryDTO dto) {
		return service.updateMedicalHistory(id, dto);
	}

	@GetMapping("/getHistoryById/{id}")
	public MedicalHistory getHistoryById(@PathVariable Long id) {
		return service.getHistoryById(id);
	}

	@GetMapping("/getAllHistories")
	public List<MedicalHistory> getAllHistories() {
		return service.getAllHistories();
	}

	@DeleteMapping("/delete/{id}")
	public String deleteHistory(@PathVariable Long id) {
		return service.deleteMedicalHistory(id);
	}
}
