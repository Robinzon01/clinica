package com.cdsi.clinica.app.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cdsi.clinica.app.model.Specialty;


public interface ISpecialtyService {
	List<Specialty> getAllServices();

	Specialty createSpecialty(Specialty specialty);

	Specialty updateSpecialty(Long id, Specialty specialty);

	void deleteSpecialty(Long specialtyId);

	Specialty findById(Long id);
	//Pagination
    Page<Specialty> findAll(Pageable pageable);
}
