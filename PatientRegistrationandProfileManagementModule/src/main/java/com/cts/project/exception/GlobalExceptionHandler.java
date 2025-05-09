package com.cts.project.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(PatientNotFoundException.class)
	public ResponseEntity<String> handleNotFound(PatientNotFoundException ex) {
		return ResponseEntity.status(404).body(ex.getMessage());
	}
}
