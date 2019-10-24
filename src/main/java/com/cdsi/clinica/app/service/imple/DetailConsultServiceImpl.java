package com.cdsi.clinica.app.service.imple;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cdsi.clinica.app.exceptional.ResourceNotFoundException;
import com.cdsi.clinica.app.model.DetailConsultation;
import com.cdsi.clinica.app.repository.DetailConsultationRepository;
import com.cdsi.clinica.app.service.IDetailConsultationService;

@Service
public class DetailConsultServiceImpl implements IDetailConsultationService {
    
	@Autowired
	private DetailConsultationRepository detailConsultRepository;
	
	@Override
	public List<DetailConsultation> getAllDetailConsultations() {
 		List<DetailConsultation> detaConss = new ArrayList<>();
 		detailConsultRepository.findAll().iterator().forEachRemaining(detaConss::add);
 		return detaConss;
	}

	@Override
	public DetailConsultation createDetailConsultation(DetailConsultation detailConsultation) {
		DetailConsultation detailConsult = detailConsultRepository.save(detailConsultation);
		return detailConsult;
	}

	@Override
	public DetailConsultation updateDetailConsultation(Long id, DetailConsultation detailConsultation) {
		DetailConsultation objDC = findById(id);
		objDC.setDiagnostic(detailConsultation.getDiagnostic());
		objDC.setTreatment(detailConsultation.getTreatment());
		objDC.setMedicalConsultation(detailConsultation.getMedicalConsultation());
		detailConsultRepository.save(objDC);
		return objDC;
	}

	@Override
	public void deleteDetailConsultation(Long id) {
		// TODO Auto-generated method stub
		detailConsultRepository.delete(findById(id));
	}

	@Override
	public DetailConsultation findById(Long id) {
		Optional<DetailConsultation> detailConsult = detailConsultRepository.findById(id);
		if(!detailConsult.isPresent()) {
			throw new ResourceNotFoundException("El codigo de consulta de detalle no valido = " + id);
		}
		
		return detailConsult.get();
	}

	@Override
	public Page<DetailConsultation> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return detailConsultRepository.findAll(pageable);
	}

}
