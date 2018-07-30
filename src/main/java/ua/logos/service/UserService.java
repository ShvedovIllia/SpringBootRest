package ua.logos.service;

import java.util.List;

import ua.logos.entity.User;

public interface UserService {

	void saveUser(User user);

	User findById(Long id);

	List<User> findAllUsers();

}
