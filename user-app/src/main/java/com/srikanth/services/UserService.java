package com.srikanth.services;

import org.springframework.stereotype.Service;

import com.srikanth.model.User;
import com.srikanth.repo.UserRepository;

@Service
public class UserService {

	private final UserRepository repository;

	public UserService(UserRepository repository) {
		this.repository = repository;
	}

	public User saveUser(User user) {
		return repository.save(user);
	}
}
