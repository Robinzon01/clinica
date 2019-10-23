package com.cdsi.clinica.app.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.cdsi.clinica.app.model.Specialty;

public interface SpecialtRepository extends PagingAndSortingRepository<Specialty, Long> {

	Page<Specialty> findAll(Pageable pageable);
}
