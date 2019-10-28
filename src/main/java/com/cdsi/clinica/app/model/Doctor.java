package com.cdsi.clinica.app.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity(name="doctor")
@Table(name="doctor")
public class Doctor implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
    
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "id_spe")
    private Specialty specialty;

	public Doctor() {}

	public Doctor(@Size(min = 2, max = 100, message = "Ingrese el Nombre") String firstname,
			@Size(min = 2, max = 100, message = "Ingrese el Apellido") String lastname,
			@Size(max = 8, message = "Ingrese el DNI") String dni, String cmp, Specialty specialty) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.dni = dni;
		this.cmp = cmp;
		this.specialty = specialty;
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

	public Specialty getSpecialty() {
		return specialty;
	}

	public void setSpecialty(Specialty specialty) {
		this.specialty = specialty;
	}  
    
}
