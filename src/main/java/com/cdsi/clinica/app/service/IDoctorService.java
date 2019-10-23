package com.cdsi.clinica.app.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cdsi.clinica.app.model.Doctor;

public interface IDoctorService {
	List<Doctor> getAllDoctors();

	Doctor createDoctor(Doctor doctor);

	Doctor updateDoctor(Long id, Doctor doctor);

	void deleteDoctor(Long id);

	Doctor findById(Long id);
	
	//Pagination
    Page<Doctor> findAll(Pageable pageable);
}
