package com.cts.project.service;

import java.util.List;

import com.cts.project.dto.DoctorScheduleDTO;

public interface DoctorScheduleService {

	public abstract String createSchedule(DoctorScheduleDTO dto);

	public abstract DoctorScheduleDTO getScheduleById(Long doctorId);

	public abstract List<DoctorScheduleDTO> getAllSchedules();

	public abstract String updateSchedule(Long doctorId, DoctorScheduleDTO dto);

	public abstract String deleteSchedule(Long doctorId);
}