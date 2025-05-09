package com.cts.project.dto;

import java.util.List;

public class DoctorScheduleDTO {
	private Long doctorId;
	private List<String> availableTimeSlots;

	public DoctorScheduleDTO() {
		// TODO Auto-generated constructor stub
	}

	public DoctorScheduleDTO(Long doctorId, List<String> availableTimeSlots) {
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

	public List<String> getAvailableTimeSlots() {
		return availableTimeSlots;
	}

	public void setAvailableTimeSlots(List<String> availableTimeSlots) {
		this.availableTimeSlots = availableTimeSlots;
	}

}
