package com.cts.project.exception;

import java.time.LocalDateTime;

public class ExceptionResponse {
	private LocalDateTime timestamp;
    private String message;
    private int status;
 
    public ExceptionResponse(LocalDateTime timestamp, String message, int status) {
        this.timestamp = timestamp;
        this.message = message;
        this.status = status;
    }
 
    // Getters and Setters
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
 
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
 
    public String getMessage() {
        return message;
    }
 
    public void setMessage(String message) {
        this.message = message;
    }
 
    public int getStatus() {
        return status;
    }
 
    public void setStatus(int status) {
        this.status = status;
    }
}
