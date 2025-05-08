package com.cts.project.dto;

import java.time.LocalDateTime;

public class AppointmentPatientRequestDTO {
	private Long patientId;
	private Long doctorId;
	private LocalDateTime appointmentDate;

	public AppointmentPatientRequestDTO() {
		// TODO Auto-generated constructor stub
	}

	public AppointmentPatientRequestDTO(Long patientId, Long doctorId, LocalDateTime appointmentDate) {
		super();
		this.patientId = patientId;
		this.doctorId = doctorId;
		this.appointmentDate = appointmentDate;
	}

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public Long getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}

	public LocalDateTime getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(LocalDateTime appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

}
