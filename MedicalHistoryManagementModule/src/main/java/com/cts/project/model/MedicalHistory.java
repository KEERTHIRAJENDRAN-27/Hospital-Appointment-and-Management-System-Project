package com.cts.project.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "MedicalHistory_info")
public class MedicalHistory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long historyId;

	private Long patientId;
	private String diagnosis;
	private String treatment;
	private LocalDate dateOfVisit;

	public MedicalHistory() {
		// TODO Auto-generated constructor stub
	}

	public MedicalHistory(Long historyId, Long patientId, String diagnosis, String treatment, LocalDate dateOfVisit) {
		super();
		this.historyId = historyId;
		this.patientId = patientId;
		this.diagnosis = diagnosis;
		this.treatment = treatment;
		this.dateOfVisit = dateOfVisit;
	}

	public Long getHistoryId() {
		return historyId;
	}

	public void setHistoryId(Long historyId) {
		this.historyId = historyId;
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
