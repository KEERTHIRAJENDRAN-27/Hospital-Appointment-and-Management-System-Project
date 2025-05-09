package com.cts.project.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cts.project.dto.DoctorScheduleDTO;

@FeignClient(name = "DOCTORSCHEDULEMANAGEMENTMODULE", url = "http://localhost:8003/doctor")

public interface DoctorScheduleClient {
	@GetMapping("/fetchByid/{doctorId}")
	public DoctorScheduleDTO getScheduleById(@PathVariable Long doctorId);
}
