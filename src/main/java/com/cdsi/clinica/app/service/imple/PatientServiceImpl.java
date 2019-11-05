package com.cdsi.clinica.app.service.imple;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cdsi.clinica.app.exceptional.ResourceNotFoundException;
import com.cdsi.clinica.app.model.Patient;
import com.cdsi.clinica.app.repository.PatientRepository;
import com.cdsi.clinica.app.service.IPatientService;

@Service
public class PatientServiceImpl implements IPatientService {
    @Autowired
	private PatientRepository patientRepo;
	
	@Override
	public List<Patient> getAllPatients() {
		// TODO Auto-generated method stub
		List<Patient> objPs = new ArrayList<Patient>();
		patientRepo.findAll().iterator().forEachRemaining(objPs::add);
		return objPs;
	}

	@Override
	public Patient createPatient(Patient patient) {
		// TODO Auto-generated method stub
		Patient objP = patientRepo.save(patient);
		return objP;
	}

	@Override
	public Patient updatePatient(Long id, Patient patient) {
		// TODO Auto-generated method stub
		Patient objP = findById(id);
		objP.setFirstname(patient.getFirstname());
		objP.setLastname(patient.getLastname());
		objP.setDni(patient.getDni());
		objP.setHistoria(patient.getHistoria());
		
		patientRepo.save(objP);
		
		return objP;
		
	}

	@Override
	public void deletePatient(Long patientId) {
		// TODO Auto-generated method stub
		patientRepo.delete(findById(patientId));
	}

	@Override
	public Patient findById(Long id) {
		// TODO Auto-generated method stub
		Optional<Patient> objP = patientRepo.findById(id);
		if(!objP.isPresent()) {
			throw new ResourceNotFoundException("El codigo de Paciente no valido = " + id);
		}
		return objP.get();
	}

	@Override
	public Page<Patient> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return patientRepo.findAll(pageable);
	}

}
