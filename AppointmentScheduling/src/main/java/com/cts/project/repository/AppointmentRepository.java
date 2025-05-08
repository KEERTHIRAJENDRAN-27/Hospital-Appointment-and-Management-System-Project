package com.cts.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.project.model.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long>{

}
