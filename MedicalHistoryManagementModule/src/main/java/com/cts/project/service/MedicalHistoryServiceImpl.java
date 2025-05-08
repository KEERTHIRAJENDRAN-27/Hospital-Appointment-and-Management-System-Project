package com.cts.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.project.dto.MedicalHistoryDTO;
import com.cts.project.exception.MedicalHistoryNotFoundException;
import com.cts.project.model.MedicalHistory;
import com.cts.project.repository.MedicalHistoryRepository;

@Service
public class MedicalHistoryServiceImpl implements MedicalHistoryService {
	@Autowired
	private MedicalHistoryRepository repository;

	@Override
    public String createMedicalHistory(MedicalHistoryDTO dto) {
        MedicalHistory history = new MedicalHistory();
        history.setPatientId(dto.getPatientId());
        history.setDiagnosis(dto.getDiagnosis());
        history.setTreatment(dto.getTreatment());
        history.setDateOfVisit(dto.getDateOfVisit());
        repository.save(history);
        return "Medical history record created successfully.";
    }
 
    @Override
    public List<MedicalHistory> getAllHistories() {
        return repository.findAll();
    }
 
    @Override
    public MedicalHistory getHistoryById(Long id) {
        return repository.findById(id).orElseThrow(() ->
                new MedicalHistoryNotFoundException("Medical history not found for ID: " + id));
    }
 
    @Override
    public String updateMedicalHistory(Long id, MedicalHistoryDTO dto) {
        MedicalHistory history = getHistoryById(id);
        history.setDiagnosis(dto.getDiagnosis());
        history.setTreatment(dto.getTreatment());
        history.setDateOfVisit(dto.getDateOfVisit());
        repository.save(history);
        return "Medical history record updated successfully.";
    }
 
    @Override
    public String deleteMedicalHistory(Long id) {
        MedicalHistory history = getHistoryById(id);
        repository.delete(history);
        return "Medical history record deleted successfully.";
    }

}
