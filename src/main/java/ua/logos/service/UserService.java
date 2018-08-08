package ua.logos.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import ua.logos.domain.UserDTO;
import ua.logos.domain.filter.SimpleFilter;

public interface UserService {

	void saveUser(UserDTO userDTO);

	UserDTO findById(Long id);

	List<UserDTO> findAllUsers();
	
	void deleteUser(Long id);
	
	List<UserDTO> findByPostId(Long id);
	
	List<UserDTO> findAllUsersBySpecification(SimpleFilter filter);
	
	List<UserDTO> findAllUsersByPages(Pageable pageble);

}
