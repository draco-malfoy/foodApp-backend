
package com.mt.FoodApp.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mt.FoodApp.exception.UserNotFoundException;
import com.mt.FoodApp.model.User;
import com.mt.FoodApp.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/getUsers")
	public ResponseEntity<List<User>> getUsers() {
		List<User> users = userService.findAllUsers();
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}

	@GetMapping("/getUserById/{id}")
	public ResponseEntity<User> getUsers(@PathVariable("id") long id) {
		Optional<User> user = userService.findById(id);
		if (user.get() == null) {
			throw new UserNotFoundException("User was not found.");
		}
		return new ResponseEntity<User>(user.get(), HttpStatus.OK);
	}

	@PostMapping("/addUser")
	public ResponseEntity<User> addUser(@Valid @RequestBody User inputUser) {
		User user = userService.addUser(inputUser);
		return new ResponseEntity<User>(user, HttpStatus.CREATED);
	}

	@PutMapping("/updateUser")
	public ResponseEntity<User> updateUser(@RequestBody User inputUser) {
		User user = userService.updateUser(inputUser);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@DeleteMapping("/deleteUser/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable("id") long id) {
		userService.deleteUser(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
