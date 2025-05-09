package com.cts.project.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.project.dto.PatientProfileDTO;
import com.cts.project.exception.PatientNotFoundException;
import com.cts.project.model.PatientProfile;
import com.cts.project.repository.PatientProfileRepository;

@Service
public class PatientProfileServiceImpl implements PatientProfileService {
	@Autowired
	private PatientProfileRepository patientRepository;

	@Override
	public PatientProfileDTO registerPatient(PatientProfileDTO dto) {
		PatientProfile patient = new PatientProfile();
		patient.setName(dto.getName());
		patient.setDateOfBirth(dto.getDateOfBirth());
		patient.setContactDetails(dto.getContactDetails());
		patient.setMedicalHistory(dto.getMedicalHistory());
		PatientProfile saved = patientRepository.save(patient);
		dto.setPatientId(saved.getPatientId());
		return dto;
	}

	@Override
	public PatientProfileDTO getPatientById(Long id) {
		PatientProfile patient = patientRepository.findById(id)
				.orElseThrow(() -> new PatientNotFoundException("Patient not found with ID: " + id));
		PatientProfileDTO dto = new PatientProfileDTO();
		dto.setPatientId(patient.getPatientId());
		dto.setName(patient.getName());
		dto.setDateOfBirth(patient.getDateOfBirth());
		dto.setContactDetails(patient.getContactDetails());
		dto.setMedicalHistory(patient.getMedicalHistory());
		return dto;
	}

	@Override
	public List<PatientProfileDTO> getAllPatients() {
		List<PatientProfile> patients = patientRepository.findAll();
		List<PatientProfileDTO> dtoList = new ArrayList<>();
		for (PatientProfile patient : patients) {
			PatientProfileDTO dto = new PatientProfileDTO();
			dto.setPatientId(patient.getPatientId());
			dto.setName(patient.getName());
			dto.setDateOfBirth(patient.getDateOfBirth());
			dto.setContactDetails(patient.getContactDetails());
			dto.setMedicalHistory(patient.getMedicalHistory());
			dtoList.add(dto);
		}
		return dtoList;
	}

	@Override
	public PatientProfileDTO updatePatient(Long id, PatientProfileDTO dto) {
		PatientProfile patient = patientRepository.findById(id)
				.orElseThrow(() -> new PatientNotFoundException("Patient not found with ID: " + id));
		patient.setName(dto.getName());
		patient.setDateOfBirth(dto.getDateOfBirth());
		patient.setContactDetails(dto.getContactDetails());
		patient.setMedicalHistory(dto.getMedicalHistory());
		PatientProfile updated = patientRepository.save(patient);
		dto.setPatientId(updated.getPatientId());
		return dto;
	}

	@Override
	public void deletePatient(Long id) {
		PatientProfile patient = patientRepository.findById(id)
				.orElseThrow(() -> new PatientNotFoundException("Patient not found with ID: " + id));
		patientRepository.delete(patient);
	}

}
