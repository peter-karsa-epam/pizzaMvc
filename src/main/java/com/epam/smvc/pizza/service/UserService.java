package com.epam.smvc.pizza.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.smvc.pizza.domain.User;
import com.epam.smvc.pizza.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository repository;

	public void addUser(final User user) {
		this.repository.addUser(user);
	}

	public List<User> getRepository() {
		return repository.getUsers();
	}
}
