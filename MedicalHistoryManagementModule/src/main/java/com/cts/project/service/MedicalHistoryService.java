package com.cts.project.service;

import java.util.List;

import com.cts.project.dto.MedicalHistoryDTO;
import com.cts.project.model.MedicalHistory;

public interface MedicalHistoryService {

	public abstract String createMedicalHistory(MedicalHistoryDTO dto);

	public abstract List<MedicalHistory> getAllHistories();

	public abstract MedicalHistory getHistoryById(Long id);

	public abstract String updateMedicalHistory(Long id, MedicalHistoryDTO dto);

	public abstract String deleteMedicalHistory(Long id);
}
