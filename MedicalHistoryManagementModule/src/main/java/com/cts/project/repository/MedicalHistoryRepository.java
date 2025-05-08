package com.cts.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.project.model.MedicalHistory;

public interface MedicalHistoryRepository extends JpaRepository<MedicalHistory, Long> {

}
