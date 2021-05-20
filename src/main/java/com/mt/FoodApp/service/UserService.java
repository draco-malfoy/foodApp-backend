package com.mt.FoodApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mt.FoodApp.model.User;
import com.mt.FoodApp.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public User addUser(User user) {
		return userRepository.save(user);
	}

	public User updateUser(User user) {
		Optional<User> existingUser = userRepository.findById(user.getId());
		if (user.getFirstName() != null)
			existingUser.get().setFirstName(user.getFirstName());
		if (user.getLastName() != null)
			existingUser.get().setLastName(user.getLastName());
		if (user.getPhoneNumber() != null)
			existingUser.get().setPhoneNumber(user.getPhoneNumber());
		if (user.getEmail() != null)
			existingUser.get().setEmail(user.getEmail());
		if (user.getAddress() != null)
			existingUser.get().setAddress(user.getAddress());
		if (user.getPinCode() != 0)
			existingUser.get().setPinCode(user.getPinCode());
		if (user.getCity() != null)
			existingUser.get().setCity(user.getCity());
		return userRepository.save(existingUser.get());
	}

	public Optional<User> findById(Long id) {
		return userRepository.findById(id);
	}

	public List<User> findAllUsers() {
		return userRepository.findAll();
	}

	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}
}
