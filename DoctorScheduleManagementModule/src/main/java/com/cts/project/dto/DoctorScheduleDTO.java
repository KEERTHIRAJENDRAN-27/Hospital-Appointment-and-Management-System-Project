package com.cts.project.dto;

public class DoctorScheduleDTO {
	private Long doctorId;
	private String availableTimeSlots;
	public DoctorScheduleDTO(Long doctorId, String availableTimeSlots) {
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
	public String getAvailableTimeSlots() {
		return availableTimeSlots;
	}
	public void setAvailableTimeSlots(String availableTimeSlots) {
		this.availableTimeSlots = availableTimeSlots;
	}
	
}
