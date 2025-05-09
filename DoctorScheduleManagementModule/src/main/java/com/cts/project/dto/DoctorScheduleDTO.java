package com.cts.project.dto;

import java.time.LocalDateTime;
import java.util.List;

public class DoctorScheduleDTO {
	private Long doctorId;
	private List<LocalDateTime> availableTimeSlots;

	public DoctorScheduleDTO() {
		// TODO Auto-generated constructor stub
	}

	public DoctorScheduleDTO(Long doctorId, List<LocalDateTime> availableTimeSlots) {
		super();
		this.doctorId = doctorId;
		this.availableTimeSlots = availableTimeSlots;
	}

	public Long getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}

	public List<LocalDateTime> getAvailableTimeSlots() {
		return availableTimeSlots;
	}

	public void setAvailableTimeSlots(List<LocalDateTime> availableTimeSlots) {
		this.availableTimeSlots = availableTimeSlots;
	}
}
