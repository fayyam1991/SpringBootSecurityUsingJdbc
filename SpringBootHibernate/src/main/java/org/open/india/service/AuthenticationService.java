package org.open.india.service;

import org.open.india.model.User;

/**
 * 
 * @author Fayyam
 *
 */
public interface AuthenticationService {
	public User getUser(String userName);
}
