package com.cdsi.clinica.app.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.cdsi.clinica.app.model.DetailConsultation;

@Repository
public interface DetailConsultationRepository extends PagingAndSortingRepository<DetailConsultation, Long> {
	
	Page<DetailConsultation> findAll(Pageable pageable);

}
