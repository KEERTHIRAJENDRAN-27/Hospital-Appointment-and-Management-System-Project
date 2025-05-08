package com.cts.project.service;

import java.util.List;

import com.cts.project.dto.DoctorScheduleDTO;
import com.cts.project.model.DoctorSchedule;

public interface DoctorScheduleService {

	public abstract String createSchedule(DoctorScheduleDTO dto);

	public abstract DoctorSchedule getScheduleById(Long doctorId);

	public abstract List<DoctorSchedule> getAllSchedules();

	public abstract String updateSchedule(Long doctorId, DoctorScheduleDTO dto);

	public abstract String deleteSchedule(Long doctorId);

}