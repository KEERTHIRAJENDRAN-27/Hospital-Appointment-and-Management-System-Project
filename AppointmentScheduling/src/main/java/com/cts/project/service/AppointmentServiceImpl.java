package com.cts.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.project.dto.AppointmentDTO;
import com.cts.project.dto.DoctorScheduleDTO;
import com.cts.project.dto.PatientProfile;
import com.cts.project.feignclient.DoctorScheduleClient;
import com.cts.project.feignclient.PatientClient;
import com.cts.project.model.Appointment;
import com.cts.project.repository.AppointmentRepository;

@Service
public class AppointmentServiceImpl implements AppointmentService {

	@Autowired
	private AppointmentRepository appointmentRepository;

	@Autowired
	private PatientClient patientClient; // Patient Module Communication

	@Autowired
	private DoctorScheduleClient doctorScheduleClient; // Doctor Schedule Module Communication

//	@Autowired
//	private NotificationClient notificationClient; // Notification Module Communication

//	@Autowired
//	private MedicalHistoryClient medicalHistoryClient; // Medical History Module Communication

	@Override
	public String createAppointment(AppointmentDTO dto) {
		// Validate PatientID by calling Patient Module
		try {
			PatientProfile patient = patientClient.getPatientById(dto.getPatientId());
			if (patient == null) {
				return "Invalid PatientID. Patient not found.";
			}
		} catch (Exception e) {
			return "Error validating PatientID: " + e.getMessage();
		}

		// Validate DoctorID and appointment time using DoctorSchedule Module
		try {
			DoctorScheduleDTO schedule = doctorScheduleClient.getScheduleById(dto.getDoctorId());
			if (schedule == null || !schedule.getAvailableTimeSlots().contains(dto.getAppointmentDate().toString())) {
				return "Invalid DoctorID or time slot not available.";
			}
		} catch (Exception e) {
			return "Error validating DoctorID: " + e.getMessage();
		}

		// Proceed to save appointment
		Appointment appointment = new Appointment();
		appointment.setPatientId(dto.getPatientId());
		appointment.setDoctorId(dto.getDoctorId());
		appointment.setAppointmentDate(dto.getAppointmentDate());
		appointment.setStatus(dto.getStatus());

		appointmentRepository.save(appointment);
		return "Appointment booked successfully.";

	}

	@Override
	public String updateAppointment(Long id, AppointmentDTO dto) {
		// Fetch Appointment to Update
		Appointment appointment = appointmentRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Appointment not found"));
		appointment.setAppointmentDate(dto.getAppointmentDate());
		appointment.setStatus(dto.getStatus());
		appointmentRepository.save(appointment);

		// If appointment status is 'Completed', send data to Medical History Module
		if ("Completed".equals(dto.getStatus())) {
			// TODO: Un-comment once Medical History module is ready
			// medicalHistoryClient.createMedicalHistory(new
			// MedicalHistoryDTO(dto.getPatientId(), "Completed", "Treatment",
			// dto.getAppointmentDate()));
		}

		return "Appointment updated successfully";
	}

	@Override
	public Appointment getAppointmentById(Long id) {
		return appointmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Appointment not found"));
	}

	@Override
	public Iterable<Appointment> getAllAppointments() {
		return appointmentRepository.findAll();
	}

	@Override
	public String deleteAppointment(Long id) {
		appointmentRepository.deleteById(id);
		return "Appointment deleted successfully";
	}
}
