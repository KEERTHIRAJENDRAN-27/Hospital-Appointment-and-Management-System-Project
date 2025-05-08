package com.cts.project.service;

import java.util.List;

import com.cts.project.dto.AppointmentPatientRequestDTO;
import com.cts.project.dto.AppointmentPatientResponseDTO;

public interface AppointmentService {
	public abstract AppointmentPatientResponseDTO create(AppointmentPatientRequestDTO dto);

	public abstract AppointmentPatientResponseDTO update(Long id, AppointmentPatientRequestDTO dto);

	public abstract AppointmentPatientResponseDTO getById(Long id);

	public abstract List<AppointmentPatientResponseDTO> getAll();

	public abstract String delete(Long id);
}
