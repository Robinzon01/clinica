package com.cdsi.clinica.app;

import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cdsi.clinica.app.model.Role;
import com.cdsi.clinica.app.model.Users;
import com.cdsi.clinica.app.repository.IRoleRepository;
import com.cdsi.clinica.app.repository.IUserRepository;

@SpringBootTest
class TrabajoMitocodeClinicaApplicationTests {
  @Autowired
  private IUserRepository userRepo;
  @Autowired
  private IRoleRepository roleRepo;

	@Test
	void contextLoads() {
        Optional<Role> objR = roleRepo.findById(1L);
		Users objU = new Users();
		//objU.setId(1L);
		objU.setPassword("123");
		objU.setUserName("lle");
		objU.setEnabled(true);
		objU.setRole(objR.get());
		Users u = userRepo.save(objU);
	
		assertTrue(u.getPassword().equalsIgnoreCase(objU.getPassword()));
	}

}
