package com.cts.project.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(NotificationNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ResponseBody
	public Map<String, Object> handleNotFound(NotificationNotFoundException ex) {
		Map<String, Object> map = new HashMap<>();
		map.put("timestamp", LocalDateTime.now());
		map.put("status", HttpStatus.NOT_FOUND.value());
		map.put("error", "Not Found");
		map.put("message", ex.getMessage());
		return map;
	}
}
