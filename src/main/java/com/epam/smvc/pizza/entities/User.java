package com.epam.smvc.pizza.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7649039836173715669L;
	private int id;
	private String name;
	private String city;
	private String address;
	private String zipcode;
	private String phone;
	private String email;
	private String user;
	private String password;
	private boolean isAdmin;

	public User() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * public User(final String name, final String city, final String address,
	 * final String zipcode, final String phone, final String email, final
	 * String user, final String password, final boolean isAdmin, final int id)
	 * { this.name = name; this.city = city; this.address = address;
	 * this.zipcode = zipcode; this.phone = phone; this.email = email; this.user
	 * = user; this.password = password; this.isAdmin = isAdmin; this.id = id; }
	 */

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	protected void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
}
