package com.cdsi.clinica.app.service.imple;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cdsi.clinica.app.exceptional.ResourceNotFoundException;
import com.cdsi.clinica.app.model.Doctor;
import com.cdsi.clinica.app.repository.DoctorRepository;
import com.cdsi.clinica.app.service.IDoctorService;

@Service
public class DoctorServiceImpl implements IDoctorService {
    @Autowired
	private DoctorRepository doctorRepository;

	@Override
	public List<Doctor> getAllDoctors() {
		List<Doctor> doctores = new ArrayList<>();
		doctorRepository.findAll().iterator().forEachRemaining(doctores::add);
		return doctores;
	}

	@Override
	public Doctor createDoctor(Doctor doctor) {
		Doctor newDoctor = doctorRepository.save(doctor);
		return newDoctor;
	}

	@Override
	public Doctor updateDoctor(Long id, Doctor doctor) {
		Doctor objDoctor = findById(id);
		
		objDoctor.setFirstname(doctor.getFirstname());
		objDoctor.setLastname(doctor.getLastname());
		objDoctor.setDni(doctor.getDni());
		objDoctor.setCmp(doctor.getCmp());
		doctorRepository.save(objDoctor);
		return objDoctor;
	}

	@Override
	public void deleteDoctor(Long id) {
		// TODO Auto-generated method stub
		doctorRepository.delete(findById(id));
	}

	@Override
	public Doctor findById(Long id) {
		Optional<Doctor> doctor = doctorRepository.findById(id);
		if (!doctor.isPresent()) {
            throw new ResourceNotFoundException("El codigo de Doctor no valido = " + id);
        }

		return doctor.get();
	}

	@Override
	public Page<Doctor> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return doctorRepository.findAll(pageable);
	}
    
    

}
