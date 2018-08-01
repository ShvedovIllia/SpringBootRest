package ua.logos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.logos.domain.UserDTO;
import ua.logos.entity.User;
import ua.logos.repository.BookRepository;
import ua.logos.repository.UserRepository;
import ua.logos.service.UserService;
import ua.logos.service.util.ObjectMapperUtils;

@Service

public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	ObjectMapperUtils modelMapper;

	@Override
	public void saveUser(UserDTO userDTO) {

		User userEntity = modelMapper.map(userDTO, User.class);
		
		userRepository.save(userEntity);
	}

	@Override
	public UserDTO findById(Long id) {
		User userEntity = userRepository.findById(id).get();
		UserDTO userDTO = modelMapper.map(userEntity, UserDTO.class);
		
		return userDTO;
	}

	@Override
	public List<UserDTO> findAllUsers() {
		
		List<User> usersEntity = userRepository.findAll();
		List<UserDTO> usersDTO = modelMapper.mapAll(usersEntity, UserDTO.class);
		return usersDTO;
	}

	@Override
	public void deleteUser(Long id) {
		
		userRepository.deleteById(id);
		
	}

}
