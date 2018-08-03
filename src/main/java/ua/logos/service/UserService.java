package ua.logos.service;

import java.util.List;

import ua.logos.domain.UserDTO;

public interface UserService {

	void saveUser(UserDTO userDTO);

	UserDTO findById(Long id);

	List<UserDTO> findAllUsers();
	
	void deleteUser(Long id);
	
	List<UserDTO> findByPostId(Long id);

}
