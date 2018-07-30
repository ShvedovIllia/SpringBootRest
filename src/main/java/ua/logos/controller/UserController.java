package ua.logos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ua.logos.entity.User;
import ua.logos.service.UserService;

@RestController
@RequestMapping("users")

public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping
	public ResponseEntity<Void> addUser(@RequestBody User user) {
		userService.saveUser(user);
		return new ResponseEntity<> (HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<User>> showUsers(){
		List <User> users = userService.findAllUsers();
		return new ResponseEntity <List<User>> (users, HttpStatus.OK);
	}
	
	

}
