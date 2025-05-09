package com.cts.project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "patient_info")
public class PatientProfile {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long patientId;

	private String name;
	private String dateOfBirth;
	private String contactDetails;
	private String medicalHistory;

	public PatientProfile() {
		// TODO Auto-generated constructor stub
	}

	public PatientProfile(Long patientId, String name, String dateOfBirth, String contactDetails,
			String medicalHistory) {
		super();
		this.patientId = patientId;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.contactDetails = contactDetails;
		this.medicalHistory = medicalHistory;
	}

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getContactDetails() {
		return contactDetails;
	}

	public void setContactDetails(String contactDetails) {
		this.contactDetails = contactDetails;
	}

	public String getMedicalHistory() {
		return medicalHistory;
	}

	public void setMedicalHistory(String medicalHistory) {
		this.medicalHistory = medicalHistory;
	}

}
