package com.cts.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.project.dto.DoctorScheduleDTO;
import com.cts.project.exception.DoctorScheduleNotFoundException;
import com.cts.project.model.DoctorSchedule;
import com.cts.project.repository.DoctorScheduleRepository;

@Service
public class DoctorScheduleServiceImpl implements DoctorScheduleService {

	@Autowired
	private DoctorScheduleRepository repository;

	@Override
	public String createSchedule(DoctorScheduleDTO dto) {
		// TODO Auto-generated method stub
		DoctorSchedule schedule = new DoctorSchedule();
		schedule.setDoctorId(dto.getDoctorId());
		schedule.setAvailableTimeSlots(dto.getAvailableTimeSlots());
		repository.save(schedule);
		return "Doctor schedule created successfully.";
	}

	@Override
	public DoctorSchedule getScheduleById(Long doctorId) {
		// TODO Auto-generated method stub
		return repository.findById(doctorId).orElseThrow(
				() -> new DoctorScheduleNotFoundException("Doctor schedule not found with ID: " + doctorId));
	}

	@Override
	public List<DoctorSchedule> getAllSchedules() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public String updateSchedule(Long doctorId, DoctorScheduleDTO dto) {
		// TODO Auto-generated method stub
		DoctorSchedule schedule = repository.findById(doctorId).orElseThrow(
				() -> new DoctorScheduleNotFoundException("Doctor schedule not found with ID: " + doctorId));
		schedule.setAvailableTimeSlots(dto.getAvailableTimeSlots());
		repository.save(schedule);
		return "Doctor schedule updated successfully.";
	}

	@Override
	public String deleteSchedule(Long doctorId) {
		// TODO Auto-generated method stub
		DoctorSchedule schedule = repository.findById(doctorId).orElseThrow(
				() -> new DoctorScheduleNotFoundException("Doctor schedule not found with ID: " + doctorId));
		repository.delete(schedule);
		return "Doctor schedule deleted successfully.";
	}
}
