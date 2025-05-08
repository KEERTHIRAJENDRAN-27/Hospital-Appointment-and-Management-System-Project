package com.cts.project.exception;

public class MedicalHistoryNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public MedicalHistoryNotFoundException(String message) {
		super(message);
	}
}