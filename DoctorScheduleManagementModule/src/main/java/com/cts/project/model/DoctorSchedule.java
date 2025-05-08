package com.cts.project.model;

import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "DoctorSchedule_info")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoctorSchedule {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long scheduleId;
	private Long doctorId;
	private String availableTimeSlots; // e.g., "09:00-11:00,14:00-16:00"

	public DoctorSchedule() {
		// TODO Auto-generated constructor stub
	}

	public DoctorSchedule(Long scheduleId, Long doctorId, String availableTimeSlots) {
		super();
		this.scheduleId = scheduleId;
		this.doctorId = doctorId;
		this.availableTimeSlots = availableTimeSlots;
	}

	public Long getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(Long scheduleId) {
		this.scheduleId = scheduleId;
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
