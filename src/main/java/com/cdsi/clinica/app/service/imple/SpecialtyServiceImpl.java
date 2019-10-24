package com.cdsi.clinica.app.service.imple;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cdsi.clinica.app.exceptional.ResourceNotFoundException;
import com.cdsi.clinica.app.model.Specialty;
import com.cdsi.clinica.app.repository.SpecialtRepository;
import com.cdsi.clinica.app.service.ISpecialtyService;

@Service
public class SpecialtyServiceImpl implements ISpecialtyService {
    @Autowired
	private SpecialtRepository specialRepo;

	@Override
	public List<Specialty> getAllServices() {
		// TODO Auto-generated method stub
		List<Specialty> objSs= new ArrayList<Specialty>();
		specialRepo.findAll().iterator().forEachRemaining(objSs::add);
		return objSs;
	}

	@Override
	public Specialty createSpecialty(Specialty specialty) {
		// TODO Auto-generated method stub
		Specialty objS = specialRepo.save(specialty);
		return objS;
	}

	@Override
	public Specialty updateSpecialty(Long id, Specialty specialty) {
		// TODO Auto-generated method stub
		Specialty objS = findById(id);
		objS.setName(specialty.getName());
		specialRepo.save(objS);
		return objS;
	}

	@Override
	public void deleteSpecialty(Long specialtyId) {
		// TODO Auto-generated method stub
		specialRepo.delete(findById(specialtyId));
	}

	@Override
	public Specialty findById(Long id) {
		// TODO Auto-generated method stub
		Optional<Specialty> objS = specialRepo.findById(id);
		if(!objS.isPresent()) {
			throw new ResourceNotFoundException("El codigo de Especialidad no valido = " + id);
		}
		return objS.get();
	}

	@Override
	public Page<Specialty> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return specialRepo.findAll(pageable);
	}
}
