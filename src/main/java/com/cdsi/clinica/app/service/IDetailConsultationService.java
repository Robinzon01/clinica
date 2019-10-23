package com.cdsi.clinica.app.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cdsi.clinica.app.model.DetailConsultation;

public interface IDetailConsultationService {
	List<DetailConsultation> getAllDetailConsultations();

	DetailConsultation createDetailConsultation(DetailConsultation detailConsultation);

	DetailConsultation updateDetailConsultation(Long id, DetailConsultation detailConsultation);

	void deleteDetailConsultation(Long Id);

	DetailConsultation findById(Long id);
	
	//Pagination
    Page<DetailConsultation> findAll(Pageable pageable);
}
