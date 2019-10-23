package com.cdsi.clinica.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="patient")
public class Patient {
	@Id
    @GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	@Size(min=2, max=100, message="Ingrese el Nombre")
	private String firstname;
	@Size(min=2, max=100, message="Ingrese el Apellido")
	private String lastname;
	@Size(max=8, message="Ingrese el DNI")
	private String dni;
	@Size(min=2, max=100, message="Ingrese la historia clinica")
	private String numberclinicalhistory;
	
	public Patient() {
	}

	public Patient( @Size(min = 2, max = 100, message = "Ingrese el Nombre") String firstname,
			@Size(min = 2, max = 100, message = "Ingrese el Apellido") String lastname,
			@Size(max = 8, message = "Ingrese el DNI") String dni,
			@Size(min = 2, max = 100, message = "Ingrese la historia clinica") String numberclinicalhistory) {

		this.firstname = firstname;
		this.lastname = lastname;
		this.dni = dni;
		this.numberclinicalhistory = numberclinicalhistory;
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
	public String getNumberclinicalhistory() {
		return numberclinicalhistory;
	}
	public void setNumberclinicalhistory(String numberclinicalhistory) {
		this.numberclinicalhistory = numberclinicalhistory;
	}
	
	
	
}
