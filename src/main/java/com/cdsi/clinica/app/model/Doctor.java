package com.cdsi.clinica.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="doctor")
public class Doctor {

	@Id
    @GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
    
    @Size(min=2, max=100, message="Ingrese el Nombre")
    private String firstname;
    
    @Size(min=2, max=100, message="Ingrese el Apellido")
    private String lastname;
    
    @Size(max=8,message = "Ingrese el DNI")
    private String dni;
    
    private String cmp;
    
    private Long id_spe;
       
    @ManyToOne
    @JoinColumn(name = "id_spe", insertable=false, updatable=false)
    private Specialty specialty;

	public Doctor() {}

	public Doctor(Long id, @Size(min = 2, max = 100, message = "Ingrese el Nombre") String firstname,
			@Size(min = 2, max = 100, message = "Ingrese el Apellido") String lastname,
			@Size(max = 8, message = "Ingrese el DNI") String dni, String cmp, Long id_spe) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.dni = dni;
		this.cmp = cmp;
		this.id_spe = id_spe;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getCmp() {
		return cmp;
	}

	public void setCmp(String cmp) {
		this.cmp = cmp;
	}
	
	public Long getId_spe() {
		return id_spe;
	}

	public void setId_spe(Long id_spe) {
		this.id_spe = id_spe;
	}

	public Specialty getSpecialty() {
		return specialty;
	}
	public void setSpecialty(Specialty specialty) {
		this.specialty = specialty;
	}

    
}
