package com.cts.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.project.model.PatientProfile;

public interface PatientProfileRepository extends JpaRepository<PatientProfile, Long> {

}
