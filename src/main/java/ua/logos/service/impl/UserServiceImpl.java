package ua.logos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.logos.entity.User;
import ua.logos.repository.UserRepository;
import ua.logos.service.UserService;

@Service

public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void saveUser(User user) {
		userRepository.save(user);
	}

	@Override
	public User findById(Long id) {
		userRepository.findById(id);
		return null;
	}

	@Override
	public List<User> findAllUsers() {
		return userRepository.findAll();
	}

}
