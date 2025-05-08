package com.cts.project.service;

import java.util.List;

//import java.util.Optional;

import com.cts.project.dto.PatientProfileDTO;
import com.cts.project.model.PatientProfile;

public interface PatientProfileService {
	
	public abstract String createPatient(PatientProfileDTO dto);
	public abstract String updatePatient(Long id, PatientProfileDTO dto);
	public abstract PatientProfile getPatientById(Long id);
	public abstract List<PatientProfile> getAllPatients();
    public abstract String deletePatient(Long id);
}
