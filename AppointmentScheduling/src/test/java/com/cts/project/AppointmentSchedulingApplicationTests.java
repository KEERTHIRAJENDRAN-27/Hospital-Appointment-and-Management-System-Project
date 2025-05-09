package com.cts.project;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.cts.project.dto.AppointmentDTO;
import com.cts.project.dto.PatientProfile;
import com.cts.project.feignclient.PatientClient;
import com.cts.project.model.Appointment;
import com.cts.project.repository.AppointmentRepository;
import com.cts.project.service.AppointmentServiceImpl;

@SpringBootTest
class AppointmentSchedulingApplicationTests {

	@Test
	void contextLoads() {
		// ensures Spring context loads
	}

	@Mock
	private AppointmentRepository repository;

	@Mock
	private PatientClient patientClient;

	@InjectMocks
	private AppointmentServiceImpl service;

	private AppointmentDTO dto;
	private Appointment appointment;
	private PatientProfile mockPatient;

	@BeforeEach
	void setup() {
		MockitoAnnotations.openMocks(this);

		dto = new AppointmentDTO();
		dto.setPatientId(1L);
		dto.setDoctorId(101L);
		dto.setAppointmentDate(LocalDateTime.of(2025, 5, 10, 10, 30));
		dto.setStatus("Scheduled");

		appointment = new Appointment(1L, 1L, 101L, dto.getAppointmentDate(), "Scheduled");

		mockPatient = new PatientProfile();
		mockPatient.setPatientId(1L);
		mockPatient.setName("John Doe");
	}

	@Test
	void testCreateAppointment_ValidPatient() {
		when(patientClient.getPatientById(1L)).thenReturn(mockPatient);
		when(repository.save(any())).thenReturn(appointment);

		String result = service.createAppointment(dto);
		assertEquals("Appointment booked successfully", result);
	}

	@Test
	void testCreateAppointment_InvalidPatient() {
		when(patientClient.getPatientById(1L)).thenReturn(null);

		String result = service.createAppointment(dto);
		assertEquals("Invalid PatientID. Please check.", result);
	}

	@Test
	void testGetAppointmentById() {
		when(repository.findById(1L)).thenReturn(Optional.of(appointment));
		Appointment result = service.getAppointmentById(1L);
		assertEquals(1L, result.getPatientId());
	}

	@Test
	void testUpdateAppointment() {
		when(repository.findById(1L)).thenReturn(Optional.of(appointment));
		when(repository.save(any())).thenReturn(appointment);

		String result = service.updateAppointment(1L, dto);
		assertEquals("Appointment updated successfully", result);
	}

	@Test
	void testDeleteAppointment() {
		when(repository.existsById(1L)).thenReturn(true);
		String result = service.deleteAppointment(1L);
		assertEquals("Appointment deleted successfully", result);
	}

	@Test
	void testGetAllAppointments() {
		when(repository.findAll()).thenReturn(Arrays.asList(appointment));
		Iterable<Appointment> result = service.getAllAppointments();
		assertEquals(1, ((List<Appointment>) result).size());
	}

}
