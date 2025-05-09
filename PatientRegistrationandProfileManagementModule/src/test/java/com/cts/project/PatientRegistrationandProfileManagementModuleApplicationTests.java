package com.cts.project;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.cts.project.model.PatientProfile;
import com.cts.project.repository.PatientProfileRepository;

@SpringBootTest
class PatientRegistrationandProfileManagementModuleApplicationTests {
	@Test
	void contextLoads() {
		// Confirms Spring Boot application context loads correctly
	}

	@Mock
	private PatientProfileRepository patientRepository;

	@InjectMocks
	private DummyService dummyService;

	public void PatientServiceApplicationTests() {
		MockitoAnnotations.openMocks(this); // initialize mocks
	}

	@Test
	void testFindPatientById() {
		PatientProfile mockPatient = new PatientProfile();
		mockPatient.setPatientId(1L);
		mockPatient.setName("Alice");

		when(patientRepository.findById(1L)).thenReturn(Optional.of(mockPatient));

		PatientProfile result = dummyService.getById(1L);
		assertEquals("Alice", result.getName());
	}

	// Dummy internal test service to simulate a use case
	static class DummyService {
		private final PatientProfileRepository repo;

		DummyService(PatientProfileRepository repo) {
			this.repo = repo;
		}

		public PatientProfile getById(Long id) {
			return repo.findById(id).orElse(null);
		}
	}
}
