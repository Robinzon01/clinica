package com.cdsi.clinica.app.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.cdsi.clinica.app.model.MedicalConsultation;

public interface IMedicalConsultationService {
	List<MedicalConsultation> getAllMedicalConsultations();

	MedicalConsultation createDoctor(MedicalConsultation medicalConsultation);

	MedicalConsultation updateMedicalConsultation(Long id, MedicalConsultation medicalConsultation);

	void deleteMedicalConsultation(Long id);

	MedicalConsultation findById(Long id);
	
	//Pagination
    Page<MedicalConsultation> findAll(Pageable pageable);
}
