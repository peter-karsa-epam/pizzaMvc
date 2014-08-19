package com.epam.smvc.pizza.domain;

public class User {
	private String name;
	private String user;
	private String password;
	private boolean isAdmin;
	private String address;
	private String city;
	private String zipcode;
	private int phone;
	private String email;

	public User() {

	}

	public User(final String name, final String user, final String password,
			final boolean isAdmin, final String address, final String city,
			final String zipcode, final int phone, final String email) {
		this.name = name;
		this.user = user;
		this.password = password;
		this.isAdmin = isAdmin;
		this.address = address;
		this.city = city;
		this.zipcode = zipcode;
		this.phone = phone;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(final String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(final String city) {
		this.city = city;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(final String zipcode) {
		this.zipcode = zipcode;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(final int phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	public String getUser() {
		return user;
	}

	public void setUser(final String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(final String password) {
		this.password = password;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(final boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
}
