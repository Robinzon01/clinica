package com.cdsi.clinica.app;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.cdsi.clinica.app.model.Users;
import com.cdsi.clinica.app.repository.IUserRepository;

@SpringBootTest
class TrabajoMitocodeClinicaApplicationTests {
  @Autowired
  private IUserRepository userRepo;
  /*
  @Autowired
  private IRoleRepository roleRepo;
  */
  @Autowired
  private BCryptPasswordEncoder encorder;

	@Test
	void contextLoads() {
       // Optional<Role> objR = roleRepo.findById(1L);
		Users objU = new Users();
		//objU.setId(1L);
		objU.setPassword( encorder.encode("GEN") ); // rsl -- 123
		objU.setUserName("GEN");
		objU.setEnabled(true);
		objU.setUser_id(2L);
		
		Users u = userRepo.save(objU);
	
		assertTrue(u.getPassword().equalsIgnoreCase(objU.getPassword()));
	}

}
