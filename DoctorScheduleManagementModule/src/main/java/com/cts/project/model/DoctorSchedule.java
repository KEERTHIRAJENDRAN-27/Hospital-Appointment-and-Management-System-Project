package com.cts.project.model;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "DoctorSchedule_info")
public class DoctorSchedule {
	@Id
	private Long doctorId;

	@Column(name = "availableTimeSlots")
	private String availableTimeSlots; // Comma-separated string of timestamps

	public List<LocalDateTime> getTimeSlotsAsList() {
		return Arrays.stream(availableTimeSlots.split(",")).map(LocalDateTime::parse).collect(Collectors.toList());
	}

	public void setTimeSlotsFromList(List<LocalDateTime> timeSlots) {
		this.availableTimeSlots = timeSlots.stream().map(LocalDateTime::toString).collect(Collectors.joining(","));
	}

	public DoctorSchedule() {
		// TODO Auto-generated constructor stub
	}

	public DoctorSchedule(Long doctorId, String availableTimeSlots) {
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
