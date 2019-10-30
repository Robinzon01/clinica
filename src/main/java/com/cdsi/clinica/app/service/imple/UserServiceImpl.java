package com.cdsi.clinica.app.service.imple;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cdsi.clinica.app.model.Users;
import com.cdsi.clinica.app.repository.IUserRepository;
@Service
public class UserServiceImpl implements UserDetailsService {
    
	@Autowired
	private IUserRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	   Users objU = userRepo.findByUserName(username);
	   List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
	   roles.add(new SimpleGrantedAuthority("ADMIN"));
	   UserDetails userDet = new User(objU.getUserName(),objU.getPassword(),roles);
	   return userDet;
	}
	
}
