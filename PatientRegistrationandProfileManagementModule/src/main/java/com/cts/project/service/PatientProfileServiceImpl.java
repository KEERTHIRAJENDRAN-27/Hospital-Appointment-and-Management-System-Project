package com.cts.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.project.dto.PatientProfileDTO;
import com.cts.project.exception.PatientNotFoundException;
import com.cts.project.model.PatientProfile;
import com.cts.project.repository.PatientProfileRepository;

@Service
public class PatientProfileServiceImpl implements PatientProfileService {
	@Autowired
	private PatientProfileRepository repository;

	@Override
	public String createPatient(PatientProfileDTO dto) {
		// TODO Auto-generated method stub
		PatientProfile patient = new PatientProfile();

		patient.setPatientName(dto.getPatientName());
		patient.setDateOfBirth(dto.getDateOfBirth());
		patient.setGender(dto.getGender());
		patient.setAge(dto.getAge());
		patient.setBloodGroup(dto.getBloodGroup());
		patient.setGuardianName(dto.getGuardianName());
		patient.setContactNumber(dto.getContactNumber());
		patient.setEmail(dto.getEmail());
		patient.setAddress(dto.getAddress());
		patient.setMedicalHistory(dto.getMedicalHistory());

		repository.save(patient);
		return "Patient registered successfully.";
	}

	@Override
	public String updatePatient(Long id, PatientProfileDTO dto) {
		// TODO Auto-generated method stub
		Optional<PatientProfile> optionalPatient = repository.findById(id);
		if (!optionalPatient.isPresent()) {
			throw new PatientNotFoundException("Patient not found with ID: " + id);
		}

		PatientProfile patient = optionalPatient.get();

		patient.setPatientName(dto.getPatientName());
		patient.setDateOfBirth(dto.getDateOfBirth());
		patient.setGender(dto.getGender());
		patient.setAge(dto.getAge());
		patient.setBloodGroup(dto.getBloodGroup());
		patient.setGuardianName(dto.getGuardianName());
		patient.setContactNumber(dto.getContactNumber());
		patient.setEmail(dto.getEmail());
		patient.setAddress(dto.getAddress());
		patient.setMedicalHistory(dto.getMedicalHistory());

		repository.save(patient);
		return "Patient profile updated successfully.";
	}

	@Override
	public PatientProfile getPatientById(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id)
				.orElseThrow(() -> new PatientNotFoundException("Patient not found with ID: " + id));
	}

	@Override
	public List<PatientProfile> getAllPatients() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public String deletePatient(Long id) {
		// TODO Auto-generated method stub
		if (!repository.existsById(id)) {
			throw new PatientNotFoundException("Patient not found with ID: " + id);
		}
		repository.deleteById(id);
		return "Patient deleted successfully.";
	}
}
