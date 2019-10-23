package com.cdsi.clinica.app.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.cdsi.clinica.app.model.Patient;

public interface PatientRepository extends PagingAndSortingRepository<Patient, Long>{
	Page<Patient> findAll(Pageable pageable);
}
