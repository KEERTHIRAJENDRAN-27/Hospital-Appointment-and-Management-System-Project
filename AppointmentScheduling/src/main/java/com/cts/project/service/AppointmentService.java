package com.cts.project.service;

import com.cts.project.dto.AppointmentDTO;
import com.cts.project.model.Appointment;

public interface AppointmentService {
	public abstract String createAppointment(AppointmentDTO dto);

	public abstract String updateAppointment(Long id, AppointmentDTO dto);

	public abstract Appointment getAppointmentById(Long id);

	public abstract Iterable<Appointment> getAllAppointments();

	public abstract String deleteAppointment(Long id);
}