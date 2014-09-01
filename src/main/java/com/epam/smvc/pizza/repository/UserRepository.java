package com.epam.smvc.pizza.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.epam.smvc.pizza.domain.User;

@Repository
public class UserRepository {
	private List<User> users = new ArrayList<>();

	//just for test
	public UserRepository() {
		User user = new User();
		user.setUser("joe");
		user.setName("Joe Singleton");
		user.setPassword("12345");
		user.setAdmin(false);
		user.setAddress("Barker str. 27/a");
		user.setCity("Avonmouth");
		user.setEmail("joe_smith@gcom.co.uk");
		user.setPhone(0044233242355);
		user.setZipcode("bsd 4gs");
		users.add(user);
		
		User user1 = new User();
		user1.setUser("joe1");
		user1.setName("Joe Doubleton");
		user1.setPassword("12345");
		user1.setAdmin(false);
		user1.setAddress("Mayer str. 64");
		user1.setCity("Clifton");
		user1.setEmail("joe_johnson@gcom.co.uk");
		user1.setPhone(0044233455355);
		user1.setZipcode("bsd 4js");
		users.add(user1);
	}

	public List<User> getUsers() {
		return Collections.unmodifiableList(users);
	}

	public void addUser(final User user) {
		this.users.add(user);
	}
}
