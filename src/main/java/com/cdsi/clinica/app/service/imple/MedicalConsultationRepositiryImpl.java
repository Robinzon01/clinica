package com.cdsi.clinica.app.service.imple;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cdsi.clinica.app.exceptional.ResourceNotFoundException;
import com.cdsi.clinica.app.model.MedicalConsultation;
import com.cdsi.clinica.app.repository.MedicalConsultRepository;
import com.cdsi.clinica.app.service.IMedicalConsultationService;

@Service
public class MedicalConsultationRepositiryImpl implements IMedicalConsultationService {
    
	@Autowired
	private MedicalConsultRepository mcRepository;
	@Override
	public List<MedicalConsultation> getAllMedicalConsultations() {
		// TODO Auto-generated method stub
		List<MedicalConsultation> objMCs = new ArrayList<>();
		mcRepository.findAll().iterator().forEachRemaining(objMCs::add);
		return objMCs;
	}

	@Override
	public MedicalConsultation createDoctor(MedicalConsultation medicalConsultation) {
		// TODO Auto-generated method stub
		 MedicalConsultation objMC = mcRepository.save(medicalConsultation);
		 return objMC;
	}

	@Override
	public MedicalConsultation updateMedicalConsultation(Long id, MedicalConsultation medicalConsultation) {
		// TODO Auto-generated method stub
		MedicalConsultation objMC = findById(id);
		objMC.setCreatedate(medicalConsultation.getCreatedate());
		objMC.setDoctor(medicalConsultation.getDoctor());
		objMC.setPatient(medicalConsultation.getPatient());
		mcRepository.save(objMC);
		return objMC;
	}

	@Override
	public void deleteMedicalConsultation(Long id) {
		// TODO Auto-generated method stub
		mcRepository.delete(findById(id));
	}

	@Override
	public MedicalConsultation findById(Long id) {
		Optional<MedicalConsultation> objMC = mcRepository.findById(id);
		if(!objMC.isPresent()) {
			throw new ResourceNotFoundException("El codigo de Consulta de Doctores no valido = " + id);
		}
		return objMC.get();
	}

	@Override
	public Page<MedicalConsultation> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return  mcRepository.findAll(pageable);
	}

}
