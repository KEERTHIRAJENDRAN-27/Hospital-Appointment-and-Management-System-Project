package com.cts.project.dto;

import java.time.LocalDate;

public class MedicalHistoryDTO {
	private Long patientId;
	private String diagnosis;
	private String treatment;
	private LocalDate dateOfVisit;

	public MedicalHistoryDTO(Long patientId, String diagnosis, String treatment, LocalDate dateOfVisit) {
		super();
		this.patientId = patientId;
		this.diagnosis = diagnosis;
		this.treatment = treatment;
		this.dateOfVisit = dateOfVisit;
	}

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public String getTreatment() {
		return treatment;
	}

	public void setTreatment(String treatment) {
		this.treatment = treatment;
	}

	public LocalDate getDateOfVisit() {
		return dateOfVisit;
	}

	public void setDateOfVisit(LocalDate dateOfVisit) {
		this.dateOfVisit = dateOfVisit;
	}

}
