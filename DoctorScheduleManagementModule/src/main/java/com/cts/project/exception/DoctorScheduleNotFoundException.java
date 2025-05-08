package com.cts.project.exception;

public class DoctorScheduleNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public DoctorScheduleNotFoundException(String message) {
		super(message);
	}
}
