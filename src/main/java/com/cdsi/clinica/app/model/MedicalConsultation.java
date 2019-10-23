package com.cdsi.clinica.app.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="medicalconsultation")
public class MedicalConsultation {
	
	@Id
    @GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	
	private Date createdate;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "id_doc")
	private Doctor doctor;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "id_pat")
	private Patient patient;
	
	public MedicalConsultation() {
	}

	public MedicalConsultation(Date createdate, Doctor doctor, Patient patient) {
		this.createdate = createdate;
		this.doctor = doctor;
		this.patient = patient;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
}
