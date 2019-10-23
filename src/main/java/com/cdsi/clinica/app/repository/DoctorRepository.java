package com.cdsi.clinica.app.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.cdsi.clinica.app.model.Doctor;

@Repository
public interface DoctorRepository extends PagingAndSortingRepository<Doctor, Long> {
	Page<Doctor> findAll(Pageable pageable);
}
