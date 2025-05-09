package com.cts.project.service;

import java.util.List;

import com.cts.project.dto.PatientProfileDTO;

public interface PatientProfileService {

	public abstract PatientProfileDTO registerPatient(PatientProfileDTO patientDTO);

	public abstract PatientProfileDTO getPatientById(Long id);

	public abstract List<PatientProfileDTO> getAllPatients();

	public abstract PatientProfileDTO updatePatient(Long id, PatientProfileDTO patientDTO);

	public abstract void deletePatient(Long id);
}
