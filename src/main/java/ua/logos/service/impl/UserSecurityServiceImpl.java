package ua.logos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ua.logos.entity.UserSecurity;
import ua.logos.repository.UserSecurityRepository;
import ua.logos.service.UserSecurityService;

@Service

public class UserSecurityServiceImpl implements UserSecurityService{
	
	private final UserSecurityRepository userRepository;
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	public UserSecurityServiceImpl(UserSecurityRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public UserSecurity addUserSecurity(UserSecurity user) {
		return userRepository.save(user);
	}

	@Override
	public UserSecurity getById(Long id) {
		return userRepository.findById(id).get();
	}

	@Override
	public UserSecurity getByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public List<UserSecurity> getAll() {
		return userRepository.findAll();
	}

	@Override
	public void delete(Long id) {
		userRepository.deleteById(id);
	}


}
