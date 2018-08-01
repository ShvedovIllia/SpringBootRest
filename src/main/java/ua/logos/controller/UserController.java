package ua.logos.controller;

import java.util.List;

import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ua.logos.domain.UserDTO;
import ua.logos.entity.User;
import ua.logos.service.UserService;

@RestController
@RequestMapping("users")

public class UserController {
	
	@Autowired
	private UserService userService;
	
//	@PostMapping
//	public ResponseEntity<Void> addUser(@RequestBody User user) {
//		userService.saveUser(user);
//		return new ResponseEntity<> (HttpStatus.CREATED);
//	}
//	
//	@GetMapping
//	public ResponseEntity<List<User>> showUsers(){
//		List <User> users = userService.findAllUsers();
//		return new ResponseEntity <List<User>> (users, HttpStatus.OK);
//	}
//	
	
	@PostMapping
	public ResponseEntity<Void> addUser(@RequestBody UserDTO userDTO){
		userService.saveUser(userDTO);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<UserDTO> getUserById(@PathVariable ("userId") Long id){
		UserDTO userDTO = userService.findById(id);
		return new ResponseEntity<UserDTO>(userDTO, HttpStatus.OK);
		
	}
	
	@GetMapping
	public ResponseEntity<List<UserDTO>> getAllUsers(){
		List <UserDTO> users = userService.findAllUsers();
		return new ResponseEntity<List<UserDTO>>(users,HttpStatus.OK);
		
	}
	
	@PutMapping("/{userId}")
	public ResponseEntity<Void> updateUser(@PathVariable ("userId") Long id, @RequestBody UserDTO userDTO){
		UserDTO user = userService.findById(id);
		if(user!=null) {
			userDTO.setId(id);
			userService.saveUser(userDTO);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		
	}
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<Void> deleteUser(@PathVariable("userId") Long id) {
		UserDTO user = userService.findById(id);
		if(user!=null) {

			userService.deleteUser(id);	
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		
	}

}
