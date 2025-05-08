package com.cts.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.project.model.DoctorSchedule;

public interface DoctorScheduleRepository extends JpaRepository<DoctorSchedule, Long> {
}
