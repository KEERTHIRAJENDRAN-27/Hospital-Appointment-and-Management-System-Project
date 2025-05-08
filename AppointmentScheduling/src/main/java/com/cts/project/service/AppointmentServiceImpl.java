package com.cts.project.service;

import java.util.ArrayList;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.project.dto.AppointmentPatientRequestDTO;
import com.cts.project.dto.AppointmentPatientResponseDTO;
import com.cts.project.exception.AppointmentNotFoundException;
import com.cts.project.model.Appointment;
import com.cts.project.repository.AppointmentRepository;

@Service
public class AppointmentServiceImpl implements AppointmentService {

	@Autowired
	private AppointmentRepository repo;

	@Override
	public AppointmentPatientResponseDTO create(AppointmentPatientRequestDTO dto) {
		Appointment app = new Appointment();
		app.setPatientId(dto.getPatientId());
		app.setDoctorId(dto.getDoctorId());
		app.setAppointmentDate(dto.getAppointmentDate());
		app.setStatus("Scheduled");
		repo.save(app);

		return toResponse(app);
	}

	@Override
	public AppointmentPatientResponseDTO update(Long id, AppointmentPatientRequestDTO dto) {
		Appointment app = repo.findById(id)
				.orElseThrow(() -> new AppointmentNotFoundException("Appointment not found"));

		app.setDoctorId(dto.getDoctorId());
		app.setAppointmentDate(dto.getAppointmentDate());
		app.setStatus("Rescheduled");
		repo.save(app);

		return toResponse(app);
	}

	@Override
	public AppointmentPatientResponseDTO getById(Long id) {
		Appointment app = repo.findById(id)
				.orElseThrow(() -> new AppointmentNotFoundException("Appointment not found"));
		return toResponse(app);
	}

	@Override
	public List<AppointmentPatientResponseDTO> getAll() {
		List<Appointment> appointments = repo.findAll();
		List<AppointmentPatientResponseDTO> responseList = new ArrayList<>();
		for (Appointment app : appointments) {
			responseList.add(toResponse(app));
		}
		return responseList;

	}

	@Override
	public String delete(Long id) {
		Appointment app = repo.findById(id)
				.orElseThrow(() -> new AppointmentNotFoundException("Appointment not found"));
		repo.delete(app);
		return "Appointment deleted";
	}

	private AppointmentPatientResponseDTO toResponse(Appointment app) {
		AppointmentPatientResponseDTO dto = new AppointmentPatientResponseDTO();
		dto.setAppointmentId(app.getAppointmentId());
		dto.setPatientId(app.getPatientId());
		dto.setDoctorId(app.getDoctorId());
		dto.setAppointmentDate(app.getAppointmentDate());
		dto.setStatus(app.getStatus());
		return dto;
	}
}
