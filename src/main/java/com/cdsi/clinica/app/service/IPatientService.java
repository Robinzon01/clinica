package com.cdsi.clinica.app.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cdsi.clinica.app.model.Patient;

public interface IPatientService {
	List<Patient> getAllPatients();

	Patient createPatient(Patient patient);

	Patient updatePatient(Long id, Patient patient);

	void deletePatient(Long patientId);

	Patient findById(Long id);
	
	//Pagination
    Page<Patient> findAll(Pageable pageable);
}
