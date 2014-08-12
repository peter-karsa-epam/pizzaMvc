package com.epam.smvc.pizza.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.epam.smvc.pizza.domain.User;

@Repository
public class UserRepository {
	private List<User> users = new ArrayList<>();

	public UserRepository() {
		User user = new User();
		user.setUser("joe");
		user.setPassword("12345");
		user.setAdmin(true);
		users.add(user);
	}

	public List<User> getUsers() {
		return Collections.unmodifiableList(users);
	}

	public void addUser(final User user) {
		this.users.add(user);
	}
}
