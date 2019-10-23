package com.cdsi.clinica.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.Type;

@Entity
@Table(name="specialty")
public class Specialty {
	@Id
    @GeneratedValue(strategy= GenerationType.AUTO)
	private long id;
	
	@Type(type = "org.hibernate.type.TextType") //heroku config
    @NotEmpty(message="Dede ingresar el nombre de la especialidad.")
	private String name;
    
	public Specialty() {
		
	}

	public Specialty(@NotEmpty(message = "Dede ingresar el nombre de la especialidad.") String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
