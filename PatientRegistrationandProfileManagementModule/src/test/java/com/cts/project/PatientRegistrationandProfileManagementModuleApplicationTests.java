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

import com.cts.project.dto.PatientProfileDTO;
import com.cts.project.exception.PatientNotFoundException;
import com.cts.project.model.PatientProfile;
import com.cts.project.repository.PatientProfileRepository;
import com.cts.project.service.PatientProfileServiceImpl;

@SpringBootTest
class PatientRegistrationandProfileManagementModuleApplicationTests {

//	@Test
//	void contextLoads() {
//	}
	@InjectMocks
    private PatientProfileServiceImpl service;
 
    @Mock
    private PatientProfileRepository repository;
 
    private PatientProfile samplePatient;
 
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        samplePatient = new PatientProfile();
//        samplePatient.setId(1L);
        samplePatient.setPatientName("John Doe");
        samplePatient.setDateOfBirth("1990-01-01");
        samplePatient.setGender("Male");
        samplePatient.setAge(34);
        samplePatient.setBloodGroup("A+");
        samplePatient.setGuardianName("Jane Doe");
        samplePatient.setContactNumber("9876543210");
        samplePatient.setEmail("john.doe@example.com");
        samplePatient.setAddress("123 Main St");
        samplePatient.setMedicalHistory("Allergy to penicillin");
    }
 
    @Test
    void testCreatePatientProfile() {
        PatientProfileDTO dto = new PatientProfileDTO();
        dto.setPatientName("John Doe");
        dto.setDateOfBirth("1990-01-01");
        dto.setGender("Male");
        dto.setAge(34);
        dto.setBloodGroup("A+");
        dto.setGuardianName("Jane Doe");
        dto.setContactNumber("9876543210");
        dto.setEmail("john.doe@example.com");
        dto.setAddress("123 Main St");
        dto.setMedicalHistory("Allergy to penicillin");
 
        when(repository.save(any(PatientProfile.class))).thenReturn(samplePatient);
        String result = service.createPatient(dto);
 
        assertEquals("Patient profile created successfully.", result);
        verify(repository, times(1)).save(any(PatientProfile.class));
    }
 
    @Test
    void testGetPatientProfileById_Success() {
        when(repository.findById(1L)).thenReturn(Optional.of(samplePatient));
        PatientProfile result = service.getPatientById(1L);
 
        assertEquals("John Doe", result.getPatientName());
    }
 
    @Test
    void testGetPatientProfileById_NotFound() {
        when(repository.findById(1L)).thenReturn(Optional.empty());
        assertThrows(PatientNotFoundException.class, () -> service.getPatientById(1L));
    }
 
    @Test
    void testGetAllPatientProfiles() {
        when(repository.findAll()).thenReturn(Arrays.asList(samplePatient));
        List<PatientProfile> result = service.getAllPatients();
 
        assertEquals(1, result.size());
    }
 
    @Test
    void testUpdatePatientProfile_Success() {
        PatientProfileDTO dto = new PatientProfileDTO();
        dto.setAddress("456 New St");
 
        when(repository.findById(1L)).thenReturn(Optional.of(samplePatient));
        String result = service.updatePatient(1L, dto);
 
        assertEquals("Patient profile updated successfully.", result);
        verify(repository, times(1)).save(samplePatient);
    }
 
    @Test
    void testDeletePatientProfile_Success() {
        when(repository.findById(1L)).thenReturn(Optional.of(samplePatient));
        String result = service.deletePatient(1L);
 
        assertEquals("Patient profile deleted successfully.", result);
        verify(repository, times(1)).delete(samplePatient);
    }
}
