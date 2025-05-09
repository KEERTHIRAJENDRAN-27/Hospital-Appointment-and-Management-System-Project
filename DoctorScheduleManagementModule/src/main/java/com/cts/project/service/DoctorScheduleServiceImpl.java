package com.cts.project.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.project.dto.DoctorScheduleDTO;
import com.cts.project.model.DoctorSchedule;
import com.cts.project.repository.DoctorScheduleRepository;

@Service
public class DoctorScheduleServiceImpl implements DoctorScheduleService {

	@Autowired
	private DoctorScheduleRepository repository;

	@Override
	public String createSchedule(DoctorScheduleDTO dto) {
		DoctorSchedule schedule = new DoctorSchedule();
		schedule.setDoctorId(dto.getDoctorId());
		schedule.setTimeSlotsFromList(dto.getAvailableTimeSlots());
		repository.save(schedule);
		return "Schedule created successfully.";
	}

	@Override
	public DoctorScheduleDTO getScheduleById(Long doctorId) {
		DoctorSchedule schedule = repository.findById(doctorId).orElse(null);
		if (schedule == null)
			return null;

		DoctorScheduleDTO dto = new DoctorScheduleDTO();
		dto.setDoctorId(schedule.getDoctorId());
		dto.setAvailableTimeSlots(schedule.getTimeSlotsAsList());
		return dto;
	}

	@Override
	public List<DoctorScheduleDTO> getAllSchedules() {
		return repository.findAll().stream().map(schedule -> {
			DoctorScheduleDTO dto = new DoctorScheduleDTO();
			dto.setDoctorId(schedule.getDoctorId());
			dto.setAvailableTimeSlots(schedule.getTimeSlotsAsList());
			return dto;
		}).collect(Collectors.toList());
	}

	@Override
	public String updateSchedule(Long doctorId, DoctorScheduleDTO dto) {
		DoctorSchedule schedule = repository.findById(doctorId).orElse(null);
		if (schedule == null)
			return "Doctor schedule not found.";

		schedule.setTimeSlotsFromList(dto.getAvailableTimeSlots());
		repository.save(schedule);
		return "Schedule updated.";
	}

	@Override
	public String deleteSchedule(Long doctorId) {
		if (!repository.existsById(doctorId))
			return "Doctor schedule not found.";
		repository.deleteById(doctorId);
		return "Schedule deleted.";
	}
}
