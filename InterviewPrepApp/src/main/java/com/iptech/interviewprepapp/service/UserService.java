package com.iptech.interviewprepapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iptech.interviewprepapp.domain.User;
import com.iptech.interviewprepapp.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepo;
	
	public List<User> findAll() {
		return userRepo.findAll();
	}
	public User findById(Long userId) {
		Optional<User> userOpt =  userRepo.findById(userId);
		return userOpt.orElse(new User());
	}
	public User save(User user) {
		return userRepo.save(user);
	}
	public User updateUser(User user, Long userId) {
		User existingUser = findById(userId);
		existingUser.setName(user.getName());
		existingUser.setPassword(user.getPassword());
		existingUser.setUsername(user.getUsername());	
		return userRepo.save(existingUser);
	}
	public void delete(Long userId) {
		userRepo.deleteById(userId);
	}
}
