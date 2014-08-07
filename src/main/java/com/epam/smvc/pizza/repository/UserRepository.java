package com.epam.smvc.pizza.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.epam.smvc.pizza.domain.User;

public class UserRepository {
	private List<User> users = new ArrayList<>();

	public List<User> getUsers() {
		return Collections.unmodifiableList(users);
	}

	public void addUser(final User user) {
		this.users.add(user);
	}
}
