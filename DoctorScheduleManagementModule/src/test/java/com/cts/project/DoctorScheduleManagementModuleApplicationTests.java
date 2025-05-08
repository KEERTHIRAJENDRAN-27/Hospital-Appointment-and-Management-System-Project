package com.cts.project;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.cts.project.dto.DoctorScheduleDTO;
import com.cts.project.exception.DoctorScheduleNotFoundException;
import com.cts.project.model.DoctorSchedule;
import com.cts.project.repository.DoctorScheduleRepository;
import com.cts.project.service.DoctorScheduleServiceImpl;

@SpringBootTest
class DoctorScheduleManagementModuleApplicationTests {

//	@Test
//	void contextLoads() {
//	}
	@InjectMocks
	private DoctorScheduleServiceImpl service;

	@Mock
	private DoctorScheduleRepository repository;

	private DoctorSchedule sampleSchedule;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
		sampleSchedule = new DoctorSchedule();
		sampleSchedule.setDoctorId(101L);
		sampleSchedule.setAvailableTimeSlots("2025-05-12T09:00,2025-05-12T11:00");
	}

	@Test
	void testCreateSchedule() {
		DoctorScheduleDTO dto = new DoctorScheduleDTO(null, null);
		dto.setDoctorId(101L);
		dto.setAvailableTimeSlots("2025-05-12T09:00,2025-05-12T11:00");

		when(repository.save(any(DoctorSchedule.class))).thenReturn(sampleSchedule);
		String result = service.createSchedule(dto);

		assertEquals("Doctor schedule created successfully.", result);
		verify(repository, times(1)).save(any(DoctorSchedule.class));
	}

	@Test
	void testGetScheduleById_Success() {
		when(repository.findById(101L)).thenReturn(Optional.of(sampleSchedule));
		DoctorSchedule result = service.getScheduleById(101L);

		assertEquals(101L, result.getDoctorId());
	}

	@Test
	void testGetScheduleById_NotFound() {
		when(repository.findById(101L)).thenReturn(Optional.empty());
		assertThrows(DoctorScheduleNotFoundException.class, () -> service.getScheduleById(101L));
	}

	@Test
	void testGetAllSchedules() {
		when(repository.findAll()).thenReturn(Arrays.asList(sampleSchedule));
		List<DoctorSchedule> result = service.getAllSchedules();

		assertEquals(1, result.size());
	}

	@Test
	void testUpdateSchedule_Success() {
		DoctorScheduleDTO dto = new DoctorScheduleDTO(null, null);
		dto.setAvailableTimeSlots("2025-05-12T10:00");

		when(repository.findById(101L)).thenReturn(Optional.of(sampleSchedule));
		String result = service.updateSchedule(101L, dto);

		assertEquals("Doctor schedule updated successfully.", result);
		verify(repository, times(1)).save(sampleSchedule);
	}

	@Test
	void testDeleteSchedule_Success() {
		when(repository.findById(101L)).thenReturn(Optional.of(sampleSchedule));
		String result = service.deleteSchedule(101L);

		assertEquals("Doctor schedule deleted successfully.", result);
		verify(repository, times(1)).delete(sampleSchedule);
	}
}
