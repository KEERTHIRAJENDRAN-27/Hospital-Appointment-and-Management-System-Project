package com.cts.project.dto;

import java.time.LocalDateTime;

public class NotificationDTO {
	private Long patientId;
	private String message;
    private LocalDateTime timestamp;
    public NotificationDTO() {
		// TODO Auto-generated constructor stub
	}
	public NotificationDTO(Long patientId, String message, LocalDateTime timestamp) {
		super();
		this.patientId = patientId;
		this.message = message;
		this.timestamp = timestamp;
	}
	public Long getPatientId() {
		return patientId;
	}
	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
    

}
