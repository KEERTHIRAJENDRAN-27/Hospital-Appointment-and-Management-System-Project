package com.cts.project;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.cts.project.dto.MedicalHistoryDTO;
import com.cts.project.exception.MedicalHistoryNotFoundException;
import com.cts.project.model.MedicalHistory;
import com.cts.project.repository.MedicalHistoryRepository;
import com.cts.project.service.MedicalHistoryServiceImpl;

@SpringBootTest
class MedicalHistoryManagementModuleApplicationTests {

//	@Test
//	void contextLoads() {
//	}
	@InjectMocks
	private MedicalHistoryServiceImpl service;

	@Mock
	private MedicalHistoryRepository repository;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testCreateMedicalHistory() {
		MedicalHistoryDTO dto = new MedicalHistoryDTO(null, null, null, null);
		dto.setPatientId(1L);
		dto.setDiagnosis("Flu");
		dto.setTreatment("Medication");
//		dto.setDateOfVisit("2024-12-01");
		dto.setDateOfVisit(LocalDate.parse("2024-12-01"));

		String result = service.createMedicalHistory(dto);
		assertEquals("Medical history record created successfully.", result);
		verify(repository, times(1)).save(any(MedicalHistory.class));
	}

	@Test
	void testGetAllHistories() {
		MedicalHistory history1 = new MedicalHistory();
		history1.setDiagnosis("Fever");
		MedicalHistory history2 = new MedicalHistory();
		history2.setDiagnosis("Cold");

		when(repository.findAll()).thenReturn(Arrays.asList(history1, history2));
		List<MedicalHistory> result = service.getAllHistories();

		assertEquals(2, result.size());
	}

	@Test
	void testGetHistoryById_Success() {
		MedicalHistory history = new MedicalHistory();
		history.setHistoryId(1L);
		history.setDiagnosis("Diabetes");

		when(repository.findById(1L)).thenReturn(Optional.of(history));
		MedicalHistory result = service.getHistoryById(1L);

		assertEquals("Diabetes", result.getDiagnosis());
	}

	@Test
	void testGetHistoryById_NotFound() {
		when(repository.findById(1L)).thenReturn(Optional.empty());

		assertThrows(MedicalHistoryNotFoundException.class, () -> {
			service.getHistoryById(1L);
		});
	}

	@Test
	void testUpdateMedicalHistory() {
		MedicalHistory existing = new MedicalHistory();
		existing.setHistoryId(1L);
		existing.setDiagnosis("Old");

		MedicalHistoryDTO updated = new MedicalHistoryDTO(null, null, null, null);
		updated.setDiagnosis("New Diagnosis");
		updated.setTreatment("New Treatment");
//		updated.setDateOfVisit("2025-01-01");
		updated.setDateOfVisit(LocalDate.parse("2024-12-01"));

		when(repository.findById(1L)).thenReturn(Optional.of(existing));
		String result = service.updateMedicalHistory(1L, updated);

		assertEquals("Medical history record updated successfully.", result);
		verify(repository).save(existing);
	}

	@Test
	void testDeleteMedicalHistory() {
		MedicalHistory history = new MedicalHistory();
		history.setHistoryId(1L);

		when(repository.findById(1L)).thenReturn(Optional.of(history));
		String result = service.deleteMedicalHistory(1L);

		assertEquals("Medical history record deleted successfully.", result);
		verify(repository).delete(history);
	}
}
