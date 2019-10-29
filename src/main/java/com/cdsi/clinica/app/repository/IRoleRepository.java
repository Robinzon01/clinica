package com.cdsi.clinica.app.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.cdsi.clinica.app.model.Role;


public interface IRoleRepository extends JpaRepository<Role, Long> {
	
}
