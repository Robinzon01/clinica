package com.cdsi.clinica.app.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.cdsi.clinica.app.model.MedicalConsultation;


public interface MedicalConsultRepository extends PagingAndSortingRepository<MedicalConsultation, Long> {
	Page<MedicalConsultation> findAll(Pageable pageable);
}
