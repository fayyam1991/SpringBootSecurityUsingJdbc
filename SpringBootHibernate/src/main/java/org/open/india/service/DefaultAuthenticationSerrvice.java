package org.open.india.service;

import org.open.india.model.User;
import org.open.india.repository.UserAuthenticationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultAuthenticationSerrvice implements AuthenticationService {

	@Autowired
	private UserAuthenticationRepository loginRepository;

	@Override
	public User getUser(String userName) {
		return loginRepository.getUser(userName);
	}

}
