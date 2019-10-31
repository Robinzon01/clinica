package com.cdsi.clinica.app.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="medicalconsultation")
public class MedicalConsultation implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	
	private Date createdate;
	
	@NotNull
    @ManyToOne
    @JoinColumn(name = "id_doc", insertable=false, updatable=false)
    private Doctor doctor;
	
    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_pat", insertable=false, updatable=false)
    private Patient patient;
	/*
	public MedicalConsultation() {
	}

	public MedicalConsultation(Date createdate, Doctor doctor, Patient patient) {
		this.createdate = createdate;
		this.doctor = doctor;
		this.patient = patient;
	}
*/
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
