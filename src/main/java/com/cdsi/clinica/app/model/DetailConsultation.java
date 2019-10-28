package com.cdsi.clinica.app.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity(name="detailconsultation")
@Table(name="detailconsultation")
public class DetailConsultation implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	@Size(min=2, max=200, message="Ingrese el Diagnostico")
	private String diagnostic;
	@Size(min=2, max=200, message="Ingrese el tratamiento")
	private String treatment;
	
	@NotNull
    @ManyToOne
    @JoinColumn(name = "id_med_con", insertable=false, updatable=false)
    private MedicalConsultation medicalConsultation;
	
	public DetailConsultation() {
	}
	
	public DetailConsultation(Long id, @Size(min = 2, max = 200, message = "Ingrese el Diagnostico") String diagnostic,
			@Size(min = 2, max = 200, message = "Ingrese el tratamiento") String treatment,
			@NotNull MedicalConsultation medicalConsultation) {
		
		this.id = id;
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


	public MedicalConsultation getMedicalConsultation() {
		return medicalConsultation;
	}


	public void setMedicalConsultation(MedicalConsultation medicalConsultation) {
		this.medicalConsultation = medicalConsultation;
	}


}
