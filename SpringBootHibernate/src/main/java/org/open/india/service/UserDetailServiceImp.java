package org.open.india.service;

import org.open.india.model.User;
import org.open.india.model.UserDetailsImp;
import org.open.india.repository.UserAuthenticationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * 
 * @author Fayyam
 *
 */
@Service
public class UserDetailServiceImp implements UserDetailsService {

	@Autowired
	private UserAuthenticationRepository loginRepository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		User user = loginRepository.getUser(userName);
		return new UserDetailsImp(user);
	}

}
