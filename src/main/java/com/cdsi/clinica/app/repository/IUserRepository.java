package com.cdsi.clinica.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cdsi.clinica.app.model.Users;


@Repository
public interface IUserRepository extends JpaRepository<Users, Long> {
	 Users findByUserName(String userName);
}