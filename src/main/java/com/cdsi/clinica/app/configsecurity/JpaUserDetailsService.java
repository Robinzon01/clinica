package com.cdsi.clinica.app.configsecurity;

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
import org.springframework.transaction.annotation.Transactional;

import com.cdsi.clinica.app.model.Role;
import com.cdsi.clinica.app.model.Users;
import com.cdsi.clinica.app.repository.IUserRepository;


@Service
public class JpaUserDetailsService implements UserDetailsService {

	@Autowired
	private IUserRepository userRepository;
	
	
	@Transactional(readOnly = true)
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Users user = userRepository.findByUserName(userName);
		
		if (user == null) {
            throw new UsernameNotFoundException(userName);
        }
		
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		Role objR = user.getRole();
		//for (Role role : user.getRole() ) {
			authorities.add(new SimpleGrantedAuthority(objR.getAuthority()));
		//}
		
		return new User(user.getUserName(), user.getPassword(), user.getEnabled(), true, true, true, authorities);
	}

}