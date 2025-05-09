package com.cts.project.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "appointment-service", url = "http://localhost:8002") // update URL as needed
public interface AppointmentClient {
 
    @GetMapping("/appointments/patient/{patientId}")
    String getAppointmentsByPatient(@PathVariable("patientId") Long patientId);  // placeholder
}