package com.cdsi.clinica.app.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="detailconsultation")
public class DetailConsultation {
	@Id
    @GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	@Size(min=2, max=200, message="Ingrese el Diagnostico")
	private String diagnostic;
	@Size(min=2, max=200, message="Ingrese el tratamiento")
	private String treatment;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "id_med_con")
	private List<MedicalConsultation> medicalConsultation;
	
	public DetailConsultation() {
	}
	
	public DetailConsultation(@Size(min = 2, max = 200, message = "Ingrese el Diagnostico") String diagnostic,
			@Size(min = 2, max = 200, message = "Ingrese el tratamiento") String treatment,
			List<MedicalConsultation> medicalConsultation) {
		this.diagnostic = diagnostic;
		this.treatment = treatment;
		this.medicalConsultation = medicalConsultation;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDiagnostic() {
		return diagnostic;
	}
	public void setDiagnostic(String diagnostic) {
		this.diagnostic = diagnostic;
	}
	public String getTreatment() {
		return treatment;
	}
	public void setTreatment(String treatment) {
		this.treatment = treatment;
	}
	public List<MedicalConsultation> getMedicalConsultation() {
		return medicalConsultation;
	}
	public void setMedicalConsultation(List<MedicalConsultation> medicalConsultation) {
		this.medicalConsultation = medicalConsultation;
	}

}
