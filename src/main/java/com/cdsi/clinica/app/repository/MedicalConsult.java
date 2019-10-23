package com.cdsi.clinica.app.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface MedicalConsult extends PagingAndSortingRepository<MedicalConsult, Long> {
	Page<MedicalConsult> findAll(Pageable pageable);
}
