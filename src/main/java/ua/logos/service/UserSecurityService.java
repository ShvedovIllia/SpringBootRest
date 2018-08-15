package ua.logos.service;

import java.util.List;

import ua.logos.entity.UserSecurity;

public interface UserSecurityService {

	UserSecurity addUserSecurity(UserSecurity user);
	
	UserSecurity getById(Long id);
	
	UserSecurity getByUsername(String username);
	
	List<UserSecurity> getAll();
	
	void delete(Long id);
	
	
	
}
