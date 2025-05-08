package com.cts.project.dto;

public class PatientProfileDTO {
	private String patientName;
	private String dateOfBirth;
	private int age;
	private String gender;
	private String bloodGroup;
	private String guardianName;
	private String contactNumber;
	private String email;
	private String address;
	private String medicalHistory;

	public PatientProfileDTO() {
		// TODO Auto-generated constructor stub
	}

	public PatientProfileDTO(String patientName, String dateOfBirth, int age, String gender, String bloodGroup,
			String guardianName, String contactNumber, String email, String address, String medicalHistory) {
		super();
		this.patientName = patientName;
		this.dateOfBirth = dateOfBirth;
		this.age = age;
		this.gender = gender;
		this.bloodGroup = bloodGroup;
		this.guardianName = guardianName;
		this.contactNumber = contactNumber;
		this.email = email;
		this.address = address;
		this.medicalHistory = medicalHistory;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getGuardianName() {
		return guardianName;
	}

	public void setGuardianName(String guardianName) {
		this.guardianName = guardianName;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMedicalHistory() {
		return medicalHistory;
	}

	public void setMedicalHistory(String medicalHistory) {
		this.medicalHistory = medicalHistory;
	}
	
}